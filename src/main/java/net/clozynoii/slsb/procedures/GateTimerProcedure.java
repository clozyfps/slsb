package net.clozynoii.slsb.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.clozynoii.slsb.network.SlsbModVariables;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class GateTimerProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		boolean Singular = false;
		String GateRank = "";
		double RandomX = 0;
		double RandomY = 0;
		double RandomZ = 0;
		double GateRandomize = 0;
		if (SlsbModVariables.MapVariables.get(world).GateTimer > 0) {
			SlsbModVariables.MapVariables.get(world).GateTimer = SlsbModVariables.MapVariables.get(world).GateTimer - 1;
			SlsbModVariables.MapVariables.get(world).syncData(world);
		}
		if (SlsbModVariables.MapVariables.get(world).GateTimer == 0) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (Singular == false) {
					Singular = true;
					RandomX = Mth.nextInt(RandomSource.create(), (int) (entityiterator.getX() - 250), (int) (entityiterator.getX() + 250));
					RandomY = Mth.nextInt(RandomSource.create(), 63, 100);
					RandomZ = Mth.nextInt(RandomSource.create(), (int) (entityiterator.getZ() - 250), (int) (entityiterator.getZ() + 250));
				}
			}
			if (world.getBlockState(BlockPos.containing(RandomX, RandomY, RandomZ)).canOcclude() && (world.getBlockState(BlockPos.containing(RandomX, RandomY + 1, RandomZ))).getBlock() == Blocks.AIR) {
				SlsbModVariables.MapVariables.get(world).GateTimer = Mth.nextInt(RandomSource.create(), 18000, 30000);
				SlsbModVariables.MapVariables.get(world).syncData(world);
				GateRandomize = Mth.nextInt(RandomSource.create(), 1, 20);
				if (GateRandomize >= 1 && GateRandomize < 5) {
					GateRank = "\u00A7f\u00A7lE-Rank";
				}
				if (GateRandomize >= 5 && GateRandomize < 10) {
					GateRank = "\u00A7a\u00A7lD-Rank";
				}
				if (GateRandomize >= 10 && GateRandomize < 15) {
					GateRank = "\u00A7d\u00A7lC-Rank";
				}
				if (GateRandomize >= 15 && GateRandomize < 18) {
					GateRank = "\u00A7b\u00A7lB-Rank";
				}
				if (GateRandomize >= 18 && GateRandomize < 20) {
					GateRank = "\u00A7e\u00A7lA-Rank";
				}
				if (GateRandomize == 20) {
					GateRank = "\u00A7c\u00A7lS-Rank";
				}
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A7f\u00A7lA " + GateRank + " \u00A7f\u00A7lGate Has Opened At: \u00A7f" + new java.text.DecimalFormat("##").format(RandomX) + " "
							+ new java.text.DecimalFormat("##").format(RandomY + 1) + " " + new java.text.DecimalFormat("##").format(RandomZ))), false);
			}
		}
	}
}
