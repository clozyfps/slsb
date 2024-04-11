package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.display.RedGateSmallDisplayItem;

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
