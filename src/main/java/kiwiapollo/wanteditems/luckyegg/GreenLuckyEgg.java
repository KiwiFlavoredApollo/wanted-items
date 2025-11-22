package kiwiapollo.wanteditems.luckyegg;

public class GreenLuckyEgg extends LuckyEgg {
    public static final PokemonFactory FACTORY = new PokemonFactory();

    public GreenLuckyEgg() {
        super(FACTORY);
    }

    public static class PokemonFactory extends LuckyEgg.PokemonFactory {
        public PokemonFactory() {
            super("green_lucky_egg");
        }
    }
}
