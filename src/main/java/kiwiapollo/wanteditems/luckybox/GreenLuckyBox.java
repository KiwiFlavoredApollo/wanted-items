package kiwiapollo.wanteditems.luckybox;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public class GreenLuckyBox extends LuckyBox {
    private static final DataPackItemPool POOL = new DataPackItemPool("green_lucky_box");

    public GreenLuckyBox() {
        super(POOL);
    }

    static {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(POOL);
    }
}
