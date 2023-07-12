package top.codephon.kamiwaza_program.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.codephon.kamiwaza_program.entities.mins.MinionEntity;
import top.codephon.kamiwaza_program.entities.mins.Turbomin;
import top.codephon.kamiwaza_program.items.ItemReg;
import top.codephon.kamiwaza_program.tools.Ways;

import static top.codephon.kamiwaza_program.tools.ModTools.sendChat;

@Mod.EventBusSubscriber
public class KWPCommand {
    @SubscribeEvent
    //注册命令的事件
    public static void registerCommands(RegisterCommandsEvent event) {
        //literal()里的是命令的名称 输入/XXX的那个名称
        event.getDispatcher().register(LiteralArgumentBuilder.<CommandSourceStack>literal("kwp")
                //表示需要2级（管理员）的权限，0是任何玩家都可以执行
                .requires((req)->req.hasPermission(2))
                //子命令的名称 /XXX yyy 那个
                .then(Commands.literal("promin")
                        //第二段子命令的名称
                        .then(Commands.literal("giveTo")
                                //命令参数 这里是实体的参数 /XXX yyy zzz @s 的那个参数  一个命令没有任何一个参数也可以
                                //注册命令的后（ 需要集中最后来添加
                                //参数添加格式：.then(Commands.argument("参数名称", 某某Argument（可能有Type）.某类型())
                                .then(Commands.argument("player",EntityArgument.entity())
                                        //执行（回车后）需要运行的命令
                                        .executes(arg -> {
                                            //获取输入命令的来源（实体）
                                            Entity me = arg.getSource().getEntity();
                                            //获取命令的参数
                                            //某某Argument（可能有Type）.get某某类型arg.copyFor(arg.getSource()), "参数名称")
                                            Player player = EntityArgument.getPlayer(arg.copyFor(arg.getSource()), "player");
                                            //获取准星对着的实体
                                            Entity min = Ways.getPointedEntity(me, 64.0);
                                            //判断条件 （实体为对应实体且命令的来源是玩家实体且实体被驯服且实体主人是执行者）
                                            if (min instanceof MinionEntity minion && me instanceof Player myself && minion.isTame() && minion.getOwner().equals(me)) {
                                                //将实体驯服给其他的玩家（也可以是自己，但无意义）
                                                minion.tame(player);
                                                //对执行者发送Ok表示执行成功
                                                sendChat(myself, "Ok");
                                                //对被给予者发送收到的提示 实体.getName().getString()是获取实体名称
                                                sendChat(player, myself.getName().getString() + " has given " + minion.getName().getString() + " to you!");
                                            }
                                            //return几都可以，基本没有区别
                                            return 0;
                                        }))))

                //第二个子命令
                .then(Commands.literal("tocard")
                        //*可以直接使用 则后续两个参数为默认
                        .executes(arg ->{
                            Entity entity = arg.getSource().getEntity();
                            //这种情况，还是在这写代码的话就会冗余两段，调用方法可以避免
                            toCard(entity,1,null);
                            return 0;
                        })
                        //*可以添加一个（示例为int类型）参数后再使用 .integer(1,64)表示接受的上限是64下限是1，避免低于0报错
                        .then(Commands.argument("count",IntegerArgumentType.integer(1,64))
                                .executes(arg ->{
                                    Entity entity = arg.getSource().getEntity();
                                    //获取int类型的参数
                                    int count = IntegerArgumentType.getInteger(arg.copyFor(arg.getSource()),"count");
                                    toCard(entity, count, null);
                                    return 0;
                                })
                        //*可以添加两个参数（示例为String）后再使用 （这个参数之后用于改变物品显示的名称）
                        .then(Commands.argument("show",StringArgumentType.string())
                            .executes(arg -> {
                                Entity entity = arg.getSource().getEntity();
                                int count = IntegerArgumentType.getInteger(arg.copyFor(arg.getSource()),"count");
                                String display = StringArgumentType.getString(arg.copyFor(arg.getSource()),"show");
                                toCard(entity,count,display);
                                return 0;

                            }))))

        );
    }

    public static void toCard(Entity entity, int count, String display){
        if (entity instanceof Player player) {
            Entity min = Ways.getPointedEntity(entity, 64.0);
            if(min instanceof MinionEntity minion){
                if(minion instanceof Turbomin turbomin){
                    //new ItemStack(物品字段名.get(),数量)，之前没写count那个int参数是就默认是1个
                    ItemStack stack = new ItemStack(ItemReg.turboCard.get(),count);
                    //判断有没有填写display这个参数，有的话更变物品名称为该参数
                    if(display != null) {
                        stack.setHoverName(Component.nullToEmpty(display));
                    }
                    //移除实体 Entity.RemovalReason.随便选一个就可以了
                    turbomin.remove(Entity.RemovalReason.DISCARDED);
                    //判断玩家左手有没有物品，没有就添加物品至副手否则添加至背包
                    if(player.getItemInHand(InteractionHand.OFF_HAND).isEmpty()) {
                        player.setItemInHand(InteractionHand.OFF_HAND,stack);
                    }else {
                        player.addItem(stack);
                    }
                }
            }
        }
    }
}
