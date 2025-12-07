package kiwiapollo.wanteditems.common;

import kiwiapollo.wanteditems.WantedItems;
import kiwiapollo.wanteditems.bottlecap.BottleCapItem;
import kiwiapollo.wanteditems.deprecated.DeprecatedItem;
import kiwiapollo.wanteditems.luckybox.LuckyBoxItem;
import kiwiapollo.wanteditems.luckyegg.LuckyEggItem;
import kiwiapollo.wanteditems.misc.MiscItem;
import kiwiapollo.wanteditems.randomizer.RandomizerItem;
import kiwiapollo.wanteditems.swapper.SwapperItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final Identifier ITEM_GROUP_ID = Identifier.of(WantedItems.MOD_ID, "item_group");
    public static final RegistryKey<ItemGroup> ITEM_GROUP_REGISTRY_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), ITEM_GROUP_ID);
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SwapperItem.SHINY_SWAPPER))
            .displayName(Text.translatable("item_group.wanteditems.title"))
            .build();

    public static void initialize() {
        register();
    }

    private static void register() {
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_REGISTRY_KEY, ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
            LuckyBoxItem.getAll().forEach(group::add);
            LuckyEggItem.getAll().forEach(group::add);
            BottleCapItem.getAll().forEach(group::add);
            SwapperItem.getAll().forEach(group::add);
            RandomizerItem.getAll().forEach(group::add);
            MiscItem.getAll().forEach(group::add);
        });
    }
}
