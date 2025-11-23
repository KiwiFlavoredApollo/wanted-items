package kiwiapollo.wanteditems.luckybox;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LuckyBox extends Item {
    private final ItemPool pool;

    public LuckyBox(ItemPool pool) {
        super(new Item.Settings());
        this.pool = pool;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        try {
            if (world.isClient()) {
                return TypedActionResult.pass(user.getStackInHand(hand));
            }

            ItemStack item = pool.random().getDefaultStack();

            if (!user.giveItemStack(item)) {
                user.dropItem(item, true);
            }

            if (!user.isCreative()) {
                user.getStackInHand(hand).decrement(1);
            }

            user.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP);
            return TypedActionResult.success(user.getStackInHand(hand));

        } catch (IndexOutOfBoundsException e) {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
    }
}
