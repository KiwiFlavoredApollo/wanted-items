package kiwiapollo.wanteditems.luckybox;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import kiwiapollo.wanteditems.WantedItems;
import kiwiapollo.wanteditems.common.ModTagFile;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class DataPackItemPool implements ItemPool, SimpleSynchronousResourceReloadListener {
    private static final Gson GSON = new Gson();

    private final List<Identifier> items;
    private final String path;

    public DataPackItemPool(String path) {
        this.path = path;
        this.items = new ArrayList<>();
    }

    @Override
    public Item random() {
        List<Item> items = this.items.stream()
                .map(Registries.ITEM::get)
                .filter(i -> i != Items.AIR)
                .toList();

        List<Item> random = new ArrayList<>(items);
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
            items.clear();
            items.addAll(toIdentifier(file));

        } catch (NoSuchElementException | IOException | JsonParseException ignored) {

        }
    }

    private List<Identifier> toIdentifier(ModTagFile file) {
        return file.values.stream()
                .map(v -> Identifier.tryParse(v))
                .filter(Objects::nonNull).toList();
    }

    private Resource getResource(ResourceManager manager) {
        Identifier identifier = Identifier.of(WantedItems.MOD_ID, "lucky_box/" + path + ".json");
        return manager.getResource(identifier).orElseThrow();
    }
}
