package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.common.ResourceReloadListenerStorage;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;

public class GreenLuckyBox extends LuckyBox implements ResourceReloadListenerStorage {
    private static final LuckyBox.ItemFactory FACTORY = new LuckyBox.ItemFactory("green_lucky_box");

    public GreenLuckyBox() {
        super(FACTORY);
    }

    @Override
    public IdentifiableResourceReloadListener get() {
        return FACTORY;
    }
}
