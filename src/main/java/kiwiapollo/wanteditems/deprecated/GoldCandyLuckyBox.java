package kiwiapollo.wanteditems.deprecated;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.item.interactive.CandyItem;
import kiwiapollo.wanteditems.luckybox.ItemPool;
import kiwiapollo.wanteditems.luckybox.LuckyBox;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoldCandyLuckyBox extends LuckyBox {
    public GoldCandyLuckyBox() {
        super(new ExpCandyItemPool());
    }

    private static class ExpCandyItemPool implements ItemPool {
        @Override
        public Item random() {
            List<Item> random = getCandyItems();
            random.removeAll(getForbiddenItems());
            Collections.shuffle(random);
            return random.get(0);
        }

        private List<Item> getCandyItems() {
            return new ArrayList<>(CobblemonItems.INSTANCE.all().stream().filter(item -> item instanceof CandyItem).toList());
        }

        private List<Item> getForbiddenItems() {
            return List.of(
                    CobblemonItems.EXPERIENCE_CANDY_XS,
                    CobblemonItems.EXPERIENCE_CANDY_S,
                    CobblemonItems.EXPERIENCE_CANDY_M
            );
        }
    }
}
