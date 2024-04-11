package net.clozynoii.slsb.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.SlsbMod;

public class AfterImageOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		SlsbMod.queueServerWork(10, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
