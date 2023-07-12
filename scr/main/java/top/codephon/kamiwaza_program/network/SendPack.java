package top.codephon.kamiwaza_program.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import org.lwjgl.glfw.GLFW;
import top.codephon.kamiwaza_program.entities.Attri;
import top.codephon.kamiwaza_program.entities.EntityReg;
import top.codephon.kamiwaza_program.entities.finder.MinionSetup;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;
import top.codephon.kamiwaza_program.entities.mins.Turbomin;
import top.codephon.kamiwaza_program.items.KamiwazaCard;
import top.codephon.kamiwaza_program.items.KamiwazaShot;
import top.codephon.kamiwaza_program.tools.Ways;

import java.util.UUID;
import java.util.function.Supplier;

import static top.codephon.kamiwaza_program.entities.render.MinionModel.getMinName;
import static top.codephon.kamiwaza_program.events.JoinEvents.pubServerLevel;
import static top.codephon.kamiwaza_program.tools.ModTools.getLookPos;
import static top.codephon.kamiwaza_program.tools.ModTools.sendChat;

//类名称不建议更变
public class SendPack {
    //可能用到的发包数据类型 支持的类型不多 不建议重复的类型添加多个，容易窜
    private final UUID uuid;
    private final int integer;
    private final short type;
    private final boolean boo;
    private final String text;

    //每有一个变量，就要为该类型写一行 这个是读取 变量 = buf.read变量类型(); 其中String是readUtf()
    public SendPack(FriendlyByteBuf buf) {
        uuid = buf.readUUID();
        integer = buf.readInt();
        type = buf.readShort();
        boo = buf.readBoolean();
        text = buf.readUtf();
    }

    //各种接包的方法 每个参数（类型及数量）都不同 用不到的类型随便填点值，但不可以不填或者填null
    public SendPack(UUID uuid, short type) {
        this.uuid = uuid;
        this.integer = -1;
        this.type = type;
        this.boo = false;
        this.text = "none";
    }

    public SendPack(UUID uuid, short type, boolean boo) {
        this.uuid = uuid;
        this.integer = -1;
        this.type = type;
        this.boo = boo;
        this.text = "none";
    }

    //每有一个变量，就要为该类型写一行 这个是写入 buf.write类型(this.其变量);
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUUID(this.uuid);
        buf.writeInt(this.integer);
        buf.writeShort(this.type);
        buf.writeBoolean(this.boo);
        buf.writeUtf(this.text);
    }

    //接收包 这里用 if()判断是哪种用途发的包
    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if(type == 1) {
                toUseWaza(uuid,boo);
            }
            if(type == 2){
                toArise(uuid);
            }else if(type == 4){
                toBack(uuid);
            }
            if(type == 3){
                toScan(uuid);
            }
        });
        ctx.get().setPacketHandled(true);
    }

    //可以加上@OnlyIn(Dist.DEDICATED_SERVER) 但可能会在单机有点问题
    //发包 和 实体属性的示例
    public static void toUseWaza(UUID uuid, boolean isMe){
        //从服务器通过玩家UUID来获取玩家
        Player player = (Player) pubServerLevel.getEntity(uuid);
        //获取玩家主手物品
        ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        Item item = itemStack.getItem();
        if(item instanceof KamiwazaShot && !itemStack.getTag().isEmpty()){
            //获取物品（相机）里记录的实体ID
            int chosenId = itemStack.getTag().getInt("ChosenId");
            //获取准星对着的实体
            Entity toWho = Ways.getPointedEntity(player, 64.0);
            if(chosenId != -1){
                //获取 物品（相机）里记录的实体ID 的实体
                Entity entity = pubServerLevel.getEntity(chosenId);
                //判断该实体是否还在 （entity.isAlive()）
                if(entity != null && entity.isAlive() && entity instanceof MinionEntity minion) {
                    //（使用给的对象）
                    LivingEntity be_er;
                    //这里是发包时发的变量 用来判断使用给的对象 是玩家还是玩家对着的实体
                    if (isMe) {
                        be_er = player;
                        sendChat(player, Component.translatable("kwp.text.for_me_already").getString());
                    }else if(toWho instanceof LivingEntity livinger){
                        be_er = livinger;
                    }else {
                        return;
                    }
                    //判断 物品（相机）里记录的实体的具体类型 加速精灵的作用为”加速实体速度“
                    if (minion instanceof Turbomin turbomin) {
                        //获取 物品（相机）里记录的实体 所剩下的”能量“实体属性 （刚刚注册的那个）
                        AttributeInstance turboEnergy = turbomin.getAttribute(Attri.PROMIN_ENERGY.get());
                        //判断是否大于90  实体属性（变量）.getBaseValue()  是获取该实体实体属性的值
                        if (turboEnergy.getBaseValue() >= 90) {
                            //获取 使用给的对象 的速度属性值
                            double speedValue = be_er.getAttributeValue(Attributes.MOVEMENT_SPEED);
                            //判断实体是否有 叫作"turbomin_already"的tag标签 和之前的讲的实体NBT标签不是同一种东西
                            if (!be_er.getTags().contains("turbomin_already")) {
                                //更变实体的速度属性值至原来的3倍 来实现加速的效果 （.setBaseValue设置实体属性值）
                                be_er.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(speedValue * 3);
                                //给实体添加叫作"turbomin_already"的tag标签 避免之后无限提升速度
                                be_er.getTags().add("turbomin_already");
                                //使 物品（相机）里记录的实体 的 ”能量“实体属性 减少90
                                turboEnergy.setBaseValue(turboEnergy.getBaseValue() - 90);
                                //给玩家发送提示消息
                                sendChat(player, be_er.getName().getString() +
                                        Component.translatable("kwp.txt.3xspeed").getString() + "(" + speedValue + ")");
                            } else {
                                //若 重复对 使用给的对象 使用过了 也要提示一下
                                sendChat(player, Component.translatable("kwp.text.already_do").getString());
                            }
                        } else {
                            //物品（相机）里记录的实体 的 ”能量“实体属性 值 不足 也要提示一下
                            sendChat(player, Component.translatable("kwp.text.energy_not").getString());
                        }
                    }
                }
            }
        }
    }

    //更多的
    public static void toArise(UUID uuid){
        Player player = (Player) pubServerLevel.getEntity(uuid);
        Item mainHand = player.getItemInHand(InteractionHand.MAIN_HAND).getItem();
        Item offHand = player.getItemInHand(InteractionHand.OFF_HAND).getItem();
        //（手持的物品，不要用这个变量名）
        ItemStack shot;
        if(mainHand instanceof KamiwazaShot){
            shot = player.getItemInHand(InteractionHand.MAIN_HAND);
        }else if(offHand instanceof KamiwazaShot){
            shot = player.getItemInHand(InteractionHand.OFF_HAND);
        }else {
            //sendChat是刚刚的”快捷发送消息至玩家聊天栏（可本地化的文本）“
            sendChat(player, "kwp.txt.item_unfounded");
            //主副手都没有该物品就提示并不再执行下列代码
            return;
        }
        //具体探测是某一实体，之后会有 养成系列专教程
        if(!shot.getTag().getString("ScanName").equals("none")) {
            //获取一下EntityType，就是模组实体字段名.get()
            EntityType<? extends MinionEntity> min = MinionSetup.MinSetUp.valueOf(shot.getTag().getString("ScanName").toUpperCase()).getMinET();
            //生成实体至玩家看向的地方 刚才没提前在JoinEvent里获取ServerLevel的话，在这里直接获取不了，就用不了这个实体生成
            MinionEntity minion = min.spawn(pubServerLevel, null, player, getLookPos(player),
                    MobSpawnType.MOB_SUMMONED, false, false);
            //可驯服实体.tame(player); 就是驯服实体
            minion.beBugged(false);
            minion.removeEffect(MobEffects.INVISIBILITY);
            minion.tame(player);
            sendChat(player,Component.translatable("kwp.txt.charge").getString());
            shot.getTag().putString("ScanName","none");
        }
    }

    public static void toBack(UUID uuid){
        Player player = (Player) pubServerLevel.getEntity(uuid);
        Entity pointedEntity = Ways.getPointedEntity(player, 32.0);
        if(pointedEntity instanceof MinionEntity minion && minion.isTame() && minion.getOwner().equals(player)){
            String minName = getMinName(minion, false);
            minion.remove(Entity.RemovalReason.DISCARDED);
            player.addItem(new ItemStack(MinionSetup.MinSetUp.valueOf(minName).getMinCard()));
        }
    }

    public static void toScan(UUID uuid){
        Player player = (Player) pubServerLevel.getEntity(uuid);
        //获取玩家主手（InteractionHand.MAIN_HAND）/副手（InteractionHand.OFF_HAND）的物品（栈）
        ItemStack shot = player.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack card = player.getItemInHand(InteractionHand.OFF_HAND);
        //获取具体的物品
        Item mainHand = shot.getItem();
        Item offHand = card.getItem();
        //检查手持物品是否符合要求（属于某一种物品/方块）
        if(mainHand instanceof KamiwazaShot && offHand instanceof KamiwazaCard){
            //物品.builtInRegistryHolder().key().location().getPath()获取物品注册名 （不含模组名）
            //然后并设置为物品指定的NBT
            shot.getTag().putString("ScanName",offHand.builtInRegistryHolder().key().location()
                    .getPath().replaceAll("_card","min"));
            sendChat(player,Component.translatable("kwp.txt.read_comp").getString());
            card.shrink(1);
        }
    }
}
