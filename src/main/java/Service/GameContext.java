package Service;

import Model.AbstractHero;
import Model.AbstractMonster;

/**
 * Created by yuhqqq on 2019/3/26.
 * 便于全局共享一些对象
 */
public class GameContext {

    //当前英雄
    private static AbstractHero theHero;

    //当前在战斗的怪物
    private static AbstractMonster theMonster;


    /**
     *
     * *********GETTER AND SETTER ***********
     *
     */
    public static AbstractHero getHero() {
        return theHero;
    }

    public static void setHero(AbstractHero hero) {
        theHero = hero;
    }

    public static AbstractMonster getTheMonster() {
        return theMonster;
    }

    public static void setTheMonster(AbstractMonster monster) {
        theMonster = monster;
    }
}
