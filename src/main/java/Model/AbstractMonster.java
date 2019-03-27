package Model;

import Logger.Logger;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public abstract class AbstractMonster {

    private int level;//1,2,3

    private String name;

    private int HP;

    private int MaxHP;

    private double attackNum; //攻击力

    private double defensiveNum; //防御力

    private double Probability_Lv1_Equipment; //防御力

    private double Probability_Lv2_Equipment; //防御力

    private double Probability_Lv3_Equipment; //防御力

    private Logger logger = Logger.getInstance();

    //日志输出
    public void log(String log){
        logger.log(log);
    }

    //攻击
    public void attack(){

    }

    //死亡；掉落装备，经验等
    public abstract void die();

    //英雄逃跑，回复血量
    public void escape(){
        setHP(getMaxHP());
    }

    public void hurt(int damage){
        setHP(getHP() - damage);
        if(getHP() <= 0){
            die();
        }
    }


    /**
     *
     * **********Getter and Setter*************
     *
     */


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        if(HP < 0){
            HP = 0;
        }
        this.HP = HP;
    }

    public double getAttackNum() {
        return attackNum;
    }

    public void setAttackNum(double attackNum) {
        this.attackNum = attackNum;
    }

    public double getDefensiveNum() {
        return defensiveNum;
    }

    public void setDefensiveNum(double defensiveNum) {
        this.defensiveNum = defensiveNum;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }

    public double getProbability_Lv1_Equipment() {
        return Probability_Lv1_Equipment;
    }

    public void setProbability_Lv1_Equipment(double probability_Lv1_Equipment) {
        Probability_Lv1_Equipment = probability_Lv1_Equipment;
    }

    public double getProbability_Lv2_Equipment() {
        return Probability_Lv2_Equipment;
    }

    public void setProbability_Lv2_Equipment(double probability_Lv2_Equipment) {
        Probability_Lv2_Equipment = probability_Lv2_Equipment;
    }

    public double getProbability_Lv3_Equipment() {
        return Probability_Lv3_Equipment;
    }

    public void setProbability_Lv3_Equipment(double probability_Lv3_Equipment) {
        Probability_Lv3_Equipment = probability_Lv3_Equipment;
    }
}
