package kiwiapollo.wanteditems;

import kiwiapollo.wanteditems.common.ModItemGroup;
import kiwiapollo.wanteditems.deprecated.DeprecatedItem;
import kiwiapollo.wanteditems.luckybox.LuckyBoxItem;
import kiwiapollo.wanteditems.luckyegg.*;
import kiwiapollo.wanteditems.misc.MiscItem;
import kiwiapollo.wanteditems.randomizer.RandomizerItem;
import kiwiapollo.wanteditems.bottlecap.BottleCapItem;
import kiwiapollo.wanteditems.swapper.SwapperItem;
import net.fabricmc.api.ModInitializer;

public class WantedItems implements ModInitializer {
	public static final String MOD_ID = "wanteditems";

	@Override
	public void onInitialize() {
		LuckyBoxItem.initialize();
		LuckyEggItem.initialize();
		BottleCapItem.initialize();
		SwapperItem.initialize();
		RandomizerItem.initialize();
		MiscItem.initialize();
		DeprecatedItem.initialize();

		ModItemGroup.initialize();
	}
}