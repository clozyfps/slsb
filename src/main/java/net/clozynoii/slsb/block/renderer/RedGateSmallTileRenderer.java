package net.clozynoii.slsb.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.slsb.block.model.RedGateSmallBlockModel;
import net.clozynoii.slsb.block.entity.RedGateSmallTileEntity;

public class RedGateSmallTileRenderer extends GeoBlockRenderer<RedGateSmallTileEntity> {
	public RedGateSmallTileRenderer() {
		super(new RedGateSmallBlockModel());
	}

	@Override
	public RenderType getRenderType(RedGateSmallTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
