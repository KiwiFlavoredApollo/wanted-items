package kiwiapollo.wanteditems.luckyegg;

import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.common.SimpleFactory;

public class GreenLuckyEgg extends LuckyEgg {
    public GreenLuckyEgg() {
        super(new Factory());
    }

    private static class Factory implements SimpleFactory<Pokemon> {
        @Override
        public Pokemon create() {
            return null;
        }
    }
}
