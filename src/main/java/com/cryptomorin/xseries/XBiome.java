/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2020 Crypto Morin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.cryptomorin.xseries;

import com.google.common.base.Enums;
import org.apache.commons.lang.Validate;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * <b>XBiome</b> - Cross-version support for biome names.<br>
 * Biomes: https://minecraft.gamepedia.com/Biome
 * Biome: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/block/Biome.html
 *
 * @author Crypto Morin
 * @version 3.0.1
 * @see Biome
 */
public enum XBiome {
    BADLANDS(BiomeType.OVERWORLD, "MESA"),
    BADLANDS_PLATEAU(BiomeType.OVERWORLD, "MESA_CLEAR_ROCK", "MESA_PLATEAU"),
    BEACH(BiomeType.OVERWORLD, "BEACHES"),
    BIRCH_FOREST(BiomeType.OVERWORLD, "BIRCH_FOREST"),
    BIRCH_FOREST_HILLS(BiomeType.OVERWORLD, "BIRCH_FOREST_HILLS"),
    COLD_OCEAN(BiomeType.OVERWORLD, "COLD_OCEAN"),
    DARK_FOREST(BiomeType.OVERWORLD, "ROOFED_FOREST"),
    DARK_FOREST_HILLS(BiomeType.OVERWORLD, "MUTATED_ROOFED_FOREST", "ROOFED_FOREST_MOUNTAINS"),
    DEEP_COLD_OCEAN(BiomeType.OVERWORLD, "COLD_DEEP_OCEAN"),
    DEEP_FROZEN_OCEAN(BiomeType.OVERWORLD, "FROZEN_DEEP_OCEAN"),
    DEEP_LUKEWARM_OCEAN(BiomeType.OVERWORLD, "LUKEWARM_DEEP_OCEAN"),
    DEEP_OCEAN(BiomeType.OVERWORLD, "DEEP_OCEAN"),
    DEEP_WARM_OCEAN(BiomeType.OVERWORLD, "WARM_DEEP_OCEAN"),
    DESERT(BiomeType.OVERWORLD, "DESERT"),
    DESERT_HILLS(BiomeType.OVERWORLD, "DESERT_HILLS"),
    DESERT_LAKES(BiomeType.OVERWORLD, "MUTATED_DESERT", "DESERT_MOUNTAINS"),
    END_BARRENS(BiomeType.END, "SKY_ISLAND_BARREN"),
    END_HIGHLANDS(BiomeType.END, "SKY_ISLAND_HIGH"),
    END_MIDLANDS(BiomeType.END, "SKY_ISLAND_MEDIUM"),
    ERODED_BADLANDS(BiomeType.OVERWORLD, "MUTATED_MESA", "MESA_BRYCE"),
    FLOWER_FOREST(BiomeType.OVERWORLD, "MUTATED_FOREST"),
    FOREST(BiomeType.OVERWORLD, "FOREST"),
    FROZEN_OCEAN(BiomeType.OVERWORLD, "FROZEN_OCEAN"),
    FROZEN_RIVER(BiomeType.OVERWORLD, "FROZEN_RIVER"),
    GIANT_SPRUCE_TAIGA(BiomeType.OVERWORLD, "MUTATED_REDWOOD_TAIGA", "MEGA_SPRUCE_TAIGA"),
    GIANT_SPRUCE_TAIGA_HILLS(BiomeType.OVERWORLD, "MUTATED_REDWOOD_TAIGA_HILLS", "MEGA_SPRUCE_TAIGA_HILLS"),
    GIANT_TREE_TAIGA(BiomeType.OVERWORLD, "REDWOOD_TAIGA", "MEGA_TAIGA"),
    GIANT_TREE_TAIGA_HILLS(BiomeType.OVERWORLD, "REDWOOD_TAIGA_HILLS", "MEGA_TAIGA_HILLS"),
    GRAVELLY_MOUNTAINS(BiomeType.OVERWORLD, "MUTATED_EXTREME_HILLS", "EXTREME_HILLS_MOUNTAINS"),
    ICE_SPIKES(BiomeType.OVERWORLD, "MUTATED_ICE_FLATS", "ICE_PLAINS_SPIKES"),
    JUNGLE(BiomeType.OVERWORLD, "JUNGLE"),
    JUNGLE_EDGE(BiomeType.OVERWORLD, "JUNGLE_EDGE"),
    JUNGLE_HILLS(BiomeType.OVERWORLD, "JUNGLE_HILLS"),
    LUKEWARM_OCEAN(BiomeType.OVERWORLD, "LUKEWARM_OCEAN"),
    MODIFIED_BADLANDS_PLATEAU(BiomeType.OVERWORLD, "MUTATED_MESA_CLEAR_ROCK", "MESA_PLATEAU"),
    MODIFIED_GRAVELLY_MOUNTAINS(BiomeType.OVERWORLD, "MUTATED_EXTREME_HILLS_WITH_TREES", "EXTREME_HILLS_MOUNTAINS"),
    MODIFIED_JUNGLE(BiomeType.OVERWORLD, "MUTATED_JUNGLE", "JUNGLE_MOUNTAINS"),
    MODIFIED_JUNGLE_EDGE(BiomeType.OVERWORLD, "MUTATED_JUNGLE_EDGE", "JUNGLE_EDGE_MOUNTAINS"),
    MODIFIED_WOODED_BADLANDS_PLATEAU(BiomeType.OVERWORLD, "MUTATED_MESA_ROCK", "MESA_PLATEAU_FOREST_MOUNTAINS"),
    MOUNTAINS(BiomeType.OVERWORLD, "EXTREME_HILLS"),
    MOUNTAIN_EDGE(BiomeType.OVERWORLD, "SMALLER_EXTREME_HILLS"),
    MUSHROOM_FIELDS(BiomeType.OVERWORLD, "MUSHROOM_ISLAND"),
    MUSHROOM_FIELD_SHORE(BiomeType.OVERWORLD, "MUSHROOM_ISLAND_SHORE", "MUSHROOM_SHORE"),
    SOUL_SAND_VALLEY(BiomeType.NETHER),
    CRIMSON_FOREST(BiomeType.NETHER),
    WARPED_FOREST(BiomeType.NETHER),
    BASALT_DELTAS(BiomeType.NETHER),
    NETHER_WASTES(BiomeType.NETHER, "NETHER", "HELL"),
    OCEAN(BiomeType.OVERWORLD, "OCEAN"),
    PLAINS(BiomeType.OVERWORLD, "PLAINS"),
    RIVER(BiomeType.OVERWORLD, "RIVER"),
    SAVANNA(BiomeType.OVERWORLD, "SAVANNA"),
    SAVANNA_PLATEAU(BiomeType.OVERWORLD, "SAVANNA_ROCK", "SAVANNA_PLATEAU"),
    SHATTERED_SAVANNA(BiomeType.OVERWORLD, "MUTATED_SAVANNA", "SAVANNA_MOUNTAINS"),
    SHATTERED_SAVANNA_PLATEAU(BiomeType.OVERWORLD, "MUTATED_SAVANNA_ROCK", "SAVANNA_PLATEAU_MOUNTAINS"),
    SMALL_END_ISLANDS(BiomeType.END, "SKY_ISLAND_LOW"),
    SNOWY_BEACH(BiomeType.OVERWORLD, "COLD_BEACH"),
    SNOWY_MOUNTAINS(BiomeType.OVERWORLD, "ICE_MOUNTAINS"),
    SNOWY_TAIGA(BiomeType.OVERWORLD, "TAIGA_COLD", "COLD_TAIGA"),
    SNOWY_TAIGA_HILLS(BiomeType.OVERWORLD, "TAIGA_COLD_HILLS", "COLD_TAIGA_HILLS"),
    SNOWY_TAIGA_MOUNTAINS(BiomeType.OVERWORLD, "MUTATED_TAIGA_COLD", "COLD_TAIGA_MOUNTAINS"),
    SNOWY_TUNDRA(BiomeType.OVERWORLD, "ICE_FLATS", "ICE_PLAINS"),
    STONE_SHORE(BiomeType.OVERWORLD, "STONE_BEACH"),
    SUNFLOWER_PLAINS(BiomeType.OVERWORLD, "MUTATED_PLAINS"),
    SWAMP(BiomeType.OVERWORLD, "SWAMPLAND"),
    SWAMP_HILLS(BiomeType.OVERWORLD, "MUTATED_SWAMPLAND", "SWAMPLAND_MOUNTAINS"),
    TAIGA(BiomeType.OVERWORLD, "TAIGA"),
    TAIGA_HILLS(BiomeType.OVERWORLD, "TAIGA_HILLS"),
    TAIGA_MOUNTAINS(BiomeType.OVERWORLD, "MUTATED_TAIGA"),
    TALL_BIRCH_FOREST(BiomeType.OVERWORLD, "MUTATED_BIRCH_FOREST", "BIRCH_FOREST_MOUNTAINS"),
    TALL_BIRCH_HILLS(BiomeType.OVERWORLD, "MUTATED_BIRCH_FOREST_HILLS", "MESA_PLATEAU_FOREST_MOUNTAINS"),
    THE_END(BiomeType.END, "SKY"),
    THE_VOID(BiomeType.OVERWORLD, "VOID"),
    WARM_OCEAN(BiomeType.OVERWORLD, "WARM_OCEAN"),
    WOODED_BADLANDS_PLATEAU(BiomeType.OVERWORLD, "MESA_ROCK", "MESA_PLATEAU_FOREST"),
    WOODED_HILLS(BiomeType.OVERWORLD, "FOREST_HILLS"),
    WOODED_MOUNTAINS(BiomeType.OVERWORLD, "EXTREME_HILLS_WITH_TREES", "EXTREME_HILLS_PLUS"),
    BAMBOO_JUNGLE(BiomeType.OVERWORLD),
    BAMBOO_JUNGLE_HILLS(BiomeType.OVERWORLD);

    /**
     * A cached unmodifiable list of {@link XBiome#values()} to avoid allocating memory for
     * calling the method every time.
     *
     * @since 1.0.0
     */
    public static final List<XBiome> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final boolean supports = XMaterial.supports(16);
    @Nullable
    private final Biome biome;
    @Nonnull
    private final BiomeType biomeType;

    XBiome(@Nonnull BiomeType biometype, @Nonnull String... legacies) {
        this.biomeType = biometype;
        Data.NAMES.put(this.name(), this);
        for (String legacy : legacies) Data.NAMES.put(legacy, this);

        Biome biome = Enums.getIfPresent(Biome.class, this.name()).orNull();
        if (biome == null) {
            for (String legacy : legacies) {
                biome = Enums.getIfPresent(Biome.class, legacy).orNull();
                if (biome != null) break;
            }
        }
        this.biome = biome;
    }

    @Nonnull
    public BiomeType getBiomeType() {
        return biomeType;
    }

    /**
     * Attempts to build the string like an enum name.<br>
     * Removes all the spaces, numbers and extra non-English characters. Also removes some config/in-game based strings.
     * While this method is hard to maintain, it's extremely efficient. It's approximately more than x5 times faster than
     * the normal RegEx + String Methods approach for both formatted and unformatted material names.
     *
     * @param name the biome name to format.
     * @return an enum name.
     * @since 1.0.0
     */
    @Nonnull
    private static String format(@Nonnull String name) {
        int len = name.length();
        char[] chs = new char[len];
        int count = 0;
        boolean appendUnderline = false;

        for (int i = 0; i < len; i++) {
            char ch = name.charAt(i);
            if (!appendUnderline && count != 0 && (ch == '-' || ch == ' ' || ch == '_') && chs[count] != '_') appendUnderline = true;
            else {
                if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                    if (appendUnderline) {
                        chs[count++] = '_';
                        appendUnderline = false;
                    }
                    chs[count++] = (char) (ch & 0x5f);
                }
            }
        }

        return new String(chs, 0, count);
    }

    /**
     * Parses the XBiome with the given name.
     *
     * @param biome the name of the biome.
     * @return a matched XBiome.
     * @since 1.0.0
     */
    @Nonnull
    public static Optional<XBiome> matchXBiome(@Nonnull String biome) {
        Validate.notEmpty(biome, "Cannot match XBiome of a null or empty biome name");
        return Optional.ofNullable(Data.NAMES.get(format(biome)));
    }

    /**
     * Parses the XBiome with the given bukkit biome.
     *
     * @param biome the Bukkit biome.
     * @return a matched biome.
     * @throws IllegalArgumentException may be thrown as an unexpected exception.
     * @since 1.0.0
     */
    @Nonnull
    public static XBiome matchXBiome(@Nonnull Biome biome) {
        Objects.requireNonNull(biome, "Cannot match XBiome of a null biome");
        return Objects.requireNonNull(Data.NAMES.get(biome.name()), () -> "Unsupported biome: " + biome.name());
    }

    /**
     * Parses the XBiome as a {@link Biome} based on the server version.
     *
     * @return the vanilla biome.
     * @since 1.0.0
     */
    @Nullable
    public Biome getBiome() {
        return this.biome;
    }

    /**
     * Sets the biome of the chunk.
     * If the chunk is not generated/loaded already, it'll be generated and loaded.
     * Note that this doesn't send any update packets to the nearby clients.
     *
     * @param chunk the chunk to change the biome.
     * @return the async task handling this operation.
     * @since 1.0.0
     */
    @Nonnull
    public CompletableFuture<Void> setBiome(@Nonnull Chunk chunk) {
        Objects.requireNonNull(biome, () -> "Unsupported biome: " + this.name());
        Objects.requireNonNull(chunk, "Cannot set biome of null chunk");
        if (!chunk.isLoaded()) {
            Validate.isTrue(chunk.load(true), "Could not load chunk at " + chunk.getX() + ", " + chunk.getZ());
        }

        // Apparently setBiome is thread-safe.
        return CompletableFuture.runAsync(() -> {
            for (int x = 0; x < 16; x++) {
                // y loop for 1.16+ support (vertical biomes).
                // As of now increasing it by 4 seems to work.
                // This should be the minimal size of the vertical biomes.
                for (int y = 0; y < (supports ? 256 : 1); y += 4) {
                    for (int z = 0; z < 16; z++) {
                        Block block = chunk.getBlock(x, y, z);
                        if (block.getBiome() != biome) block.setBiome(biome);
                    }
                }
            }
        }).exceptionally((result) -> {
            result.printStackTrace();
            return null;
        });
    }

    /**
     * Change the biome in the selected region.
     * Unloaded chunks will be ignored.
     * Note that this doesn't send any update packets to the nearby clients.
     *
     * @param start the start position.
     * @param end   the end position.
     * @since 1.0.0
     */
    @Nonnull
    public CompletableFuture<Void> setBiome(@Nonnull Location start, @Nonnull Location end) {
        Objects.requireNonNull(start, "Start location cannot be null");
        Objects.requireNonNull(end, "End location cannot be null");
        Objects.requireNonNull(biome, () -> "Unsupported biome: " + this.name());
        Validate.isTrue(start.getWorld().getUID().equals(end.getWorld().getUID()), "Location worlds mismatch");

        // Apparently setBiome is thread-safe.
        return CompletableFuture.runAsync(() -> {
            for (int x = start.getBlockX(); x < end.getBlockX(); x++) {
                // y loop for 1.16+ support (vertical biomes).
                // As of now increasing it by 4 seems to work.
                // This should be the minimal size of the vertical biomes.
                for (int y = 0; y < (supports ? 256 : 1); y += 4) {
                    for (int z = start.getBlockZ(); z < end.getBlockZ(); z++) {
                        Block block = new Location(start.getWorld(), x, y, z).getBlock();
                        if (block.getBiome() != biome) block.setBiome(biome);
                    }
                }
            }
        }).exceptionally((result) -> {
            result.printStackTrace();
            return null;
        });
    }

    /**
     * Used for datas that need to be accessed during enum initilization.
     *
     * @since 3.0.0
     */
    private static final class Data {
        private static final Map<String, XBiome> NAMES = new HashMap<>();
    }

    private enum BiomeType {
        OVERWORLD, NETHER, END
    }
}