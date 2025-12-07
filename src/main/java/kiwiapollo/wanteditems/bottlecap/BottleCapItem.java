package kiwiapollo.wanteditems.bottlecap;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class BottleCapItem {
    private static final List<Item> all = new ArrayList<>();
    
    public static final Item BOTTLE_CAP = register("bottle_cap", new BottleCap());

    public static final Item BOTTLE_CAP_ATK = register("bottle_cap_atk", new BottleCap(Stats.ATTACK));
    public static final Item BOTTLE_CAP_DEF = register("bottle_cap_def", new BottleCap(Stats.DEFENCE));
    public static final Item BOTTLE_CAP_HP = register("bottle_cap_hp", new BottleCap(Stats.HP));
    public static final Item BOTTLE_CAP_SPA = register("bottle_cap_spa", new BottleCap(Stats.SPECIAL_ATTACK));
    public static final Item BOTTLE_CAP_SPD = register("bottle_cap_spd", new BottleCap(Stats.SPECIAL_DEFENCE));
    public static final Item BOTTLE_CAP_SPE = register("bottle_cap_spe", new BottleCap(Stats.SPEED));

    public static final Item GOLD_BOTTLE_CAP = register("gold_bottle_cap", new GoldBottleCap());
    public static final Item COPPER_BOTTLE_CAP = register("copper_bottle_cap", new CopperBottleCap());

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
