package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum LuckyBoxItem {
    COBBLEMON_LUCKY_BOX("cobblemon_lucky_box", new CobblemonLuckyBox()),
    POKE_BALL_LUCKY_BOX("poke_ball_lucky_box", new PokeBallLuckyBox()),
    BERRY_LUCKY_BOX("berry_lucky_box", new BerryLuckyBox()),
    EXP_CANDY_LUCKY_BOX("exp_candy_lucky_box", new ExpCandyLuckyBox()),

    RED_LUCKY_BOX("red_lucky_box", new RedLuckyBox()),
    GREEN_LUCKY_BOX("green_lucky_box", new GreenLuckyBox()),
    BLUE_LUCKY_BOX("blue_lucky_box", new BlueLuckyBox());

    private final Identifier identifier;
    private final Item item;

    LuckyBoxItem(String path, Item item) {
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
