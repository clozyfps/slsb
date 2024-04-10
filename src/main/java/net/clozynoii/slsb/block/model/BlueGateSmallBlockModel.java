package net.clozynoii.slsb.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.slsb.block.entity.BlueGateSmallTileEntity;

public class BlueGateSmallBlockModel extends GeoModel<BlueGateSmallTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BlueGateSmallTileEntity animatable) {
		return new ResourceLocation("slsb", "animations/bluegatesmall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlueGateSmallTileEntity animatable) {
		return new ResourceLocation("slsb", "geo/bluegatesmall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlueGateSmallTileEntity entity) {
		return new ResourceLocation("slsb", "textures/block/smallbluegatetexture.png");
	}
}
