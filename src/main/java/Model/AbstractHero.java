package Model;

import Constant.HeroConstant;
import Logger.Logger;
import Service.GameContext;

import java.util.Observable;
import java.util.concurrent.Semaphore;

import static Enum.EquipmentType.SHIELD;
import static Enum.EquipmentType.SWORD;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public abstract class AbstractHero extends Observable{

    private int level;

    private int heroType;

    private int HP;

    private int MaxHP;

    private int attackNum;

    private int defensiveNum;

    private int exp;

    private AbstractEquipment sword;

    private AbstractEquipment shield;

    private Logger logger = Logger.getInstance();

    private Semaphore normalAttackCDclock = new Semaphore(1);

    private Semaphore buffAttackCDclock = new Semaphore(1);

    private Semaphore hugeAttackCDclock = new Semaphore(1);

    private  Thread normalThread = new Thread(new Runnable() {
        public void run() {
            try {
                normalAttackCDclock.acquire();
                Thread.sleep((int)(HeroConstant.NORMALLATTACK_CD * 1000));
                normalAttackCDclock.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private  Thread buffThread = new Thread(new Runnable() {
        public void run() {
            try {
                buffAttackCDclock.acquire();
                Thread.sleep(HeroConstant.BUFFATTACK_CD * 1000);
                buffAttackCDclock.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private  Thread hugeThread = new Thread(new Runnable() {
        public void run() {
            try {
                hugeAttackCDclock.acquire();
                Thread.sleep(HeroConstant.HUGEATTACK_CD * 1000);
                hugeAttackCDclock.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });


    public void log(String log){
        logger.log(log);
    }

    public void hurt(int attackNum){
        log("你受到了 " + attackNum + " 点伤害！");
        int damage = (attackNum - getDefensiveNum()) > 0 ? (attackNum - getDefensiveNum()) : 1;

        setHP(getHP() - damage);
        if(getHP() <= 0){
            die();
        }
        notifyObservers();
    }


    public boolean normalAttack(){
        if(normalAttackCDclock.tryAcquire()){
            log("你发动了普通攻击！");
            GameContext.getTheMonster().hurt(getAttackNum());
            normalThread.start();
            return true;
        }else {
            log("普攻冷却中，释放失败！");
            return false;
        }
    }

    public boolean buffAttack(){
        if(buffAttackCDclock.tryAcquire()){
            log("你发动了2技能！");
            GameContext.getTheMonster().hurt(getAttackNum() * 2);
            buffThread.start();
            return true;
        }else {
            log("技能冷却中，释放失败！");
            return false;
        }
    }

    public boolean hugeAttack(){
        if(hugeAttackCDclock.tryAcquire()){
            log("你释放了大招！");
            GameContext.getTheMonster().hurt(getAttackNum() * 4);
            hugeThread.start();
            return true;
        }else {
            log("技能冷却中，释放失败！");
            return false;
        }
    }

    public void wearEquipment(AbstractEquipment equipment){

        if(equipment.getType() == SWORD.getType()){
            throwEquipment(SWORD.getType());
            setSword(equipment);
            setAttackNum(getAttackNum() + equipment.getAttackNum());
        }else {
            throwEquipment(SHIELD.getType());
            setShield(equipment);
            setDefensiveNum(getDefensiveNum() + equipment.getDefensiveNum());
        }
        log("你装备了 " + equipment.getName() + " !");
        notifyObservers();
    }

    public void gainExp(int Exp){
        log("你获得了 " + Exp + " 点经验值！");

        int expnow = getExp() + Exp;
        if(expnow >= 10 * Math.pow(getLevel(), 2)){
            expnow = getExp() + Exp - 10 * (int)Math.pow(getLevel(), 2);
            levelUp();
        }
        setExp(expnow);
        notifyObservers();
    }

    /**
     *
     * **********Observable*************
     *
     */



    /**
     *
     * **********private*************
     *
     */

    private void throwEquipment(int equipmentType){
        if(equipmentType == SWORD.getType()){
            log("");
            setAttackNum(getAttackNum() - getSword().getAttackNum());
            setSword(null);
        }else {
            log("");
            setDefensiveNum(getDefensiveNum() - getShield().getAttackNum());
            setShield(null);
        }
    }

    private void die(){
        log("你阵亡了！游戏结束！");
    }

    private void levelUp(){
        setMaxHP( getMaxHP() / getLevel() * (getLevel() + 1) );
        setAttackNum(getAttackNum() + 10 * getLevel());
        setDefensiveNum(getDefensiveNum() + 5 * getLevel());
        setHP(getMaxHP());
        setLevel(getLevel() + 1);
        log("你升级了！血量回满！攻防提升！");
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
