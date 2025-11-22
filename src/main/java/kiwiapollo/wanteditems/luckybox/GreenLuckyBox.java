package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.common.SimpleFactory;
import net.minecraft.item.Item;

public class GreenLuckyBox extends LuckyBox {
    public GreenLuckyBox() {
        super(new LuckyBarFactory());
    }

    private static class LuckyBarFactory implements SimpleFactory<Item> {
        @Override
        public Item create() {
            return null;
        }
    }
}
