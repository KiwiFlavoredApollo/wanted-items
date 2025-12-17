package kiwiapollo.wanteditems.deprecated;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class DeprecatedItem {
    private static final List<Item> all = new ArrayList<>();
    
    public static final Item GOLD_CANDY_LUCKY_BOX = register("gold_candy_lucky_box", new GoldCandyLuckyBox());
    public static final Item SILVER_CANDY_LUCKY_BOX = register("silver_candy_lucky_box", new SilverCandyLuckyBox());
    public static final Item GOLD_POKE_BALL_LUCKY_BOX = register("gold_poke_ball_lucky_box", new GoldPokeBallLuckyBox());
    public static final Item SILVER_POKE_BALL_LUCKY_BOX = register("silver_poke_ball_lucky_box", new SilverPokeBallLuckyBox());
    public static final Item ANCIENT_POKE_BALL_LUCKY_BOX = register("ancient_poke_ball_lucky_box", new AncientPokeBallLuckyBox());

    public static final Item GOLD_LUCKY_EGG = register("gold_lucky_egg", new GoldLuckyEgg());
    public static final Item SHINY_GOLD_LUCKY_EGG = register("shiny_gold_lucky_egg", new ShinyGoldLuckyEgg());
    public static final Item SILVER_LUCKY_EGG = register("silver_lucky_egg", new SilverLuckyEgg());
    public static final Item SHINY_SILVER_LUCKY_EGG = register("shiny_silver_lucky_egg", new ShinySilverLuckyEgg());

    public static void initialize() {

    }

    private static Item register(String name, Item item) {
        Identifier identifier = Identifier.of(WantedItems.MOD_ID, name);
        Item registered = Registry.register(Registries.ITEM, identifier, item);
        all.add(registered);

        return registered;
    }

    public static List<Item> getAll() {
        return new ArrayList<>(all);
    }
}
