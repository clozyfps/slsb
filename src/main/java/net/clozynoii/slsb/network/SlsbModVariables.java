package net.clozynoii.slsb.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.clozynoii.slsb.SlsbMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SlsbModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		SlsbMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		SlsbMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.JoinedWorld = original.JoinedWorld;
			clone.PlayerTimer = original.PlayerTimer;
			clone.HunterClass = original.HunterClass;
			clone.Rank = original.Rank;
			clone.Mana = original.Mana;
			clone.ChestplateSave = original.ChestplateSave;
			clone.Cooldown = original.Cooldown;
			clone.MoveOn = original.MoveOn;
			clone.Cost = original.Cost;
			clone.ColorCode = original.ColorCode;
			clone.Move2 = original.Move2;
			clone.Move1 = original.Move1;
			clone.Move4 = original.Move4;
			clone.LeggingsSave = original.LeggingsSave;
			clone.Move3 = original.Move3;
			clone.BootsSave = original.BootsSave;
			clone.CurrentMove = original.CurrentMove;
			clone.HelmetSave = original.HelmetSave;
			clone.Aura = original.Aura;
			clone.ManaMax = original.ManaMax;
			clone.MoveSelected = original.MoveSelected;
			clone.SkillCooldown = original.SkillCooldown;
			clone.HealActive = original.HealActive;
			clone.Mastery = original.Mastery;
			if (!event.isWasDeath()) {
				clone.StealthActive = original.StealthActive;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					SlsbMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					SlsbMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					SlsbMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "slsb_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				SlsbMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "slsb_mapvars";
		public boolean WorldCreated = false;
		public double GateTimer = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			WorldCreated = nbt.getBoolean("WorldCreated");
			GateTimer = nbt.getDouble("GateTimer");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("WorldCreated", WorldCreated);
			nbt.putDouble("GateTimer", GateTimer);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				SlsbMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("slsb", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean JoinedWorld = false;
		public double PlayerTimer = 0;
		public String HunterClass = "";
		public String Rank = "";
		public double Mana = 0;
		public boolean StealthActive = false;
		public ItemStack ChestplateSave = ItemStack.EMPTY;
		public double Cooldown = 0;
		public double MoveOn = 1.0;
		public double Cost = 0;
		public String ColorCode = "";
		public String Move2 = "";
		public String Move1 = "";
		public String Move4 = "";
		public ItemStack LeggingsSave = ItemStack.EMPTY;
		public String Move3 = "";
		public ItemStack BootsSave = ItemStack.EMPTY;
		public String CurrentMove = "";
		public ItemStack HelmetSave = ItemStack.EMPTY;
		public String Aura = "";
		public double ManaMax = 150.0;
		public String MoveSelected = "";
		public double SkillCooldown = 0;
		public boolean HealActive = false;
		public double Mastery = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				SlsbMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("JoinedWorld", JoinedWorld);
			nbt.putDouble("PlayerTimer", PlayerTimer);
			nbt.putString("HunterClass", HunterClass);
			nbt.putString("Rank", Rank);
			nbt.putDouble("Mana", Mana);
			nbt.putBoolean("StealthActive", StealthActive);
			nbt.put("ChestplateSave", ChestplateSave.save(new CompoundTag()));
			nbt.putDouble("Cooldown", Cooldown);
			nbt.putDouble("MoveOn", MoveOn);
			nbt.putDouble("Cost", Cost);
			nbt.putString("ColorCode", ColorCode);
			nbt.putString("Move2", Move2);
			nbt.putString("Move1", Move1);
			nbt.putString("Move4", Move4);
			nbt.put("LeggingsSave", LeggingsSave.save(new CompoundTag()));
			nbt.putString("Move3", Move3);
			nbt.put("BootsSave", BootsSave.save(new CompoundTag()));
			nbt.putString("CurrentMove", CurrentMove);
			nbt.put("HelmetSave", HelmetSave.save(new CompoundTag()));
			nbt.putString("Aura", Aura);
			nbt.putDouble("ManaMax", ManaMax);
			nbt.putString("MoveSelected", MoveSelected);
			nbt.putDouble("SkillCooldown", SkillCooldown);
			nbt.putBoolean("HealActive", HealActive);
			nbt.putDouble("Mastery", Mastery);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			JoinedWorld = nbt.getBoolean("JoinedWorld");
			PlayerTimer = nbt.getDouble("PlayerTimer");
			HunterClass = nbt.getString("HunterClass");
			Rank = nbt.getString("Rank");
			Mana = nbt.getDouble("Mana");
			StealthActive = nbt.getBoolean("StealthActive");
			ChestplateSave = ItemStack.of(nbt.getCompound("ChestplateSave"));
			Cooldown = nbt.getDouble("Cooldown");
			MoveOn = nbt.getDouble("MoveOn");
			Cost = nbt.getDouble("Cost");
			ColorCode = nbt.getString("ColorCode");
			Move2 = nbt.getString("Move2");
			Move1 = nbt.getString("Move1");
			Move4 = nbt.getString("Move4");
			LeggingsSave = ItemStack.of(nbt.getCompound("LeggingsSave"));
			Move3 = nbt.getString("Move3");
			BootsSave = ItemStack.of(nbt.getCompound("BootsSave"));
			CurrentMove = nbt.getString("CurrentMove");
			HelmetSave = ItemStack.of(nbt.getCompound("HelmetSave"));
			Aura = nbt.getString("Aura");
			ManaMax = nbt.getDouble("ManaMax");
			MoveSelected = nbt.getString("MoveSelected");
			SkillCooldown = nbt.getDouble("SkillCooldown");
			HealActive = nbt.getBoolean("HealActive");
			Mastery = nbt.getDouble("Mastery");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.JoinedWorld = message.data.JoinedWorld;
					variables.PlayerTimer = message.data.PlayerTimer;
					variables.HunterClass = message.data.HunterClass;
					variables.Rank = message.data.Rank;
					variables.Mana = message.data.Mana;
					variables.StealthActive = message.data.StealthActive;
					variables.ChestplateSave = message.data.ChestplateSave;
					variables.Cooldown = message.data.Cooldown;
					variables.MoveOn = message.data.MoveOn;
					variables.Cost = message.data.Cost;
					variables.ColorCode = message.data.ColorCode;
					variables.Move2 = message.data.Move2;
					variables.Move1 = message.data.Move1;
					variables.Move4 = message.data.Move4;
					variables.LeggingsSave = message.data.LeggingsSave;
					variables.Move3 = message.data.Move3;
					variables.BootsSave = message.data.BootsSave;
					variables.CurrentMove = message.data.CurrentMove;
					variables.HelmetSave = message.data.HelmetSave;
					variables.Aura = message.data.Aura;
					variables.ManaMax = message.data.ManaMax;
					variables.MoveSelected = message.data.MoveSelected;
					variables.SkillCooldown = message.data.SkillCooldown;
					variables.HealActive = message.data.HealActive;
					variables.Mastery = message.data.Mastery;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
