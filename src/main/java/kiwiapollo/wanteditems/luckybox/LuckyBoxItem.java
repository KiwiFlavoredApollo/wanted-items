package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum LuckyBoxItem {
    LUCKY_ARTIFACT("lucky_artifact", new LuckyArtifact()),
    LUCKY_BALL("lucky_ball", new LuckyBall()),
    LUCKY_BAR("lucky_bar", new LuckyBar()),
    LUCKY_BERRY("lucky_berry", new LuckyBerry()),
    LUCKY_CANDY("lucky_candy", new LuckyCandy()),

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
