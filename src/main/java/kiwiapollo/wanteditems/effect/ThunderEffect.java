package kiwiapollo.wanteditems.effect;

import com.cobblemon.mod.common.api.moves.Move;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

import java.util.function.BiConsumer;

public class ThunderEffect implements BiConsumer<ServerPlayerEntity, Move> {
    @Override
    public void accept(ServerPlayerEntity player, Move move) {
        ServerWorld world = player.getServerWorld();
        world.setWeather(0, 1200, true, true);
        PlayerEntity target = world.getClosestPlayer(player.getX(), player.getY(), player.getZ(), 10.0, true);
        EntityType.LIGHTNING_BOLT.spawn(world, target.getBlockPos(), SpawnReason.TRIGGERED);
        player.sendMessage(Text.translatable("commands.weather.set.thunder"));
        move.setCurrentPp(move.getCurrentPp() - 1);
    }
}
