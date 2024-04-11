package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.BlueGateSmallBlockModel;
import net.clozynoii.slsb.block.entity.BlueGateSmallTileEntity;

public class BlueGateSmallTileRenderer extends GeoBlockRenderer<BlueGateSmallTileEntity> {
	public BlueGateSmallTileRenderer() {
		super(new BlueGateSmallBlockModel());
	}

	@Override
	public RenderType getRenderType(BlueGateSmallTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
