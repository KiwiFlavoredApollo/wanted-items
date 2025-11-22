package kiwiapollo.wanteditems.luckyegg;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum LuckyEggItem {
    RED_LUCKY_EGG("red_lucky_egg", new RedLuckyEgg()),
    GREEN_LUCKY_EGG("green_lucky_egg", new GreenLuckyEgg()),
    BLUE_LUCKY_EGG("blue_lucky_egg", new BlueLuckyEgg());

    private final Identifier identifier;
    private final Item item;

    LuckyEggItem(String path, Item item) {
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
