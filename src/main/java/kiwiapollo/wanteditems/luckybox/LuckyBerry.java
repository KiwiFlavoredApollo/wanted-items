package kiwiapollo.wanteditems.luckybox;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.item.BerryItem;
import kiwiapollo.wanteditems.common.SimpleFactory;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckyBerry extends LuckyBox {
    public LuckyBerry() {
        super(new LuckyBerryFactory());
    }

    private static class LuckyBerryFactory implements SimpleFactory<Item> {
        @Override
        public Item create() {
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
