package top.codephon.kamiwaza_program.entities.render;

import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.ArrayUtils;
import software.bernie.geckolib.model.GeoModel;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;

import java.util.Objects;

//实体模型类 GeoModel<>里填自己的实体所在类
public class MinionModel extends GeoModel<MinionEntity> {

    //标注贴图类型被哪些实体所拥有，否则没有该类型的实体渲染会有问题
    public static String[] hasHaha = new String[]{"turbomin"};
    public static String[] hasScared = new String[]{"turbomin"};
    public static String[] hasBugTexture = new String[]{"turbomin"};

    @Override
    //模型所在路径
    public ResourceLocation getModelResource(MinionEntity animatable) {
        //模组内所有实体文件名格式建议保持一致 路径是从resources文件夹开始算起
        return new ResourceLocation(KamiwazaProgram.MOD_ID, "geo/"+getMinName(animatable, true)+".geo.json");
    }

    //贴图所在路径
    @Override
    //建议放在textures/entity中，每种实体要分类也可以，路径要改一改
    public ResourceLocation getTextureResource(MinionEntity animatable) {
        //先把可能用到的变量添加到方法最前面，这样会简洁一些
        String name = getMinName(animatable, true);
        String emotion = animatable.getEmotion();
        boolean isBugged = animatable.isBugged();
        ResourceLocation min_texture;
        //根据实体NBT标签来更变实体的贴图（若有）
        if(!isBugged || !ArrayUtils.contains(hasBugTexture,name)) {
            //所有实体的文件名格式要同一
            if(Objects.equals(emotion, "haha") && ArrayUtils.contains(hasHaha,name)){
                min_texture = new ResourceLocation(KamiwazaProgram.MOD_ID, "textures/entity/mins/" + name + "_haha.png");
            }else if(Objects.equals(emotion, "scared") && ArrayUtils.contains(hasScared,name)){
                min_texture= new ResourceLocation(KamiwazaProgram.MOD_ID, "textures/entity/mins/" + name + "_scared.png");
            }else {
                min_texture = new ResourceLocation(KamiwazaProgram.MOD_ID, "textures/entity/mins/" + name + ".png");
            }
        }else {
            min_texture = new ResourceLocation(KamiwazaProgram.MOD_ID, "textures/entity/mins/bug_" + name + ".png");
        }
        return min_texture;
    }

    //动作文件所在处
    @Override
    public ResourceLocation getAnimationResource(MinionEntity animatable) {
        return new ResourceLocation(KamiwazaProgram.MOD_ID, "animations/"+getMinName(animatable, true)+".anime.json");
    }

    //这个是获取实体名称的一种方式，缺点：前提是实体注册名要和实体所在类名保持一致 且 所有实体要在同一包目录下
    //isSmall是 是否小写，可以删去但不建议，之后枚举还要用
    public static String getMinName(MinionEntity animatable, boolean isSmall){
        //regex:是所在包名路径
        String name = animatable.getClass().getName().replaceAll("top.codephon.kamiwaza_program.entities.mins.","");
        name = isSmall ? name.toLowerCase() : name.toUpperCase();
        return name;
    }
}
