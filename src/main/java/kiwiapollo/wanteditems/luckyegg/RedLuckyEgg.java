package kiwiapollo.wanteditems.luckyegg;

import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import kiwiapollo.wanteditems.WantedItems;
import kiwiapollo.wanteditems.common.SimpleFactory;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RedLuckyEgg extends LuckyEgg {
    public RedLuckyEgg() {
        super(new Factory());
    }

    private static class Factory implements SimpleFactory<Pokemon>, SimpleSynchronousResourceReloadListener {
        private static final Gson GSON = new Gson();
        private static final Identifier RESOURCE = Identifier.of(WantedItems.MOD_ID, "tags/pokemon/red_random_egg.json");

        private final List<Identifier> pokemon;

        private Factory() {
            this.pokemon = new ArrayList<>();
        }


        @Override
        public Pokemon create() {
            List<Pokemon> pokemon = this.pokemon.stream()
                    .map(PokemonSpecies.INSTANCE::getByIdentifier)
                    .filter(Objects::nonNull)
                    .map(species -> species.create(10))
                    .toList();

            List<Pokemon> random = new ArrayList<>(pokemon);
            Collections.shuffle(random);

            return random.get(0);
        }

        @Override
        public Identifier getFabricId() {
            return Identifier.of(WantedItems.MOD_ID, "red_random_egg");
        }

        @Override
        public void reload(ResourceManager manager) {
            manager.getResource(RESOURCE)
                    .ifPresent(resource -> {
                        try (BufferedReader reader = resource.getReader()) {
                            PokemonTagFile file = GSON.fromJson(reader, PokemonTagFile.class);
                            pokemon.clear();
                            pokemon.addAll(file.values);

                        } catch (IOException | JsonParseException e) {

                        }
                    });
        }
    }
}
