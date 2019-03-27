package Facade.Impl;

import Constant.MonsterConstant;
import Facade.HeroFacade;
import Logger.Logger;
import Model.AbstractEquipment;
import Model.AbstractHero;
import Model.AbstractMonster;
import Model.ConcreteHeroObject.KnightHero;
import Model.ConcreteHeroObject.WarriorHero;
import Observer.HeroObserver;
import Observer.MonsterObserver;
import Service.GameContext;

import static Enum.HeroType.KNIGHT;
import static Enum.SkillType.BUFF;
import static Enum.SkillType.NORMAL_ATTACK;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public class HeroFacadeImpl implements HeroFacade {

    private AbstractHero theHero;

    private Logger logger = Logger.getInstance();

    private Thread monsterAttack = new Thread(new Runnable() {
        public void run() {
            if(GameContext.getTheMonster() != null){
                synchronized (GameContext.class){
                    if(GameContext.getTheMonster() != null){
                        GameContext.getTheMonster().attack();
                    }
                }
            }
            try {
                Thread.sleep(MonsterConstant.ATTACK_CD * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    private void log(String log){
        logger.log(log);
    }

    public AbstractHero newHero(int heroType) {
        AbstractHero abstractHero = null;
        if(heroType == KNIGHT.getType()){
            abstractHero = new KnightHero();
        }else {
            abstractHero = new WarriorHero();
        }
        this.theHero = abstractHero;
        log("你创建了新英雄！");
        HeroObserver heroObserver = new HeroObserver();
        abstractHero.addObserver(heroObserver);
        GameContext.setTheHero(abstractHero);
        GameContext.setHeroObserver(heroObserver);
        return abstractHero;
    }

    public MonsterObserver beginFight(AbstractMonster monster) {
        MonsterObserver monsterObserver = new MonsterObserver();
        monster.addObserver(monsterObserver);
        GameContext.setMonsterObserver(monsterObserver);
        GameContext.setTheMonster(monster);
        log("你与 " + monster.getName()  + " 发生了战斗！");
        monsterAttack.start();
        return monsterObserver;
    }

    public Boolean doAttack(int skillType) {
        if(skillType == NORMAL_ATTACK.getType()){
            return theHero.normalAttack();
        }else if(skillType == BUFF.getType()){
            return theHero.buffAttack();
        }else {
            return theHero.hugeAttack();
        }
    }

    public void escape() {
        GameContext.getTheMonster().escape();
        GameContext.getTheMonster().deleteObserver(GameContext.getMonsterObserver());
        GameContext.setTheMonster(null);
        GameContext.setMonsterObserver(null);
    }

    public void wearEquipment(AbstractEquipment equipment) {
        theHero.wearEquipment(equipment);
    }
}
