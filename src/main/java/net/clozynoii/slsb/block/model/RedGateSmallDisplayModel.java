package net.clozynoii.slsb.block.model;

public class RedGateSmallDisplayModel extends GeoModel<RedGateSmallDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(RedGateSmallDisplayItem animatable) {
		return new ResourceLocation("slsb", "animations/redgatesmall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedGateSmallDisplayItem animatable) {
		return new ResourceLocation("slsb", "geo/redgatesmall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedGateSmallDisplayItem entity) {
		return new ResourceLocation("slsb", "textures/block/smallredgatetexture.png");
	}
}