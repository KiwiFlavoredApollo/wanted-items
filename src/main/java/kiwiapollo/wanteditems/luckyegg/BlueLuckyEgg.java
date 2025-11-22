package kiwiapollo.wanteditems.luckyegg;

import com.cobblemon.mod.common.pokemon.Pokemon;
import kiwiapollo.wanteditems.common.SimpleFactory;

public class BlueLuckyEgg extends LuckyEgg {
    public BlueLuckyEgg() {
        super(new Factory());
    }

    private static class Factory implements SimpleFactory<Pokemon> {
        @Override
        public Pokemon create() {
            return null;
        }
    }
}
