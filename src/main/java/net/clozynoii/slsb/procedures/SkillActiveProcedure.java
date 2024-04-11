package net.clozynoii.slsb.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SkillActiveProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

private static void execute(
@Nullable Event event,
Entity entity
) {
if(
entity == null
) return ;
if (!((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).CurrentMove).isEmpty()) {if (((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).CurrentMove).equals("Stealth")) {if (!(entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).StealthActive) {{
boolean _setval = true;
entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.StealthActive = _setval;
capability.syncPlayerVariables(entity);
});
}
{
ItemStack _setval = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD):ItemStack.EMPTY);
entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.HelmetSave = _setval;
capability.syncPlayerVariables(entity);
});
}
{
ItemStack _setval = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST):ItemStack.EMPTY);
entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.ChestplateSave = _setval;
capability.syncPlayerVariables(entity);
});
}
{
ItemStack _setval = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS):ItemStack.EMPTY);
entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.LeggingsSave = _setval;
capability.syncPlayerVariables(entity);
});
}
{
ItemStack _setval = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET):ItemStack.EMPTY);
entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.BootsSave = _setval;
capability.syncPlayerVariables(entity);
});
}
{
Entity _entity = entity;
if (_entity instanceof Player _player) {
_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
_player.getInventory().setChanged();
} else if (_entity instanceof LivingEntity _living) {
_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
}
}{
Entity _entity = entity;
if (_entity instanceof Player _player) {
_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
_player.getInventory().setChanged();
} else if (_entity instanceof LivingEntity _living) {
_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
}
}{
Entity _entity = entity;
if (_entity instanceof Player _player) {
_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
_player.getInventory().setChanged();
} else if (_entity instanceof LivingEntity _living) {
_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
}
}{
Entity _entity = entity;
if (_entity instanceof Player _player) {
_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
_player.getInventory().setChanged();
} else if (_entity instanceof LivingEntity _living) {
_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
}
}}else if ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).StealthActive) {{
boolean _setval = false;
entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.StealthActive = _setval;
capability.syncPlayerVariables(entity);
});
}
{
Entity _entity = entity;
if (_entity instanceof Player _player) {
_player.getInventory().armor.set(3, ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).HelmetSave)
);
_player.getInventory().setChanged();
} else if (_entity instanceof LivingEntity _living) {
_living.setItemSlot(EquipmentSlot.HEAD, ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).HelmetSave)
);
}
}{
Entity _entity = entity;
if (_entity instanceof Player _player) {
_player.getInventory().armor.set(2, ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).ChestplateSave)
);
_player.getInventory().setChanged();
} else if (_entity instanceof LivingEntity _living) {
_living.setItemSlot(EquipmentSlot.CHEST, ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).ChestplateSave)
);
}
}{
Entity _entity = entity;
if (_entity instanceof Player _player) {
_player.getInventory().armor.set(1, ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).LeggingsSave)
);
_player.getInventory().setChanged();
} else if (_entity instanceof LivingEntity _living) {
_living.setItemSlot(EquipmentSlot.LEGS, ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).LeggingsSave)
);
}
}{
Entity _entity = entity;
if (_entity instanceof Player _player) {
_player.getInventory().armor.set(0, ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).BootsSave)
);
_player.getInventory().setChanged();
} else if (_entity instanceof LivingEntity _living) {
_living.setItemSlot(EquipmentSlot.FEET, ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).BootsSave)
);
}
}}}if (((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).CurrentMove).equals("Heal")) {if (!) {}else if () {}}if (((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).CurrentMove).equals("Haste")) {if (!) {}else if () {}}if (((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).CurrentMove).equals("Haste")) {if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200,(int)(2+/ 10), false, false));}if (((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).CurrentMove).equals("Strength")) {if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,200,(int)(0+/ 10), false, false));}{
String _setval = "";
entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.CurrentMove = _setval;
capability.syncPlayerVariables(entity);
});
}
}
}
}
