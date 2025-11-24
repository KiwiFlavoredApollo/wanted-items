package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.common.ResourceReloadListenerStorage;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;

public class BlueLuckyBox extends LuckyBox implements ResourceReloadListenerStorage {
    private static final LuckyBox.ItemFactory FACTORY = new LuckyBox.ItemFactory("blue_lucky_box");

    public BlueLuckyBox() {
        super(FACTORY);
    }

    @Override
    public IdentifiableResourceReloadListener get() {
        return FACTORY;
    }
}
