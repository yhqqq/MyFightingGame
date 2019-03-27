package Enum;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public enum HeroType {

    KNIGHT("knight",1), WARRIOR("warrior",2);

    private String typeName;

    private int type;

    private HeroType(String typeName, int type){
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
