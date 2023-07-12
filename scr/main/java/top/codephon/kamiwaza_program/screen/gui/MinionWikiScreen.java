package top.codephon.kamiwaza_program.screen.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import top.codephon.kamiwaza_program.KamiwazaProgram;
import top.codephon.kamiwaza_program.items.KamiwazaFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static top.codephon.kamiwaza_program.entities.finder.MinionSetup.isEnglish;
import static top.codephon.kamiwaza_program.entities.finder.MinionSetup.minionListDown;

//仅客户端
@OnlyIn(Dist.CLIENT)
//GUI实现类
public class MinionWikiScreen extends Screen {
    //（记录页码用的）
    public static byte page;
    private static String[] searched= new String[]{};
    private static String[] searchNeeds= new String[]{};

    public static boolean doSearch = false;
    public MinionWikiScreen() {
        super(Component.translatable("kwp.gui.wikipa"));
    }

    //文本编辑栏（文本矿）
    EditBox editBox;
    //普通的按钮
    Button button;
    //原版的图像按钮
    ImageButton imageButtonL, imageButtonR;
    //自己实现的带文本的图像按钮
    KWPImageButton kwpImageButton1, kwpImageButton2, kwpImageButton3, kwpImageButton4, kwpImageButton5,kwpImageButton6,kwpImageButton7,kwpImageButton8,kwpImageButton9,kwpImageButton10,kwpImageButton11,kwpImageButton12,kwpImageButton13,kwpImageButton14,kwpImageButton15,kwpImageButton16;

    //背景的大小（X宽，Y高），不建议过度改动
    public static int xSize = 256;
    public static int ySize = 197;
    //背景图片路径 一定要带.png
    public static final ResourceLocation BGTEXTURE =
            new ResourceLocation(KamiwazaProgram.MOD_ID,"textures/gui/wikipa.png");
    //渲染
    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float parTicks) {
        super.render(graphics, mouseX, mouseY, parTicks);
        //初始化
        graphics.setColor(1.0f,1.0f,1.0f,1.0f);

        int wid = (this.width - xSize) / 2;

        //渲染背景 graphics.blit(贴图，起始宽，起始高，贴图文件的起始X坐标（一般0），贴图文件的起始Y坐标（一般0），贴图文件的中止X坐标，贴图文件的中止Y坐标);
        //起始XY坐标 通俗来说就是贴图（在文件内）最左上角的坐标，中止XY坐标 通俗来说就是贴图（在文件内）最右下角的坐标
        graphics.blit(BGTEXTURE,wid,27,0,0,xSize,ySize);

        //渲染（居中的）文本 graphics.drawCenteredString(字体，Component文本，X坐标，Y坐标，颜色（0X颜色编号也可以）);
        graphics.drawCenteredString(this.font,Component.translatable("kwp.gui.wikipa"),
                this.width/2,34,-45479);

        //渲染各种组件   (this.)按钮滑栏或文本框.render(graphics,mouseX,mouseY,parTicks);
        this.editBox.render(graphics,mouseX,mouseY,parTicks);
        imageButtonL.render(graphics,mouseX,mouseY,parTicks);
        imageButtonR.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton1.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton2.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton3.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton4.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton5.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton6.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton7.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton8.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton9.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton10.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton11.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton12.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton13.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton14.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton15.render(graphics,mouseX,mouseY,parTicks);
        kwpImageButton16.render(graphics,mouseX,mouseY,parTicks);
    }

    //定义
    @Override
    protected void init() {
        super.init();
        //定义本文编辑框 框 = new EditBox(字体，X坐标，Y坐标，框宽，框高，名称){可选};
        this.editBox = new EditBox(this.font, this.width/2+35,33,85,17,Component.empty()){
            @Override
            //每次输入字符的时候运行一次
            public boolean charTyped(char c, int length) {
                //判断字符是什么
                if(c == ' '){
                    //获取输入的字符
                    String str = editBox.getValue();
                    //若字符不为空继续
                    if(!str.isEmpty()){
                        List<String> searchResult = new ArrayList<>();
                        //判断是否是英文
                        if(!isEnglish(str)){
                            //todo
                        }else {
                            //遍历数组获取搜索结果
                            for (int i = 0; i < minionListDown.length;i++){
                                String comp = minionListDown[i];
                                if(comp.contains(str)){
                                    searchResult.add(comp);
                                }
                            }
                        }
                        //防止BUG
                        for (int i = 0; i <= 16; i++){
                            searchResult.add("none");
                        }
                        searched = searchResult.toArray(new String[0]);
                        doSearch = true;
                        page = 0;
                        //刷新
                        DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> KamiwazaFile.OpenWikiGui::new);
                    }
                }
                return super.charTyped(c, length);
            }
        };

        this.addWidget(editBox);

        //判断是否进行过搜索
        if(doSearch){
            searchNeeds = searched;
        }else {
            searchNeeds = minionListDown;
        }

        //原版图像按钮的其中一种定义样式方式：
        //this.按钮 = new ImageButton(X坐标，Y坐标，贴图大小X，贴图大小Y；
        //贴图文件X坐标，贴图文件Y坐标，鼠标放在上面向下偏移的贴图文件坐标距离，文件路径，拉伸X（可同前面X坐标），拉伸Y，
        //(button) -> {按下所执行的代码},按钮的名称（可选）));
        //添加按钮 this.addWidget(按钮);
        this.imageButtonL = new ImageButton(this.width / 2 - 149, 85, 32, 64,
                0, 0, 0, new ResourceLocation(KamiwazaProgram.MOD_ID,"textures/gui/prev.png"),
                32, 64, (button) -> {
            if(page > 0) {
                page--;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> KamiwazaFile.OpenWikiGui::new);
            }
            KamiwazaProgram.LOGGER.info("Left");
        },Component.nullToEmpty("kwp.text.l"));
        this.addWidget(imageButtonL);

        this.imageButtonR = new ImageButton(this.width / 2 + 117, 85, 32, 64,
                0, 0, 0, new ResourceLocation(KamiwazaProgram.MOD_ID,"textures/gui/next.png"),
                32, 64, (button) -> {
            if(page < Mth.ceil(searchNeeds.length-32) / 16.0) {
                page++;
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> KamiwazaFile.OpenWikiGui::new);
            }
            KamiwazaProgram.LOGGER.info("Right" +searchNeeds+ searchNeeds.length);
        },Component.nullToEmpty("kwp.text.r"));
        this.addWidget(imageButtonR);

        //这个是前面实现的带文本的图像按钮的快捷定义方式 （addKWPIB(this.width, X偏移, Y坐标, 文本);）
        this.kwpImageButton1 = addKWPIB(this.width,- 119, 35, searchNeeds[page*16]);
        this.addWidget(kwpImageButton1);

        this.kwpImageButton2 = addKWPIB(this.width,-61,35,searchNeeds[page*16+1]);
        this.addWidget(kwpImageButton2);

        this.kwpImageButton3 = addKWPIB(this.width,- 3,35,searchNeeds[page*16+2]);
        this.addWidget(kwpImageButton3);

        this.kwpImageButton4 = addKWPIB(this.width,+ 55,35,searchNeeds[page*16+3]);
        this.addWidget(kwpImageButton4);

        this.kwpImageButton5 = addKWPIB(this.width,- 119,75,searchNeeds[page*16+4]);
        this.addWidget(kwpImageButton5);

        this.kwpImageButton6 = addKWPIB(this.width,-61,75,searchNeeds[page*16+5]);
        this.addWidget(kwpImageButton6);

        this.kwpImageButton7 = addKWPIB(this.width,- 3,75,searchNeeds[page*16+6]);
        this.addWidget(kwpImageButton7);

        this.kwpImageButton8 = addKWPIB(this.width,+ 55,75,searchNeeds[page*16+7]);
        this.addWidget(kwpImageButton8);

        this.kwpImageButton9 = addKWPIB(this.width,- 119,115,searchNeeds[page*16+8]);
        this.addWidget(kwpImageButton9);

        this.kwpImageButton10 = addKWPIB(this.width,-61,115,searchNeeds[page*16+9]);
        this.addWidget(kwpImageButton10);

        this.kwpImageButton11 = addKWPIB(this.width,- 3,115,searchNeeds[page*16+10]);
        this.addWidget(kwpImageButton11);

        this.kwpImageButton12 = addKWPIB(this.width,+ 55,115,searchNeeds[page*16+11]);
        this.addWidget(kwpImageButton12);

        this.kwpImageButton13 = addKWPIB(this.width,- 119,155,searchNeeds[page*16+12]);
        this.addWidget(kwpImageButton13);

        this.kwpImageButton14 = addKWPIB(this.width,-61,155,searchNeeds[page*16+13]);
        this.addWidget(kwpImageButton14);

        this.kwpImageButton15 = addKWPIB(this.width,- 3,155,searchNeeds[page*16+14]);
        this.addWidget(kwpImageButton15);

        this.kwpImageButton16 = addKWPIB(this.width,+ 55,155,searchNeeds[page*16+15]);
        this.addWidget(kwpImageButton16);
    }

    private static KWPImageButton addKWPIB(int width, int xA, int y, String min){
        return new KWPImageButton(getCardRes(min),width / 2 + xA, y, 64, 64,Component.translatable("entity.kamiwaza_program."+min), show(min), (button)->{
            KamiwazaProgram.LOGGER.info(min);
        },49,26);
    }

    private static ResourceLocation getCardRes(String min){
        String[] minAvail = new String[]{"turbomin"};
        return ArrayUtils.contains(minAvail,min) ? new ResourceLocation(KamiwazaProgram.MOD_ID,"textures/item/card/"+min.replaceAll("min","")+".png") : new ResourceLocation(KamiwazaProgram.MOD_ID,"textures/item/card/none.png");
    }

    private static String show(String min){
        String str = Component.translatable("entity.kamiwaza_program." + min).getString();
        return str.contains(".") ? min : str;
    }
}
