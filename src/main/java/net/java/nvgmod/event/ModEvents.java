package net.java.nvgmod.event;

import net.java.nvgmod.NVGMod;
import net.java.nvgmod.items.ModItemsRegister;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = NVGMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void tick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        ItemStack helmetStack = player.getInventory().getArmor(3);

        if (helmetStack.is(ModItemsRegister.NVG.get())) {
            player.addEffect(new MobEffectInstance(
                    MobEffects.NIGHT_VISION,
                    999999,
                    100,
                    false,
                    false
            ));
        }
        else {
            player.removeEffect(MobEffects.NIGHT_VISION);
        }
    }
}