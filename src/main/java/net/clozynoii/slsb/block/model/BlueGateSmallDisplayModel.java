package net.clozynoii.slsb.block.model;

public class BlueGateSmallDisplayModel extends GeoModel<BlueGateSmallDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BlueGateSmallDisplayItem animatable) {
		return new ResourceLocation("slsb", "animations/bluegatesmall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlueGateSmallDisplayItem animatable) {
		return new ResourceLocation("slsb", "geo/bluegatesmall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlueGateSmallDisplayItem entity) {
		return new ResourceLocation("slsb", "textures/block/smallbluegatetexture.png");
	}
}