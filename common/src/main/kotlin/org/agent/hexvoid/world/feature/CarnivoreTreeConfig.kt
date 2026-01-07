package org.agent.hexvoid.world.feature

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.util.ExtraCodecs
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration

class CarnivoreTreeConfig(val size: Int) : FeatureConfiguration {
    companion object {
        val CODEC : Codec<CarnivoreTreeConfig> = RecordCodecBuilder.create {
            instance -> instance.group(
            ExtraCodecs.POSITIVE_INT.fieldOf("size").forGetter(CarnivoreTreeConfig::size))
            .apply(instance) { size: Int -> CarnivoreTreeConfig(size) }
        }
    }
}