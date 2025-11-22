package kiwiapollo.wanteditems.luckybox;

import com.cobblemon.mod.common.CobblemonItems;
import com.cobblemon.mod.common.item.PokeBallItem;
import kiwiapollo.wanteditems.common.SimpleFactory;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckyBall extends LuckyBox {
    public LuckyBall() {
        super(new LuckyBallFactory());
    }

    private static class LuckyBallFactory implements SimpleFactory<Item> {
        @Override
        public Item create() {
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
