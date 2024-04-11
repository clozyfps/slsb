package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.slsb.network.SlsbModVariables;

public class ManaOverlayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Mana \u00A7l" + "[\u00A79" + new java.text.DecimalFormat("#").format((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SlsbModVariables.PlayerVariables())).Mana) + "\u00A7r\u00A7l]";
	}
}
