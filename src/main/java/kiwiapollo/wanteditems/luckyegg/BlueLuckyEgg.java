package kiwiapollo.wanteditems.luckyegg;

public class BlueLuckyEgg extends LuckyEgg {
    public static final PokemonFactory FACTORY = new PokemonFactory();

    public BlueLuckyEgg() {
        super(FACTORY);
    }

    public static class PokemonFactory extends LuckyEgg.PokemonFactory {
        public PokemonFactory() {
            super("blue_lucky_egg");
        }
    }
}
