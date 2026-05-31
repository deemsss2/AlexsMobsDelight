package io.github.rcneg.alexsmobsdelight.helper;

import io.github.rcneg.alexsmobsdelight.init.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;

public class ItemHelper {
    public static boolean itemHasSmeltResult(ItemStack itemStack, Level level){
        return level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(itemStack), level).isPresent();
    }

    public static ItemStack getItemSmeltResult(ItemStack itemStack, Level level){
        if (itemHasSmeltResult(itemStack, level)) {
            return level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(itemStack), level).map(recipe -> recipe.getResultItem(level.registryAccess()).copy()).orElse(ItemStack.EMPTY);
        }
        return ItemStack.EMPTY;
    }

    public static List<ItemStack> getBlockDrops(ServerLevel level, BlockPos pos, Player player, ItemStack tool) {
        BlockState state = level.getBlockState(pos);

        LootParams.Builder builder = new LootParams.Builder(level)
                .withParameter(LootContextParams.ORIGIN, pos.getCenter())
                .withParameter(LootContextParams.BLOCK_STATE, state)
                .withParameter(LootContextParams.TOOL, tool);

        if (player != null) {
            builder.withParameter(LootContextParams.THIS_ENTITY, player);
        }
        return state.getDrops(builder);
    }

    public static Component customColor(Component name, int r, int g, int b){
        String text = name.getString();
        int rgb = (r << 16) | (g << 8) | b;
        return Component.literal(text).withStyle(style -> style.withColor(rgb));
    }

    public static boolean hasFlyingFishCan(Player player){
        for(ItemStack s : player.getAllSlots()){
            if(s.is(ItemRegistry.OPENED_SURFLYGFISK.get())){
                return true;
            }
        }
        return false;
    }
}
