package Model.ConcreteMonsterObject;

import Constant.MonsterConstant;
import Factory.EquipmentFactory;
import Model.AbstractMonster;
import Service.GameContext;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public class SmallMonster extends AbstractMonster {

    public SmallMonster(){
        this.setLevel(1);
        this.setName("SmallMonster");
        this.setMaxHP(100);
        this.setHP(getMaxHP());
        this.setAttackNum(10);
        this.setDefensiveNum(10);
        this.setProbability_Lv1_Equipment(MonsterConstant.PROBABILITY_SMALL_MONSTER_Lv1_EQUIPMENT);
        this.setProbability_Lv2_Equipment(MonsterConstant.PROBABILITY_SMALL_MONSTER_Lv2_EQUIPMENT);
        this.setProbability_Lv3_Equipment(MonsterConstant.PROBABILITY_SMALL_MONSTER_Lv3_EQUIPMENT);
    }

    public void die() {
        log(getName() + " 被你击杀了");
        GameContext.getTheHero().gainExp(MonsterConstant.EXP_SMALL_MONSTER);
        GameContext.getTheMonster().deleteObserver(GameContext.getMonsterObserver());
        GameContext.setTheMonster(null);
        GameContext.setMonsterObserver(null);
        GameContext.setEquipmentOntheGround(new EquipmentFactory().monsterDie(this));
    }
}
