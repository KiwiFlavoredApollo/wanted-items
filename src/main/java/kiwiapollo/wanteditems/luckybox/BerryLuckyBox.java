package kiwiapollo.wanteditems.luckybox;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.item.berry.BerryItem;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BerryLuckyBox extends LuckyBox {
    public BerryLuckyBox() {
        super(new BerryItemPool());
    }

    private static class BerryItemPool implements ItemPool {
        @Override
        public Item random() {
            List<Item> random = getCandyItems();
            random.removeAll(getForbiddenItems());
            Collections.shuffle(random);
            return random.get(0);
        }

        private List<Item> getCandyItems() {
            return new ArrayList<>(CobblemonItems.INSTANCE.all().stream().filter(item -> item instanceof BerryItem).toList());
        }

        private List<Item> getForbiddenItems() {
            return List.of(

            );
        }
    }
}
