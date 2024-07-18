package com.sammy.le_fishe_au_chocolat;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
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

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        if (blockstate.is(Blocks.JUKEBOX) && !blockstate.getValue(JukeboxBlock.HAS_RECORD)) {
            ItemStack itemstack = pContext.getItemInHand();
            if (!level.isClientSide) {
                Player player = pContext.getPlayer();
                BlockEntity blockentity = level.getBlockEntity(blockpos);
                if (blockentity instanceof JukeboxBlockEntity) {
                    JukeboxBlockEntity jukeboxblockentity = (JukeboxBlockEntity)blockentity;
                    ItemStack usedStack = itemstack.copy();
                    usedStack.setCount(1);
                    jukeboxblockentity.setFirstItem(usedStack);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, blockstate));
                }

                itemstack.shrink(1);
                if (player != null) {
                    player.awardStat(Stats.PLAY_RECORD);
                }
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
}
