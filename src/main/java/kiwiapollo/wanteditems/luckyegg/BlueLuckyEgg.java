package kiwiapollo.wanteditems.luckyegg;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public class BlueLuckyEgg extends LuckyEgg {
    private static final DataPackPokemonPool POOL = new DataPackPokemonPool("blue_lucky_egg");

    public BlueLuckyEgg() {
        super(POOL);
    }

    static {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(POOL);
    }
}
