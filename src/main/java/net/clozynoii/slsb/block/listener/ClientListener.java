package net.clozynoii.slsb.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.clozynoii.slsb.init.SlsbModBlockEntities;
import net.clozynoii.slsb.block.renderer.RedGateSmallTileRenderer;
import net.clozynoii.slsb.block.renderer.BlueGateSmallTileRenderer;
import net.clozynoii.slsb.SlsbMod;

@Mod.EventBusSubscriber(modid = SlsbMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(SlsbModBlockEntities.BLUE_GATE_SMALL.get(), context -> new BlueGateSmallTileRenderer());
		event.registerBlockEntityRenderer(SlsbModBlockEntities.RED_GATE_SMALL.get(), context -> new RedGateSmallTileRenderer());
	}
}
