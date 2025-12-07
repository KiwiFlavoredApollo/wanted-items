package kiwiapollo.wanteditems.randomizer;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class RandomizerItem {
    private static final List<Item> all = new ArrayList<>();
    
    public static final Item EV_RANDOMIZER = register("ev_randomizer", new EVRandomizer());
    public static final Item IV_RANDOMIZER = register("iv_randomizer", new IVRandomizer());
    public static final Item LEVEL_RANDOMIZER = register("level_randomizer", new LevelRandomizer());

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
