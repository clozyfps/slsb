package net.clozynoii.slsb.block.renderer;

public class RedGateSmallTileRenderer extends GeoBlockRenderer<RedGateSmallTileEntity> {
	public RedGateSmallTileRenderer() {
		super(new RedGateSmallBlockModel());
	}

	@Override
	public RenderType getRenderType(RedGateSmallTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}