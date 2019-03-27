package Enum;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public enum EquipmentType {

    SWORD("sword",1), SHIELD("shield",2);

    private String typeName;

    private int type;

    private EquipmentType(String typeName, int type){
        this.typeName = typeName;
        this.type = type;
    }


    public String getTypeName() {
        return typeName;
    }

    public int getType() {
        return type;
    }

}
