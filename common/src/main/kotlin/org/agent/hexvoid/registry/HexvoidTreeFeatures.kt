package org.agent.hexvoid.registry

import net.minecraft.core.registries.Registries
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.TreeFeature

object HexvoidTreeFeatures : HexvoidRegistrar<TreeFeature>(
    Registries.FEATURE,
    { Feature.TREE }
) {
}