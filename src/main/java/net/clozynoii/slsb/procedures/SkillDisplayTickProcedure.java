package net.clozynoii.slsb.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SkillDisplayTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

private static void execute(
@Nullable Event event
) {
if (==1) {if (!().isEmpty()) {}}else if (==2) {if (!().isEmpty()) {}}else if (==3) {if (!().isEmpty()) {}}else if (==4) {if (!().isEmpty()) {}}
}
}
