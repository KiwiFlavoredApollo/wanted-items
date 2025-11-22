package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.common.SimpleFactory;
import net.minecraft.item.Item;

public class BlueLuckyBox extends LuckyBox {
    public BlueLuckyBox() {
        super(new LuckyBarFactory());
    }

    private static class LuckyBarFactory implements SimpleFactory<Item> {
        @Override
        public Item create() {
            return null;
        }
    }
}
