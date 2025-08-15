package kiwiapollo.wanteditems.effect;

import com.cobblemon.mod.common.api.moves.Move;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.BiConsumer;

public class NullEffect implements BiConsumer<ServerPlayerEntity, Move> {
    @Override
    public void accept(ServerPlayerEntity player, Move move) {
        player.sendMessage(Text.translatable("item.wanteditems.move_has_no_effect").formatted(Formatting.RED));
        throw new IllegalStateException();
    }
}
