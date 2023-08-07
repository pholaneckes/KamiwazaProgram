package top.codephon.kamiwaza_program.screen.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.NotNull;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.items.KamiwazaFile;
import top.codephon.kamiwaza_program.keys.MinKeyBending;

import static top.codephon.kamiwaza_program.screen.gui.MinionWikiScreen.*;

//仅客户端
@OnlyIn(Dist.CLIENT)
public class MinionWikiInnerScreen extends Screen {

    public static String inner_name = "none";
    public static String attribute = "none";
    public static String seiBetsu = "none";
    public MinionWikiInnerScreen() {
        super(Component.translatable("kwp.gui.wikipa"));
    }
    KWPImageButton card, attri, seibetsu;
    ImageButton back;

    KWPTextWidget wikiInfo;

    public static int xSize = 256;
    public static int ySize = 197;

    //渲染
    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float parTicks) {
        super.render(graphics, mouseX, mouseY, parTicks);
        //初始化
        graphics.setColor(1.0f,1.0f,1.0f,1.0f);
        int wid = (this.width - xSize) / 2;
        //渲染背景
        graphics.blit(BGTEXTURE,wid,27,0,0,xSize,ySize);
        //渲染居中的文本
        graphics.drawCenteredString(this.font,Component.translatable("kwp.gui.wikipa"),
                this.width/2+44,34,-45479);
        //渲染各种组件
        card.render(graphics,mouseX,mouseY,parTicks);
        attri.render(graphics,mouseX,mouseY,parTicks);
        seibetsu.render(graphics,mouseX,mouseY,parTicks);
        back.render(graphics,mouseX,mouseY,parTicks);
        wikiInfo.render(graphics,mouseX,mouseY,parTicks);
    }

    //添加图标
    @Override
    protected void init() {
        super.init();
        this.back = new ImageButton(this.width / 2 + 65, 12, 48, 32,
                0, 0, 0, new ResourceLocation(KamiwazaProgram.MOD_ID,"textures/gui/back.png"),
                48, 32, (button) -> {
            doSearch = false;
            DistExecutor.safeCallWhenOn(Dist.CLIENT,()-> KamiwazaFile.OpenWikiGui::new);
        },Component.nullToEmpty("kwp.text.back"));
        this.addWidget(back);
        this.attri = new KWPImageButton(new ResourceLocation(KamiwazaProgram.MOD_ID,"textures/gui/attri/"+attribute+".png"),this.width/ 2-7,34,32,32,Component.nullToEmpty(attribute),Component.translatable("minion.attri."+attribute).getString(),(button)->{
        },29);
        this.addWidget(attri);
        this.card = new KWPImageButton(getCardRes(inner_name),this.width/ 2-129,-3,128,128,Component.nullToEmpty(inner_name),Component.translatable("entity.kamiwaza_program."+inner_name).getString(),(button)->{
        },97,61);
        this.addWidget(card);
        this.seibetsu = new KWPImageButton(new ResourceLocation(KamiwazaProgram.MOD_ID,"textures/gui/seibetsu/"+seiBetsu+".png"),this.width/ 2-7,72,32,16,Component.nullToEmpty(seiBetsu),"",(button)->{
        });
        this.addWidget(seibetsu);

        this.wikiInfo = new KWPTextWidget(this.width/ 2-123,53,70,110,createWiki(),this.font).alignLeft();
        this.addWidget(wikiInfo);
    }

    public static Component createWiki(){
        return !Component.translatable("wiki." + inner_name).getString().equals("wiki." + inner_name)
                ?
                Component.nullToEmpty(Component.translatable("kwp.txt.shoukai").getString() +
                        //将 本地化文件的一些特殊文本 转换为一些值
                        //例如这里 把“#KEY:use_waza”这一段转换成了 玩家绑定的键位，不用转换而采用分段的话可能不适用一些语言
                        Component.translatable("wiki."+inner_name).getString().replaceAll("#KEY:use_waza",
                                MinKeyBending.USE_WAZA.getKey().getName().toUpperCase().replaceAll("KEY.KEYBOARD.",
                                        Component.translatable("kwp.txt.keyboard").getString())))
                :
                //提示 暂无wiki的内容
                Component.nullToEmpty(Component.translatable("entity.kamiwaza_program."+inner_name).getString() +
                        Component.translatable("kwp.txt.has_no_wiki_intro").getString());
    }
}
