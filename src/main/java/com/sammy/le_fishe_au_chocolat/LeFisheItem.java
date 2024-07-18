package com.sammy.le_fishe_au_chocolat;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class LeFisheItem extends RecordItem {
    public LeFisheItem(Properties builder) {
        super(7, LeFisheAuChocolat.CHOIR_OF_LE_FISHE, builder, 620);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {

    }

    @Override
    public MutableComponent getDisplayName() {
        return Component.translatable("le_fishe_au_chocolat.subtitle.coeur_du_fishe");
    }
}
