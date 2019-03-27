package Model;

import Logger.Logger;
import Service.GameContext;

import java.util.Observable;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public abstract class AbstractMonster extends Observable {

    private int level;//1,2,3

    private String name;

    private int HP;

    private int MaxHP;

    private int attackNum; //攻击力

    private int defensiveNum; //防御力

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
        log(getName() + " 发动了攻击！");
        GameContext.getTheHero().hurt(getAttackNum());
    }

    //死亡；掉落装备，经验等
    public abstract void die();

    //英雄逃跑，回复血量
    public void escape(){
        log("逃跑成功！");
        setHP(getMaxHP());
        GameContext.setTheMonster(null);
        GameContext.setMonsterObserver(null);
    }

    public void hurt(int attackNum){

        int damage = (attackNum - getDefensiveNum()) > 0 ? (attackNum - getDefensiveNum()) : 1;
        log("怪物受到了 " + damage + " 点伤害");
        setHP(getHP() - damage);
        if(getHP() <= 0){
            die();
        }
        notifyObservers();
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
