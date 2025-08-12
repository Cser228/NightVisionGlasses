package net.java.nvgmod.items;

import net.java.nvgmod.NVGMod;
import net.java.nvgmod.armor_materials.NVGArmorMaterial;
import net.java.nvgmod.items.custom.NVGItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItemsRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(NVGMod.MOD_ID);

    public static final DeferredHolder<Item, NVGItem> NVG = ITEMS.register("nvg",
            () -> new NVGItem(NVGArmorMaterial.NVG_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .stacksTo(1)
                    .durability(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}