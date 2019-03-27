package Model;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public abstract class AbstractEquipment {

    private int type;

    private int level;

    private int attackNum;

    private int defensiveNum;

    private String name;


    /**
     *
     * **********Getter and Setter*************
     *
     */

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttackNum() {
        return attackNum;
    }

    public void setAttackNum(int attackNum) {
        this.attackNum = attackNum;
    }

    public int getDefensiveNum() {
        return defensiveNum;
    }

    public void setDefensiveNum(int defensiveNum) {
        this.defensiveNum = defensiveNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
