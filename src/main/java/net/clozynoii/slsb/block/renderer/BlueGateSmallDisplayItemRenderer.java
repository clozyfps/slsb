package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.BlueGateSmallDisplayModel;
import net.clozynoii.slsb.block.display.BlueGateSmallDisplayItem;

public class BlueGateSmallDisplayItemRenderer extends GeoItemRenderer<BlueGateSmallDisplayItem> {
	public BlueGateSmallDisplayItemRenderer() {
		super(new BlueGateSmallDisplayModel());
	}

	@Override
	public RenderType getRenderType(BlueGateSmallDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
