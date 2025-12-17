package kiwiapollo.wanteditems.luckyegg;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class LuckyEggItem {
    private static final List<Item> all = new ArrayList<>();

    public static final Item RED_LUCKY_EGG = register("red_lucky_egg", new RedLuckyEgg());
    public static final Item GREEN_LUCKY_EGG = register("green_lucky_egg", new GreenLuckyEgg());
    public static final Item BLUE_LUCKY_EGG = register("blue_lucky_egg", new BlueLuckyEgg());
    public static final Item SHINY_LUCKY_EGG = register("shiny_lucky_egg", new ShinyLuckyEgg());

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
