package net.clozynoii.slsb.block.model;

public class RedGateSmallBlockModel extends GeoModel<RedGateSmallTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(RedGateSmallTileEntity animatable) {
		return new ResourceLocation("slsb", "animations/redgatesmall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedGateSmallTileEntity animatable) {
		return new ResourceLocation("slsb", "geo/redgatesmall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedGateSmallTileEntity entity) {
		return new ResourceLocation("slsb", "textures/block/smallredgatetexture.png");
	}
}