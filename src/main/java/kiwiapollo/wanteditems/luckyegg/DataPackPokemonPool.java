package kiwiapollo.wanteditems.luckyegg;

import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import kiwiapollo.wanteditems.WantedItems;
import kiwiapollo.wanteditems.common.ModTagFile;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class DataPackPokemonPool implements PokemonPool, SimpleSynchronousResourceReloadListener {
    private static final Gson GSON = new Gson();

    private final List<Identifier> pokemon;
    private final String path;

    public DataPackPokemonPool(String path) {
        this.path = path;
        this.pokemon = new ArrayList<>();
    }

    @Override
    public Pokemon random() {
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
        return Identifier.of(WantedItems.MOD_ID, path);
    }

    @Override
    public void reload(ResourceManager manager) {
        try (BufferedReader reader = getResource(manager).getReader()) {
            ModTagFile file = GSON.fromJson(reader, ModTagFile.class);
            pokemon.clear();
            pokemon.addAll(toIdentifier(file));

        } catch (NoSuchElementException | IOException | JsonParseException ignored) {

        }
    }

    private List<Identifier> toIdentifier(ModTagFile file) {
        return file.values.stream()
                .map(v -> Identifier.tryParse(v))
                .filter(Objects::nonNull).toList();
    }

    private Resource getResource(ResourceManager manager) {
        Identifier identifier = Identifier.of(WantedItems.MOD_ID, "lucky_egg/" + path + ".json");
        return manager.getResource(identifier).orElseThrow();
    }
}