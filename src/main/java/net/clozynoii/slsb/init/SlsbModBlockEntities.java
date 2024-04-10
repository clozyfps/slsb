
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.clozynoii.slsb.block.entity.RedGateSmallTileEntity;
import net.clozynoii.slsb.block.entity.BlueGateSmallTileEntity;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SlsbMod.MODID);
	public static final RegistryObject<BlockEntityType<BlueGateSmallTileEntity>> BLUE_GATE_SMALL = REGISTRY.register("blue_gate_small", () -> BlockEntityType.Builder.of(BlueGateSmallTileEntity::new, SlsbModBlocks.BLUE_GATE_SMALL.get()).build(null));
	public static final RegistryObject<BlockEntityType<RedGateSmallTileEntity>> RED_GATE_SMALL = REGISTRY.register("red_gate_small", () -> BlockEntityType.Builder.of(RedGateSmallTileEntity::new, SlsbModBlocks.RED_GATE_SMALL.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
