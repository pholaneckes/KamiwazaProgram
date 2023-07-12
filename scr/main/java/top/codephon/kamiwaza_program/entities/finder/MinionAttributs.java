package top.codephon.kamiwaza_program.entities.finder;

import net.minecraft.util.StringRepresentable;

public class MinionAttributs {
    public enum MinAttrys implements StringRepresentable {
        BURUBURU("buruburu",(byte)1),
        HOKKORI("hokkiri",(byte)2),
        KICCHIRI("kicchiri",(byte)3),
        PUNPUN("punpun",(byte)4),
        SHIRISHIRI("shirishiri",(byte)5),
        WAKUWAKU("wakuwaku",(byte)6),
        WONDER("wonder",(byte)-1);

        private final String name;
        private final byte id;
        MinAttrys(String name, byte id){
            this.name = name;
            this.id = id;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public byte getId() {
            return id;
        }
    }
}
