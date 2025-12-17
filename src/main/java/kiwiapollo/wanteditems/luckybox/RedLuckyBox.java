package kiwiapollo.wanteditems.luckybox;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public class RedLuckyBox extends LuckyBox {
    private static final DataPackItemPool POOL = new DataPackItemPool("red_lucky_box");

    public RedLuckyBox() {
        super(POOL);
    }

    static {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(POOL);
    }
}
