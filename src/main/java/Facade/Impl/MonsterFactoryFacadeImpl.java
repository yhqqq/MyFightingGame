package Facade.Impl;

import Constant.MonsterConstant;
import Facade.MonsterFactoryFacade;
import Factory.MonsterFactory;
import Model.AbstractMonster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class MonsterFactoryFacadeImpl implements MonsterFactoryFacade {

    MonsterFactory monsterFactory = new MonsterFactory();

    public List<AbstractMonster> initMonsters() {
        List<AbstractMonster> abstractMonsters = new ArrayList<AbstractMonster>();
        for(int i = 0; i < MonsterConstant.NUM_SMALL_MONSTER; i++){
            abstractMonsters.add(monsterFactory.newSmallMonster());
        }
        for(int i = 0; i < MonsterConstant.NUM_BIG_MONSTER; i++){
            abstractMonsters.add(monsterFactory.newBigMonster());
        }
        for(int i = 0; i < MonsterConstant.NUM_HUGE_MONSTER; i++){
            abstractMonsters.add(monsterFactory.newHugeMonster());
        }
        return abstractMonsters;
    }

    public List<AbstractMonster> refreshMonsters() {
        List<AbstractMonster> abstractMonsters = new ArrayList<AbstractMonster>();
        for(int i = 0; i < MonsterConstant.NUM_SMALL_MONSTER_REFRESH; i++){
            abstractMonsters.add(monsterFactory.newSmallMonster());
        }
        for(int i = 0; i < MonsterConstant.NUM_BIG_MONSTER_REFRESH; i++){
            abstractMonsters.add(monsterFactory.newBigMonster());
        }
        for(int i = 0; i < MonsterConstant.NUM_HUGE_MONSTER_REFRESH; i++){
            abstractMonsters.add(monsterFactory.newHugeMonster());
        }
        return abstractMonsters;
    }
}
