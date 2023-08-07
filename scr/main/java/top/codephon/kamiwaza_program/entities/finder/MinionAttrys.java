package top.codephon.kamiwaza_program.entities.finder;

import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

//枚举实体属性  （implements StringRepresentable是可以将枚举Decode，也可以①通过SerializedName来获取该枚举项的其它几个值等，为可选实现，不多展开）
//                                       注解①：   具体是：StringRepresentable.fromEnum(枚举类名::values).byName("SerializedName值")....
public enum MinionAttrys implements StringRepresentable {
    BURUBURU("buruburu",(byte)1),
    HOKKORI("hokkori",(byte)2),
    KICCHIRI("kicchiri",(byte)3),
    PUNPUN("punpun",(byte)4),
    SHIRISHIRI("shirishiri",(byte)5),
    WAKUWAKU("wakuwaku",(byte)6),
    WONDER("wonder",(byte)-1),
    NONE_ATTRIBUTE("none",(byte)0);

    private final String name;
    private final byte id;
    MinionAttrys(String name, byte id){
        this.name = name;
        this.id = id;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public String getTranslation(){
        return Component.translatable("minion.attri."+getName()).getString();
    }

    public byte getId() {
        return id;
    }
}

