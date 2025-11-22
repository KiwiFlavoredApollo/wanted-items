package kiwiapollo.wanteditems.luckyegg;

public class RedLuckyEgg extends LuckyEgg {
    public static final PokemonFactory FACTORY = new PokemonFactory();

    public RedLuckyEgg() {
        super(FACTORY);
    }

    public static class PokemonFactory extends LuckyEgg.PokemonFactory {
        public PokemonFactory() {
            super("red_lucky_egg");
        }
    }
}
