package Facade;

import Model.AbstractMonster;

import java.util.List;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public interface MonsterFactoryFacade {

    /**
     * 初始化游戏时返回一堆怪物
     * list中依次为 小怪物，大怪物，BOSS。数量见MONSTERCONSTANT
     * @return
     */
    List<AbstractMonster> initMonsters();

    /**
     *  定时刷新怪物
     *  UI应当起个线程定时调用这个方法
     *  刷新的量和时间周期在MONSTERCONSTANT中
     */
    List<AbstractMonster> refreshMonsters();
}
