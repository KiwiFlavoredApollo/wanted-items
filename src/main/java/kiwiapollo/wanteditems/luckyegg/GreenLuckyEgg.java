package kiwiapollo.wanteditems.luckyegg;

import kiwiapollo.wanteditems.common.ResourceReloadListenerStorage;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;

public class GreenLuckyEgg extends LuckyEgg implements ResourceReloadListenerStorage {
    private static final LuckyEgg.PokemonFactory FACTORY = new LuckyEgg.PokemonFactory("green_lucky_egg");

    public GreenLuckyEgg() {
        super(FACTORY);
    }

    @Override
    public IdentifiableResourceReloadListener get() {
        return FACTORY;
    }
}
