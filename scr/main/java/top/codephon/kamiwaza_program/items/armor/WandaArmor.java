package top.codephon.kamiwaza_program.items.armor;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.util.GeckoLibUtil;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.items.ItemReg;

import java.util.Set;
import java.util.function.Consumer;

//装备的物品
public class WandaArmor extends ArmorItem implements GeoItem {
    //缓存
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public WandaArmor(ArmorMaterial armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties);
    }

    //初始化
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        //渲染装备 继承GeoArmorRenderer<这个装备物品类>
        class WandaArmorRenderer extends GeoArmorRenderer<WandaArmor> {
            public WandaArmorRenderer() {
                //格式：
                //super(new DefaultedItemGeoModel<>(new ResourceLocation(MOD_ID, "路径/文件名（不含后缀）")));
                //备注：
                //模型放在 geo/item/路径/文件名.geo.json 的位置
                //贴图放在 textures/item/路径/文件名.png 的位置
                //动画放在 animations/item/路径/文件名.animation.json 的位置
                //路径 或 文件名 一定要遵守以上规则
                super(new DefaultedItemGeoModel<>(new ResourceLocation(KamiwazaProgram.MOD_ID, "armor/wanda_armor")));

                //添加 自发光（荧光？）渲染
                //具体 需要在 模型贴图名_glowmask.png里 在于贴图同位置处绘制
                //其它位置一定要保持透明的状态 可以直接复制并删除不需要的部分
                addRenderLayer(new AutoGlowingGeoLayer<>(this));
            }
        }

        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> renderer;
            //获取模型（来渲染）
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null) {
                    //new的是之后写的渲染类
                    this.renderer = new WandaArmorRenderer();
                }
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, 20, state -> {
            //设置闲置时的动作 （无其它动作时播放的动作在misc.idle里    DefaultAnimations还有其它默认的动作名）
            state.setAnimation(DefaultAnimations.IDLE);
            //获取装备装备的实体
            Entity entity = state.getData(DataTickets.ENTITY);

            //当 盔甲架 装备该装备时  保持播放其所装备的 此装备的装备动画
            if(entity instanceof ArmorStand){
                return PlayState.CONTINUE;
            }

            //所装备的装备集合
            Set<Item> wandaArmor = new ObjectOpenHashSet<>();

            for (ItemStack stack : entity.getArmorSlots()) {
                //当某个装备槽未装备装备时 不播放任何该装备的装备动画
                if(stack.isEmpty()){
                    return PlayState.STOP;
                }
                //添加装备的装备至「所装备的装备集合」里
                wandaArmor.add(stack.getItem());
            }

            //检查套装是否完整，不完整时不播放任何动画
            //格式：ObjectArrayList.of(
            //部件1，部件2，部件3，部件4)
            return wandaArmor.containsAll(ObjectArrayList.of(
                    ItemReg.wandaArmorHelmet.get(),
                    ItemReg.wandaArmorLeggings.get(),
                    ItemReg.wandaArmorChestplate.get(),
                    ItemReg.wandaArmorBoots.get())) ? PlayState.CONTINUE : PlayState.STOP;
        }));
    }

    //获取缓存
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
