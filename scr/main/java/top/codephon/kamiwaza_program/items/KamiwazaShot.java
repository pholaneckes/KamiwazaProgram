package top.codephon.kamiwaza_program.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import top.codephon.kamiwaza_program.entities.finder.MinionSetup;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;
import top.codephon.kamiwaza_program.tools.Ways;

import java.util.List;

import static top.codephon.kamiwaza_program.entities.render.MinionModel.getMinName;
import static top.codephon.kamiwaza_program.tools.ModTools.keepTime;
import static top.codephon.kamiwaza_program.tools.ModTools.sendChat;

//建议不同功能的分开为不同的类

public class KamiwazaShot extends Item {
    public KamiwazaShot() {
        super(new Properties().stacksTo(1));
    }

    //物品每游戏刻都会在背包里执行的代码
    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean b) {
        //判断物品是否拥有（总）NBT标签（集），否的话新建一个
        if(!itemStack.hasTag()){
            itemStack.setTag(new CompoundTag());
        }
        //判断上述NBT标签（集）内是否有标签，不是空的的话新建一下的标签
        if(itemStack.getTag().isEmpty()){
            //添加标签支持多种数据类型 示例为：String，Float与int，下面还有UUID
            itemStack.getTag().putString("ChosenName","none");
//            itemStack.getTag().putFloat("MinionHP",-1);
            itemStack.getTag().putInt("ChosenId",-1);
            itemStack.getTag().putString("ScanName", "none");
            itemStack.getTag().putFloat("ScanHP", -1);
        }
        super.inventoryTick(itemStack, level, entity, i, b);
    }

    //当手持物品使用右键时触发（执行方法内代码）
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        //这个类/方法等会写，报错不用管 用于获取准星所对着的实体
        if(Ways.getPointedEntity(player, 64.0) != null){
            //获取准星所对着的实体
            Entity onLooked = Ways.getPointedEntity(player, 64.0);
            //获取物品的NBT（总）NBT标签（集）
            CompoundTag tag = player.getItemInHand(hand).getTag();
            //判断该实体是否是应该继续执行一下代码的实体
            if (onLooked instanceof MinionEntity minion && !tag.isEmpty()){
                if(!minion.isBugged()) {
                    keepTime = 0;
//                tag.putFloat("MinionHP", minion.getHealth());
                    tag.putString("ChosenName", getMinName(minion, true));
                    //判断实体是否被驯服 是的话继续执行
                    if (minion.isTame()) {
                        tag.putUUID("Owner", minion.getOwner().getUUID());
                        if(minion.getOwner().equals(player)){
                            //获取该标签（集）下属的各种（上面才写的）标签
                            tag.putInt("ChosenId", minion.getId());
                        }
                    }
                }else {
                    if(player.isShiftKeyDown() && !level.isClientSide){
                        keepTime++;
                        sendChat(player, ""+keepTime);
                        if(keepTime > 17){
                            keepTime = 0;
                            sendChat(player,"kwp.text.debug_comp");
                            player.addItem(new ItemStack(MinionSetup.MinSetUp.valueOf(getMinName(minion,false)).getMinCard()));
                            minion.remove(Entity.RemovalReason.DISCARDED);
                        }
                    }else if(!level.isClientSide){
                        keepTime = 0;
                    }
                }
            }else {
                keepTime = 0;
            }
        }
        return super.use(level, player, hand);
    }

    //当光标移植物品下所显示文本
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> componentList, TooltipFlag flagIn) {
        //获取标签
        CompoundTag nbtTag = itemStack.getTag();
        //（作用：防止报错）
        if (nbtTag != null && level != null) {
//            //这些“Min”不要照抄
//            if(!nbtTag.getString("MinName").equals("none")) {
//                //Component.translatable 是可翻译（本地化）词条，在语言文件内可以进行翻译（本地化）
//                componentList.add(Component.nullToEmpty(Component.translatable("kwp.text.min_chosen").getString()
//                + Component.translatable("entity.kamiwaza_program." + nbtTag.getString("MinName")
//                        .toLowerCase()).getString()));
//                componentList.add(Component.nullToEmpty(Component.translatable("kwp.text.id").getString() + nbtTag.getInt("MinId")));
//                componentList.add(Component.nullToEmpty(Component.translatable("kwp.text.hp").getString() + nbtTag.getFloat("MinionHP")));
//            }else {
//                //没有选择实体时提示“未选择目标”
//                componentList.add(Component.translatable("kwp.text.empty_in"));
//            }
            if(!nbtTag.getString("ScanName").equals("none")) {
                componentList.add(Component.nullToEmpty(Component.translatable("kwp.text.card_chosen").getString()
                        + Component.translatable("entity.kamiwaza_program." + nbtTag.getString("ScanName")
                        .toLowerCase()).getString()));
                componentList.add(Component.nullToEmpty(Component.translatable("kwp.text.hp").getString() + nbtTag.getFloat("ScanHP")));
            }else {
                componentList.add(Component.translatable("kwp.text.empty_scan"));
            }
        }
        super.appendHoverText(itemStack, level, componentList, flagIn);
    }
}
