package kiwiapollo.wanteditems.luckyegg;

import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.common.ResourceReloadListenerStorage;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;

public class ShinyLuckyEgg extends LuckyEgg implements ResourceReloadListenerStorage {
    private static final LuckyEgg.PokemonFactory FACTORY = new ShinyPokemonFactory();

    public ShinyLuckyEgg() {
        super(FACTORY);
    }

    @Override
    public IdentifiableResourceReloadListener get() {
        return FACTORY;
    }

    private static class ShinyPokemonFactory extends PokemonFactory {
        protected ShinyPokemonFactory() {
            super("shiny_lucky_egg");
        }

        @Override
        public Pokemon create() {
            Pokemon pokemon = super.create();
            pokemon.setShiny(true);
            return pokemon;
        }
    }
}
