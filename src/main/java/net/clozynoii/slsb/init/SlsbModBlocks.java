
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.clozynoii.slsb.block.RedGateSmallBlock;
import net.clozynoii.slsb.block.BlueGateSmallBlock;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SlsbMod.MODID);
	public static final RegistryObject<Block> BLUE_GATE_SMALL = REGISTRY.register("blue_gate_small", () -> new BlueGateSmallBlock());
	public static final RegistryObject<Block> RED_GATE_SMALL = REGISTRY.register("red_gate_small", () -> new RedGateSmallBlock());
}
