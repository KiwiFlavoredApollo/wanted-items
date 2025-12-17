package kiwiapollo.wanteditems.luckyegg;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.pokemon.Pokemon;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LuckyEgg extends Item {
    private final PokemonPool pool;

    public LuckyEgg(PokemonPool pool) {
        super(new Item.Settings());
        this.pool = pool;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        try {
            if (world.isClient()) {
                return TypedActionResult.pass(user.getStackInHand(hand));
            }

            ServerPlayerEntity player = world.getServer().getPlayerManager().getPlayer(user.getUuid());
            Pokemon pokemon = pool.random();
            Cobblemon.INSTANCE.getStorage().getParty(player).add(pokemon);

            if (!user.isCreative()) {
                user.getStackInHand(hand).decrement(1);
            }

            user.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1F, 1F);
            return TypedActionResult.success(user.getStackInHand(hand));

        } catch (IndexOutOfBoundsException e) {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
    }
}
