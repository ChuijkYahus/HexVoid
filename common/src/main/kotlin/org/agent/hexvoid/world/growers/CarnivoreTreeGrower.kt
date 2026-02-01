package org.agent.hexvoid.world.growers

import net.minecraft.resources.ResourceKey
import net.minecraft.util.RandomSource
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower
import net.minecraft.world.level.block.grower.AbstractTreeGrower
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import org.agent.hexvoid.registry.HexvoidFeatures

class CarnivoreTreeGrower : AbstractMegaTreeGrower() {

    override fun getConfiguredFeature(
        random: RandomSource,
        hasFlowers: Boolean
    ): ResourceKey<ConfiguredFeature<*, *>> {
        return HexvoidFeatures.CARNIVORE_TREE.key
    }

    override fun getConfiguredMegaFeature(random: RandomSource): ResourceKey<ConfiguredFeature<*, *>> {
        TODO("Not yet implemented")
    }
}