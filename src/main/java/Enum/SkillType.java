package Enum;

/**
 * Created by yuhqqq on 2019/3/26.
 * 技能类型：
 * 分别为普通攻击，buff技能，大招
 */
public enum SkillType {

    NORMAL_ATTACK("normalattack",1), BUFF("warrior",2),HUGE_ATTACK("hugeattack",3);

    private String typeName;

    private int type;

    private SkillType(String typeName, int type){
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
