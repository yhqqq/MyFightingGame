package Service;

import Model.AbstractEquipment;
import Model.AbstractHero;
import Model.AbstractMonster;
import Observer.HeroObserver;
import Observer.MonsterObserver;

/**
 * Created by yuhqqq on 2019/3/26.
 * 便于全局共享一些对象
 */
public class GameContext {

    //当前英雄
    private static AbstractHero theHero;

    //当前在战斗的怪物
    private static AbstractMonster theMonster;

    //当前在战斗的怪物的观察者
    private static MonsterObserver monsterObserver;

    //当前英雄的观察者
    private static HeroObserver heroObserver;

    //怪物掉落的装备，如果不捡起来，会被下一个掉落装备覆盖掉
    //每次攻击好，判断theMonster是否为null，如果为null，表示死了，去掉他的图片，换上装备的图片。。
    private static AbstractEquipment equipmentOntheGround;

    /**
     *
     * *********GETTER AND SETTER ***********
     *
     */
    public static AbstractMonster getTheMonster() {
        return theMonster;
    }

    public static void setTheMonster(AbstractMonster monster) {
        GameContext.theMonster = monster;
    }

    public static AbstractHero getTheHero() {
        return theHero;
    }

    public static void setTheHero(AbstractHero theHero) {
        GameContext.theHero = theHero;
    }

    public static MonsterObserver getMonsterObserver() {
        return monsterObserver;
    }

    public static void setMonsterObserver(MonsterObserver monsterObserver) {
        GameContext.monsterObserver = monsterObserver;
    }

    public static AbstractEquipment getEquipmentOntheGround() {
        return equipmentOntheGround;
    }

    public static void setEquipmentOntheGround(AbstractEquipment equipmentOntheGround) {
        GameContext.equipmentOntheGround = equipmentOntheGround;
    }

    public static HeroObserver getHeroObserver() {
        return heroObserver;
    }

    public static void setHeroObserver(HeroObserver heroObserver) {
        GameContext.heroObserver = heroObserver;
    }
}
