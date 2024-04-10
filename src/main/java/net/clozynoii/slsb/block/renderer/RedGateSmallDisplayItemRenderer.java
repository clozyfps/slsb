package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.RedGateSmallDisplayModel;
import net.clozynoii.slsb.block.display.RedGateSmallDisplayItem;

public class RedGateSmallDisplayItemRenderer extends GeoItemRenderer<RedGateSmallDisplayItem> {
	public RedGateSmallDisplayItemRenderer() {
		super(new RedGateSmallDisplayModel());
	}

	@Override
	public RenderType getRenderType(RedGateSmallDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
