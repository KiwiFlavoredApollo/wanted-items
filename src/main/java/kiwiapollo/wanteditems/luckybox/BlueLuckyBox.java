package kiwiapollo.wanteditems.luckybox;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public class BlueLuckyBox extends LuckyBox {
    private static final DataPackItemPool POOL = new DataPackItemPool("blue_lucky_box");

    public BlueLuckyBox() {
        super(POOL);
    }

    static {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(POOL);
    }
}
