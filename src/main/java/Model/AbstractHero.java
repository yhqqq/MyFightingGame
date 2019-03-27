package Model;

import Logger.Logger;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public abstract class AbstractHero {

    private int level;

    private int heroType;

    private int HP;

    private int MaxHP;

    private double attackNum;

    private double defensiveNum;

    private int exp;

    private AbstractEquipment sword;

    private AbstractEquipment shield;

    private Logger logger = Logger.getInstance();

    public void log(String log){
        logger.log(log);
    }

    public void hurt(){}


    public void normalAttack(){

    }

    public void buffAttack(){

    }

    public void hugeAttack(){

    }

    public void wearEquipment(AbstractEquipment equipment){

    }

    public void gainExp(int Exp){

    }

    private void die(){

    }

    private void levelUp(){

    }
    /**
     *
     * **********Getter and Setter*************
     *
     */

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHeroType() {
        return heroType;
    }

    public void setHeroType(int heroType) {
        this.heroType = heroType;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public AbstractEquipment getSword() {
        return sword;
    }

    public void setSword(AbstractEquipment sword) {
        this.sword = sword;
    }

    public AbstractEquipment getShield() {
        return shield;
    }

    public void setShield(AbstractEquipment shield) {
        this.shield = shield;
    }
}
