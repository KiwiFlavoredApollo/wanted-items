package kiwiapollo.wanteditems;

import kiwiapollo.wanteditems.common.ResourceReloadListenerStorage;
import kiwiapollo.wanteditems.deprecated.DeprecatedItem;
import kiwiapollo.wanteditems.luckybox.LuckyBoxItem;
import kiwiapollo.wanteditems.luckyegg.*;
import kiwiapollo.wanteditems.misc.MiscItem;
import kiwiapollo.wanteditems.randomizer.RandomizerItem;
import kiwiapollo.wanteditems.bottlecap.BottleCapItem;
import kiwiapollo.wanteditems.swapper.SwapperItem;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.resource.ResourceType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public class WantedItems implements ModInitializer {
	public static final String MOD_ID = "wanteditems";

	public static final Identifier ITEM_GROUP_ID = Identifier.of(WantedItems.MOD_ID, "item_group");
	public static final RegistryKey<ItemGroup> ITEM_GROUP_REGISTRY_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), ITEM_GROUP_ID);
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(SwapperItem.SHINY_SWAPPER.getItem()))
			.displayName(Text.translatable("item_group.wanteditems.title"))
			.build();

	@Override
	public void onInitialize() {
		addItemGroup();

		addLuckyBoxItems();
		addLuckyEggItems();
		addBottleCapItems();
		addSwapperItems();
		addRandomizerItems();
		addMiscItems();
		addDeprecatedItems();
	}

	private void addItemGroup() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_REGISTRY_KEY, ITEM_GROUP);
	}

	private void addLuckyBoxItems() {
        Arrays.stream(LuckyBoxItem.values()).forEach(item -> {
            Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
        });

        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
            Arrays.stream(LuckyBoxItem.values()).forEach(item -> {
                group.add(item.getItem());
            });
        });

        Arrays.stream(LuckyBoxItem.values()).forEach(item -> {
            if (item.getItem() instanceof ResourceReloadListenerStorage storage) {
                ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(storage.get());
            }
        });
	}

	private void addLuckyEggItems() {
		Arrays.stream(LuckyEggItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(LuckyEggItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});

        Arrays.stream(LuckyEggItem.values()).forEach(item -> {
            if (item.getItem() instanceof ResourceReloadListenerStorage storage) {
                ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(storage.get());
            }
        });
	}

	private void addBottleCapItems() {
		Arrays.stream(BottleCapItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(BottleCapItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addSwapperItems() {
		Arrays.stream(SwapperItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(SwapperItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addRandomizerItems() {
		Arrays.stream(RandomizerItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(RandomizerItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addMiscItems() {
		Arrays.stream(MiscItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});

		ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_REGISTRY_KEY).register(group -> {
			Arrays.stream(MiscItem.values()).forEach(item -> {
				group.add(item.getItem());
			});
		});
	}

	private void addDeprecatedItems() {
		Arrays.stream(DeprecatedItem.values()).forEach(item -> {
			Registry.register(Registries.ITEM, item.getIdentifier(), item.getItem());
		});
	}
}