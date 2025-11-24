package kiwiapollo.wanteditems.luckybox;

import kiwiapollo.wanteditems.common.ResourceReloadListenerStorage;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;

public class RedLuckyBox extends LuckyBox implements ResourceReloadListenerStorage {
    private static final LuckyBox.ItemFactory FACTORY = new LuckyBox.ItemFactory("red_lucky_box");

    public RedLuckyBox() {
        super(FACTORY);
    }

    @Override
    public IdentifiableResourceReloadListener get() {
        return FACTORY;
    }
}
