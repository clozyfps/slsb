package net.clozynoii.slsb.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class CostOverlayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Cost\u00A7l" + " [" + new java.text.DecimalFormat("#").format((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SlsbModVariables.PlayerVariables())).Cost) + "]";
	}
}
