package kiwiapollo.wanteditems.luckyegg;

import kiwiapollo.wanteditems.common.ResourceReloadListenerStorage;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;

public class RedLuckyEgg extends LuckyEgg implements ResourceReloadListenerStorage {
    private static final LuckyEgg.PokemonFactory FACTORY = new LuckyEgg.PokemonFactory("red_lucky_egg");

    public RedLuckyEgg() {
        super(FACTORY);
    }

    @Override
    public IdentifiableResourceReloadListener get() {
        return FACTORY;
    }
}
