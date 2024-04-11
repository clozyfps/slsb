package net.clozynoii.slsb.block.renderer;

public class RedGateSmallDisplayItemRenderer extends GeoItemRenderer<RedGateSmallDisplayItem> {
	public RedGateSmallDisplayItemRenderer() {
		super(new RedGateSmallDisplayModel());
	}

	@Override
	public RenderType getRenderType(RedGateSmallDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}