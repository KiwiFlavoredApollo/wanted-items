package kiwiapollo.wanteditems.luckyegg;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public class RedLuckyEgg extends LuckyEgg {
    private static final DataPackPokemonPool POOL = new DataPackPokemonPool("red_lucky_egg");

    public RedLuckyEgg() {
        super(POOL);
    }

    static {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(POOL);
    }
}
