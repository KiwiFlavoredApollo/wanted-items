package kiwiapollo.wanteditems.luckybox;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import kiwiapollo.wanteditems.WantedItems;
import kiwiapollo.wanteditems.common.CustomTagFile;
import kiwiapollo.wanteditems.common.SimpleFactory;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class LuckyBox extends Item {
    private final SimpleFactory<Item> factory;

    public LuckyBox(SimpleFactory<Item> factory) {
        super(new Item.Settings());
        this.factory = factory;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        try {
            if (world.isClient()) {
                return TypedActionResult.pass(user.getStackInHand(hand));
            }

            ItemStack item = factory.create().getDefaultStack();

            if (!user.giveItemStack(item)) {
                user.dropItem(item, true);
            }

            if (!user.isCreative()) {
                user.getStackInHand(hand).decrement(1);
            }

            user.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1F, 1F);
            return TypedActionResult.success(user.getStackInHand(hand));

        } catch (IndexOutOfBoundsException e) {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
    }

    protected static class ItemFactory implements SimpleFactory<Item>, SimpleSynchronousResourceReloadListener {
        private static final Gson GSON = new Gson();

        private final List<Identifier> items;
        private final String path;

        protected ItemFactory(String path) {
            this.path = path;
            this.items = new ArrayList<>();
        }

        @Override
        public Item create() {
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
                CustomTagFile file = GSON.fromJson(reader, CustomTagFile.class);
                items.clear();
                items.addAll(toIdentifier(file));

            } catch (NoSuchElementException | IOException | JsonParseException ignored) {

            }
        }

        private List<Identifier> toIdentifier(CustomTagFile file) {
            return file.values.stream()
                    .map(v -> Identifier.tryParse(v))
                    .filter(Objects::nonNull).toList();
        }

        private Resource getResource(ResourceManager manager) {
            Identifier identifier = Identifier.of(WantedItems.MOD_ID, "lucky_box/" + path + ".json");
            return manager.getResource(identifier).orElseThrow();
        }
    }
}
