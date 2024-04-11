
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.clozynoii.slsb.item.TestItem;
import net.clozynoii.slsb.item.KasakasVenomFangItem;
import net.clozynoii.slsb.block.display.RedGateSmallDisplayItem;
import net.clozynoii.slsb.block.display.BlueGateSmallDisplayItem;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SlsbMod.MODID);
	public static final RegistryObject<Item> KASAKAS_VENOM_FANG = REGISTRY.register("kasakas_venom_fang", () -> new KasakasVenomFangItem());
	public static final RegistryObject<Item> BLUE_GATE_SMALL = REGISTRY.register(SlsbModBlocks.BLUE_GATE_SMALL.getId().getPath(), () -> new BlueGateSmallDisplayItem(SlsbModBlocks.BLUE_GATE_SMALL.get(), new Item.Properties()));
	public static final RegistryObject<Item> RED_GATE_SMALL = REGISTRY.register(SlsbModBlocks.RED_GATE_SMALL.getId().getPath(), () -> new RedGateSmallDisplayItem(SlsbModBlocks.RED_GATE_SMALL.get(), new Item.Properties()));
	public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
}
