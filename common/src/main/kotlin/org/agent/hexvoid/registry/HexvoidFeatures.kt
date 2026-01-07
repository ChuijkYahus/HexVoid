package org.agent.hexvoid.registry

import com.sun.tools.javac.code.Type
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import org.agent.hexvoid.registry.HexvoidBlocks.BlockItemEntry
import org.agent.hexvoid.world.feature.CarnivoreMegaTree
import org.agent.hexvoid.world.feature.CarnivoreTree
import org.agent.hexvoid.world.feature.CarnivoreTreeConfig

object HexvoidFeatures : HexvoidRegistrar<Feature<*>>(
    Registries.FEATURE,
    { BuiltInRegistries.FEATURE }
) {
    @JvmField
    val CARNIVORE_TREE = registerConfiguredFeature("carnivore_tree",
        CarnivoreTreeConfig(3)) {
        CarnivoreTree(CarnivoreTreeConfig.CODEC)
    }

    @JvmField
    val CARNIVORE_MEGATREE = registerConfiguredFeature("carnivore_megatree",
        CarnivoreTreeConfig(3)) {
        CarnivoreMegaTree(CarnivoreTreeConfig.CODEC)
    }

    private fun <C : FeatureConfiguration, F : Feature<C>> feature(name: String, config: C, featureBuilder: (C) -> F) : Entry<F> {
        return register(name, featureBuilder(config))
    }

    private fun <C : FeatureConfiguration, F : Feature<C>, CF : ConfiguredFeature<C, F>> configuredFeature(
        name: String,
        configBuilder: () -> C,
        featureBuilder: (C) -> F,
    ): ConfiguredEntry<C, F, CF> {
        val featureEntry = feature(name, featureBuilder)
        val configuredFeature = ConfiguredFeature(featureBuilder(configBuilder()), configBuilder())
        return ConfiguredEntry(featureEntry, configuredFeature)
    }

    class ConfiguredEntry<C: FeatureConfiguration, F : Feature<C>, CF : ConfiguredFeature<C, F>>(
        featureEntry: Entry<F>,
        val configuredFeatureEntry: HexvoidRegistrar<ConfiguredFeature<C, F>>.Entry<CF>
    ) : Entry<F>(featureEntry) {
        val feature by ::value
        val configuredFeature by configuredFeatureEntry::value
    }
}