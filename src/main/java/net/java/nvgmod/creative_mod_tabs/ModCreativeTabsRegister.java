package net.java.nvgmod.creative_mod_tabs;

import net.java.nvgmod.NVGMod;
import net.java.nvgmod.items.ModItemsRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabsRegister {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS
            = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NVGMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> NVGTab
            = CREATIVE_MODE_TABS.register("nvg_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("nvg_tab"))
                    .icon(() -> ModItemsRegister.NVG.get().getDefaultInstance())
                    .displayItems(((parameters, output) -> {
                        output.accept(ModItemsRegister.NVG.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}