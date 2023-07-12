package top.codephon.kamiwaza_program.gen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import top.codephon.kamiwaza_program.blocks.BlockReg;

import java.util.List;

public class RegOreFeatures{
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_WONDER = FeatureUtils.createKey("ore_wonder");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext) {
        RuleTest ruletest1 = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest ruletest2 = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> list_a =
                List.of(OreConfiguration.target(ruletest1, BlockReg.wonderOre.get().defaultBlockState()),
                        OreConfiguration.target(ruletest2, BlockReg.wonderOre.get().defaultBlockState()));
        FeatureUtils.register(bootstapContext, ORE_WONDER, Feature.ORE, new OreConfiguration(list_a, 7));
    }
}
