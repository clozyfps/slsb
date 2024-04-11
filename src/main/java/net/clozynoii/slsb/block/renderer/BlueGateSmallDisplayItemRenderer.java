package net.clozynoii.slsb.block.renderer;

public class BlueGateSmallDisplayItemRenderer extends GeoItemRenderer<BlueGateSmallDisplayItem> {
	public BlueGateSmallDisplayItemRenderer() {
		super(new BlueGateSmallDisplayModel());
	}

	@Override
	public RenderType getRenderType(BlueGateSmallDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}