package net.mcreator.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.slsb.network.SlsbModVariables;

public class TestRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 72000;
			entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerTimer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
