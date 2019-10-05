package com.fabriccommunity.spookytime.registry;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import com.fabriccommunity.spookytime.SpookyTime;
import com.fabriccommunity.spookytime.world.feature.DeceasedWildCropFeature;
import com.fabriccommunity.spookytime.world.feature.LargeSkeletalTreeFeature;
import com.fabriccommunity.spookytime.world.feature.SmallSkeletalTreeFeature;
import com.fabriccommunity.spookytime.world.feature.WitchWellFeature;

/**
 * @author Indigo Amann
 */
public class SpookyFeatures {
	public static final TernarySurfaceConfig SPOOKY_FOREST = new TernarySurfaceConfig(SpookyBlocks.DECEASED_GRASS_BLOCK.getDefaultState(), SpookyBlocks.DECEASED_DIRT.getDefaultState(), SpookyBlocks.TAINTED_GRAVEL.getDefaultState());
	
	public static final Feature<DefaultFeatureConfig> PUMPKIN = register("pumpkin", new DeceasedWildCropFeature(DefaultFeatureConfig::deserialize, Blocks.PUMPKIN.getDefaultState()));
	
	public static final Feature<DefaultFeatureConfig> SMALL_SKELETON_TREE = register("skeleton_tree_small", new SmallSkeletalTreeFeature(DefaultFeatureConfig::deserialize, false));
	public static final Feature<DefaultFeatureConfig> LARGE_SKELETON_TREE = register("skeleton_tree_large", new LargeSkeletalTreeFeature(DefaultFeatureConfig::deserialize, false));
	
	public static final Feature<DefaultFeatureConfig> WITCH_WELL = register("witch_well", new WitchWellFeature(DefaultFeatureConfig::deserialize));
	
	public static void init() {
	
	}
	
	public static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
		return Registry.register(Registry.FEATURE, SpookyTime.id(name), feature);
	}
}
