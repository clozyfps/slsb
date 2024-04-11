package net.clozynoii.slsb.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

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
