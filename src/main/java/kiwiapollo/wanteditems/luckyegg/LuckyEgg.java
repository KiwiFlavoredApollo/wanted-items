package kiwiapollo.wanteditems.luckyegg;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import kiwiapollo.wanteditems.WantedItems;
import kiwiapollo.wanteditems.common.CustomTagFile;
import kiwiapollo.wanteditems.common.SimpleFactory;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class LuckyEgg extends Item {
    private final SimpleFactory<Pokemon> factory;

    public LuckyEgg(SimpleFactory<Pokemon> factory) {
        super(new Item.Settings());
        this.factory = factory;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        try {
            if (world.isClient()) {
                return TypedActionResult.pass(user.getStackInHand(hand));
            }

            ServerPlayerEntity player = world.getServer().getPlayerManager().getPlayer(user.getUuid());
            Pokemon pokemon = factory.create();
            Cobblemon.INSTANCE.getStorage().getParty(player).add(pokemon);

            if (!user.isCreative()) {
                user.getStackInHand(hand).decrement(1);
            }

            user.playSound(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1F, 1F);
            return TypedActionResult.success(user.getStackInHand(hand));

        } catch (IndexOutOfBoundsException e) {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
    }

    protected static class PokemonFactory implements SimpleFactory<Pokemon>, SimpleSynchronousResourceReloadListener {
        private static final Gson GSON = new Gson();

        private final List<Identifier> pokemon;
        private final String path;

        protected PokemonFactory(String path) {
            this.path = path;
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
            return Identifier.of(WantedItems.MOD_ID, path);
        }

        @Override
        public void reload(ResourceManager manager) {
            try (BufferedReader reader = getResource(manager).getReader()) {
                CustomTagFile file = GSON.fromJson(reader, CustomTagFile.class);
                pokemon.clear();
                pokemon.addAll(toIdentifier(file));

            } catch (NoSuchElementException | IOException | JsonParseException ignored) {

            }
        }

        private List<Identifier> toIdentifier(CustomTagFile file) {
            return file.values.stream()
                    .map(v -> Identifier.tryParse(v))
                    .filter(Objects::nonNull).toList();
        }

        private Resource getResource(ResourceManager manager) {
            Identifier identifier = Identifier.of(WantedItems.MOD_ID, "lucky_egg/" + path + ".json");
            return manager.getResource(identifier).orElseThrow();
        }
    }
}
