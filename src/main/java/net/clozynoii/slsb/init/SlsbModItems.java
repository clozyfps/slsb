
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.slsb.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.clozynoii.slsb.item.KasakasVenomFangItem;
import net.clozynoii.slsb.SlsbMod;

public class SlsbModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SlsbMod.MODID);
	public static final RegistryObject<Item> KASAKAS_VENOM_FANG = REGISTRY.register("kasakas_venom_fang", () -> new KasakasVenomFangItem());
}
