package kiwiapollo.wanteditems.misc;

import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;
import com.cobblemon.mod.common.api.item.PokemonAndMoveSelectingItem;
import com.cobblemon.mod.common.api.moves.Move;
import com.cobblemon.mod.common.battles.pokemon.BattlePokemon;
import com.cobblemon.mod.common.item.battle.BagItem;
import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.effect.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.BiConsumer;

public class MoveActivator extends Item implements PokemonAndMoveSelectingItem {
    private static final Map<String, BiConsumer<ServerPlayerEntity, Move>> EFFECTS = Map.ofEntries(
            Map.entry("raindance", new RainDanceEffect()),
            Map.entry("sunnyday", new SunnyDayEffect()),
            Map.entry("thunder", new ThunderEffect()),
            Map.entry("toxic", new ToxicEffect()),
            Map.entry("smokescreen", new SmokeScreenEffect())
    );

    public MoveActivator() {
        super(new Item.Settings());
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (world.isClient()) {
            return TypedActionResult.pass(itemStack);
        }

        return use((ServerPlayerEntity) player, itemStack);
    }

    @Override
    public @Nullable BagItem getBagItem() {
        return null;
    }

    @Override
    public @Nullable TypedActionResult<ItemStack> use(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack) {
        return PokemonAndMoveSelectingItem.DefaultImpls.use(this, player, itemStack);
    }

    @Override
    public void applyToPokemon(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon, @NotNull Move move) {
        try {
            if (move.getCurrentPp() == 0) {
                player.sendMessage(Text.translatable("item.wanteditems.not_enough_pp").formatted(Formatting.RED));
                return;
            }

            BiConsumer<ServerPlayerEntity, Move> effect = EFFECTS.getOrDefault(move.getName(), new NullEffect());
            effect.accept(player, move);

            if (!player.isCreative()) {
                itemStack.decrement(1);
            }

        } catch (IllegalStateException ignored) {

        }
    }

    @Override
    public void applyToBattlePokemon(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull BattlePokemon battlePokemon, @NotNull Move move) {

    }

    @Override
    public boolean canUseOnPokemon(@NotNull Pokemon pokemon) {
        return true;
    }

    @Override
    public boolean canUseOnBattlePokemon(@NotNull BattlePokemon pokemon) {
        return false;
    }

    @Override
    public boolean canUseOnMove(@NotNull Pokemon pokemon, @NotNull Move move) {
        return true;
    }

    @Override
    public boolean canUseOnMove(@NotNull Move move) {
        return true;
    }

    @Override
    public @Nullable TypedActionResult<ItemStack> interactWithSpecific(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull Pokemon pokemon) {
        return PokemonAndMoveSelectingItem.DefaultImpls.interactWithSpecific(this, player, itemStack, pokemon);
    }

    @Override
    public @Nullable TypedActionResult<ItemStack> interactWithSpecificBattle(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull BattlePokemon pokemon) {
        return PokemonAndMoveSelectingItem.DefaultImpls.interactWithSpecificBattle(this, player, itemStack, pokemon);
    }

    @Override
    public @Nullable TypedActionResult<ItemStack> interactGeneral(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack) {
        return PokemonAndMoveSelectingItem.DefaultImpls.interactGeneral(this, player, itemStack);

    }

    @Override
    public @Nullable TypedActionResult<ItemStack> interactGeneralBattle(@NotNull ServerPlayerEntity player, @NotNull ItemStack itemStack, @NotNull BattleActor battleActor) {
        return PokemonAndMoveSelectingItem.DefaultImpls.interactGeneralBattle(this, player, itemStack, battleActor);

    }
}
