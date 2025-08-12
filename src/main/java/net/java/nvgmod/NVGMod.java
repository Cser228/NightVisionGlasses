package net.java.nvgmod;

import net.java.nvgmod.armor_materials.NVGArmorMaterial;
import net.java.nvgmod.creative_mod_tabs.ModCreativeTabsRegister;
import net.java.nvgmod.items.ModItemsRegister;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(NVGMod.MOD_ID)
public class NVGMod {
    public static final String MOD_ID = "nvgmod";

    public static final Logger LOGGER = LogUtils.getLogger();

    public NVGMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        NVGArmorMaterial.ARMOR_MATERIALS.register(modEventBus);
        ModItemsRegister.register(modEventBus);
        ModCreativeTabsRegister.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server start...");
    }
}
