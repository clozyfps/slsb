package net.clozynoii.slsb.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;

import net.clozynoii.slsb.network.SlsbModVariables;
import net.clozynoii.slsb.SlsbMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WorldCreatedProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (SlsbModVariables.MapVariables.get(world).WorldCreated == false) {
			SlsbModVariables.MapVariables.get(world).WorldCreated = true;
			SlsbModVariables.MapVariables.get(world).syncData(world);
			SlsbModVariables.MapVariables.get(world).GateTimer = 72000;
			SlsbModVariables.MapVariables.get(world).syncData(world);
			SlsbMod.LOGGER.debug("World Created!");
		}
	}
}
