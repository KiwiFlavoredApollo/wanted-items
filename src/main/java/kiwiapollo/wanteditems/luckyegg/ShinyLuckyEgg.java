package kiwiapollo.wanteditems.luckyegg;

import com.cobblemon.mod.common.pokemon.Pokemon;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public class ShinyLuckyEgg extends LuckyEgg {
    private static final DataPackPokemonPool POOL = new ShinyPokemonPool();

    public ShinyLuckyEgg() {
        super(POOL);
    }

    private static class ShinyPokemonPool extends DataPackPokemonPool {
        protected ShinyPokemonPool() {
            super("shiny_lucky_egg");
        }

        @Override
        public Pokemon random() {
            Pokemon pokemon = super.random();
            pokemon.setShiny(true);
            return pokemon;
        }
    }

    static {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(POOL);
    }
}
