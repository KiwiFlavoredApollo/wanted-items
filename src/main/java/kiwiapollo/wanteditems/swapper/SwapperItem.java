package kiwiapollo.wanteditems.swapper;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class SwapperItem {
    private static final List<Item> all = new ArrayList<>();
    
    public static final Item GENDER_SWAPPER = register("gender_swapper", new GenderSwapper());
    public static final Item SHINY_SWAPPER = register("shiny_swapper", new ShinySwapper());
    public static final Item CAUGHT_BALL_SWAPPER = register("caught_ball_swapper", new CaughtBallSwapper());

    public static void initialize() {

    }

    private static Item register(String name, Item item) {
        Identifier identifier = Identifier.of(WantedItems.MOD_ID, name);
        Item i = Registry.register(Registries.ITEM, identifier, item);
        all.add(i);

        return i;
    }

    public static List<Item> getAll() {
        return new ArrayList<>(all);
    }
}
