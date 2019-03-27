package Enum;

/**
 * Created by yuhqqq on 2019/3/26.
 *
 * 英雄状态 ：闲逛（自动回血）　与　战斗中（可以释放技能）
 */
public enum HeroState {

    NORMAL("normal",1), FIGHTING("fighting",2);

    private String typeName;

    private int type;

    private HeroState(String typeName, int type){
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
