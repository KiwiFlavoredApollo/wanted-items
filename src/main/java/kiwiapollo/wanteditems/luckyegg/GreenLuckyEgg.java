package kiwiapollo.wanteditems.luckyegg;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public class GreenLuckyEgg extends LuckyEgg {
    private static final DataPackPokemonPool POOL = new DataPackPokemonPool("green_lucky_egg");

    public GreenLuckyEgg() {
        super(POOL);
    }

    static {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(POOL);
    }
}
