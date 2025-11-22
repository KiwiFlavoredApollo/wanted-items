package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.common.SimpleFactory;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class LuckyArtifact extends LuckyBox {
    public LuckyArtifact() {
        super(new LuckyArtifactFactory());
    }

    private static class LuckyArtifactFactory implements SimpleFactory<Item> {
        @Override
        public Item create() {
            return Items.AIR;
        }
    }
}
