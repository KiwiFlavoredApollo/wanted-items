package kiwiapollo.wanteditems.effect;

import com.cobblemon.mod.common.api.moves.Move;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

import java.util.function.BiConsumer;

public class SunnyDayEffect implements BiConsumer<ServerPlayerEntity, Move> {
    @Override
    public void accept(ServerPlayerEntity player, Move move) {
        ServerWorld world = player.getServerWorld();
        world.setWeather(1200, 0, false, false);
        player.sendMessage(Text.translatable("commands.weather.set.clear"));
        move.setCurrentPp(move.getCurrentPp() - 1);
    }
}
