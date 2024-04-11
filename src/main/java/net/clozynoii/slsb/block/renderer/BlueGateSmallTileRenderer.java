package net.clozynoii.slsb.block.renderer;

public class BlueGateSmallTileRenderer extends GeoBlockRenderer<BlueGateSmallTileEntity> {
	public BlueGateSmallTileRenderer() {
		super(new BlueGateSmallBlockModel());
	}

	@Override
	public RenderType getRenderType(BlueGateSmallTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}