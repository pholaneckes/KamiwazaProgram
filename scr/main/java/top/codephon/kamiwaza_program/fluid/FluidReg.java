package top.codephon.kamiwaza_program.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.blocks.BlockReg;
import top.codephon.kamiwaza_program.items.ItemReg;

import java.util.function.Consumer;

public class FluidReg {
    //流体材质
    //静止时的材质
    static final ResourceLocation VEGET_OIL = new ResourceLocation(KamiwazaProgram.MOD_ID,"block/fluid/veget_oil");
    //流动时的材质
    static final ResourceLocation VEGET_OIL_F = new ResourceLocation(KamiwazaProgram.MOD_ID,"block/fluid/veget_oil_f");
    //液体注册主字段
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, KamiwazaProgram.MOD_ID);
    //流体属性注册主字段
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, KamiwazaProgram.MOD_ID);
    //注册流体属性
    //格式：public static RegistryObject<FluidType> 流体属性字段名 = 流体属性主字段.register("流体属性注册名"，
    //      () -> new FluidType(FluidType.Properties.create()
    //            .density(密度/克每立方厘米).temperature(温度/摄氏度).viscosity(粘度/厘泊).canDrown(可溺死).canSwim(可游泳).lightLevel(亮度0-15)
    //            .descriptionId("文本")){
    //            ...（绑定材质的部分）
    //     });
    public static RegistryObject<FluidType> vegetOilType = FLUID_TYPES.register("veget_oil",
            ()->new FluidType(FluidType.Properties.create()
                    .density(920).temperature(23).viscosity(63).canDrown(true).canSwim(true).lightLevel(1)
                    .descriptionId("fluid.kamiwaza_program.veget_oil")) {
        @Override
        //绑定材质
        public void initializeClient(Consumer<IClientFluidTypeExtensions> iClientFluidTypeExtensionsConsumer) {
            iClientFluidTypeExtensionsConsumer.accept(new IClientFluidTypeExtensions() {
                @Override
                //绑定静态的
                public ResourceLocation getStillTexture() {
                    return VEGET_OIL;
                }
                @Override
                //绑定流动的
                public ResourceLocation getFlowingTexture() {
                    return VEGET_OIL_F;
                }
            });
        }
    });
    //注册流体
    //格式：
    // 静态的：public static RegistryObject<FlowingFluid> 流体主字段 =
    //          流体主字段.register("流体注册名", () -> new ForgeFlowingFluid.Source(下方的Builder方法()));
    // 流动的：public static RegistryObject<FlowingFluid> 流体主字段 =
    //          流体主字段.register("流体注册名", () -> new ForgeFlowingFluid.Flowing(下方的Builder方法()));
    public static RegistryObject<FlowingFluid> stillVegetOil =
            FLUIDS.register("veget_oil",()->new ForgeFlowingFluid.Source(vegetOilBuilder()));
    public static RegistryObject<FlowingFluid> flowingVegetOil =
            FLUIDS.register("veget_oil_flowing",()->new ForgeFlowingFluid.Flowing(vegetOilBuilder()));

    //流体Builder方法
    //返回格式：
    //return new ForgeFlowingFluid.Properties(流体属性，流体的静态，流体的动态).block(流体对应的方块字段（见后）).bucket(流体桶字段（见后）);
    private static ForgeFlowingFluid.Properties vegetOilBuilder() {
        return new ForgeFlowingFluid.Properties(vegetOilType,stillVegetOil,flowingVegetOil)
                .block(BlockReg.vegetOilBlock).bucket(ItemReg.vegetOilBucket);
    }
}
