package kiwiapollo.wanteditems.luckybox;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.item.PokeBallItem;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokeBallLuckyBox extends LuckyBox {
    public PokeBallLuckyBox() {
        super(new PokeBallItemPool());
    }

    private static class PokeBallItemPool implements ItemPool {
        @Override
        public Item random() {
            List<Item> random = getPokeBallItems();
            random.removeAll(getForbiddenItems());
            Collections.shuffle(random);
            return random.get(0);
        }

        private List<Item> getPokeBallItems() {
            return new ArrayList<>(CobblemonItems.INSTANCE.all().stream().filter(item -> item instanceof PokeBallItem).toList());
        }

        private List<Item> getForbiddenItems() {
            return List.of(

            );
        }
    }
}
