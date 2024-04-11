package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.entity.RedGateSmallTileEntity;

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
