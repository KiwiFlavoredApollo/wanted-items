package kiwiapollo.wanteditems.effect;

import com.cobblemon.mod.common.api.moves.Move;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

import java.util.function.BiConsumer;

public class SmokeScreenEffect implements BiConsumer<ServerPlayerEntity, Move> {
    @Override
    public void accept(ServerPlayerEntity player, Move move) {
        try {
            ServerWorld world = player.getServerWorld();
            PlayerEntity target = world.getClosestPlayer(player.getX(), player.getY(), player.getZ(), 10.0, true);
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 220,1, false, true, true));
            target.sendMessage(Text.translatable("item.wanteditems.player_blinded_target", player.getGameProfile().getName(), target.getGameProfile().getName()));
            move.setCurrentPp(move.getCurrentPp() - 1);

        } catch (NullPointerException ignored) {

        }
    }
}
