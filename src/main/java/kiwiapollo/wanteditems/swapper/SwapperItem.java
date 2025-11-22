package kiwiapollo.wanteditems.swapper;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public enum SwapperItem {
    GENDER_SWAPPER("gender_swapper", new GenderSwapper()),
    SHINY_SWAPPER("shiny_swapper", new ShinySwapper()),
    CAUGHT_BALL_SWAPPER("caught_ball_swapper", new CaughtBallSwapper());

    private final Identifier identifier;
    private final Item item;

    SwapperItem(String path, Item item) {
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
