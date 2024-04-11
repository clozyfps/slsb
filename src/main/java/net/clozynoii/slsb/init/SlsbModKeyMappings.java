
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.clozynoii.slsb.network.UseSkillMessage;
import net.clozynoii.slsb.network.SwitchSkillMessage;
import net.clozynoii.slsb.SlsbMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SlsbModKeyMappings {
	public static final KeyMapping SWITCH_SKILL = new KeyMapping("key.slsb.switch_skill", GLFW.GLFW_KEY_R, "key.categories.slsb") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SlsbMod.PACKET_HANDLER.sendToServer(new SwitchSkillMessage(0, 0));
				SwitchSkillMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_SKILL = new KeyMapping("key.slsb.use_skill", GLFW.GLFW_KEY_Z, "key.categories.slsb") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SlsbMod.PACKET_HANDLER.sendToServer(new UseSkillMessage(0, 0));
				UseSkillMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SWITCH_SKILL);
		event.register(USE_SKILL);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SWITCH_SKILL.consumeClick();
				USE_SKILL.consumeClick();
			}
		}
	}
}
