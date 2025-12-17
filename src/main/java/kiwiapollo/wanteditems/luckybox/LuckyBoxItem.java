package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.WantedItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class LuckyBoxItem {
    private static final List<Item> all = new ArrayList<>();

    public static final Item COBBLEMON_LUCKY_BOX = register("cobblemon_lucky_box", new CobblemonLuckyBox());
    public static final Item POKE_BALL_LUCKY_BOX = register("poke_ball_lucky_box", new PokeBallLuckyBox());
    public static final Item BERRY_LUCKY_BOX = register("berry_lucky_box", new BerryLuckyBox());
    public static final Item EXP_CANDY_LUCKY_BOX = register("exp_candy_lucky_box", new ExpCandyLuckyBox());

    public static final Item RED_LUCKY_BOX = register("red_lucky_box", new RedLuckyBox());
    public static final Item GREEN_LUCKY_BOX = register("green_lucky_box", new GreenLuckyBox());
    public static final Item BLUE_LUCKY_BOX = register("blue_lucky_box", new BlueLuckyBox());

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
