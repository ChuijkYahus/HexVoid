package org.agent.hexvoid.world.feature

import com.mojang.serialization.Codec
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext

class CarnivoreMegaTree(val configCodec: Codec<CarnivoreTreeConfig>) : Feature<CarnivoreTreeConfig>(configCodec) {
    override fun place(context: FeaturePlaceContext<CarnivoreTreeConfig>): Boolean {
        TODO("Not yet implemented")
    }
}