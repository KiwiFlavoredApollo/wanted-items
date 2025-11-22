package kiwiapollo.wanteditems.legacy;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum LegacyItem {
    COBBLEMON_LUCKY_BOX("cobblemon_lucky_box", new CobblemonLuckyBox()),
    GOLD_CANDY_LUCKY_BOX("gold_candy_lucky_box", new GoldCandyLuckyBox()),
    SILVER_CANDY_LUCKY_BOX("silver_candy_lucky_box", new SilverCandyLuckyBox()),
    GOLD_POKE_BALL_LUCKY_BOX("gold_poke_ball_lucky_box", new GoldPokeBallLuckyBox()),
    SILVER_POKE_BALL_LUCKY_BOX("silver_poke_ball_lucky_box", new SilverPokeBallLuckyBox()),
    ANCIENT_POKE_BALL_LUCKY_BOX("ancient_poke_ball_lucky_box", new AncientPokeBallLuckyBox()),

    GOLD_LUCKY_EGG("gold_lucky_egg", new GoldLuckyEgg()),
    SHINY_GOLD_LUCKY_EGG("shiny_gold_lucky_egg", new ShinyGoldLuckyEgg()),
    SILVER_LUCKY_EGG("silver_lucky_egg", new SilverLuckyEgg()),
    SHINY_SILVER_LUCKY_EGG("shiny_silver_lucky_egg", new ShinySilverLuckyEgg());

    private final Identifier identifier;
    private final Item item;

    LegacyItem(String path, Item item) {
        this.identifier = Identifier.of(WantedItems.MOD_ID, path);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public Identifier getIdentifier() {
        return identifier;
    }
}
