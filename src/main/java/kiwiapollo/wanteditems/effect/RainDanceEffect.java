package kiwiapollo.wanteditems.effect;

import com.cobblemon.mod.common.api.moves.Move;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

import java.util.function.BiConsumer;

public class RainDanceEffect implements BiConsumer<ServerPlayerEntity, Move> {
    @Override
    public void accept(ServerPlayerEntity player, Move move) {
        ServerWorld world = player.getServerWorld();
        world.setWeather(0, 1200, true, false);
        player.sendMessage(Text.translatable("commands.weather.set.rain"));
        move.setCurrentPp(move.getCurrentPp() - 1);
    }
}
