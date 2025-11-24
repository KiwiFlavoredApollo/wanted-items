package kiwiapollo.wanteditems.luckyegg;

import kiwiapollo.wanteditems.common.ResourceReloadListenerStorage;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;

public class BlueLuckyEgg extends LuckyEgg implements ResourceReloadListenerStorage {
    private static final LuckyEgg.PokemonFactory FACTORY = new LuckyEgg.PokemonFactory("blue_lucky_egg");

    public BlueLuckyEgg() {
        super(FACTORY);
    }

    @Override
    public IdentifiableResourceReloadListener get() {
        return FACTORY;
    }
}
