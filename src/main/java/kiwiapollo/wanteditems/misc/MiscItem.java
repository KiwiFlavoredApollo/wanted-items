package kiwiapollo.wanteditems.misc;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class MiscItem {
    private static final List<Item> all = new ArrayList<>();

    public static final Item DITTO_RESIDUE = register("ditto_residue", new DittoResidue());
    public static final Item MOVE_ACTIVATOR = register("move_activator", new MoveActivator());

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
