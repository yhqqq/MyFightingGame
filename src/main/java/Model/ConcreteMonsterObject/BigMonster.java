package Model.ConcreteMonsterObject;

import Constant.MonsterConstant;
import Factory.EquipmentFactory;
import Model.AbstractMonster;
import Service.GameContext;
/**
 * Created by yuhqqq on 2019/3/27.
 */
public class BigMonster extends AbstractMonster {

    public BigMonster(){
        this.setLevel(2);
        this.setName("BigMonster");
        this.setMaxHP(200);
        this.setHP(getMaxHP());
        this.setAttackNum(20);
        this.setDefensiveNum(20);
        this.setProbability_Lv1_Equipment(MonsterConstant.PROBABILITY_BIG_MONSTER_Lv1_EQUIPMENT);
        this.setProbability_Lv2_Equipment(MonsterConstant.PROBABILITY_BIG_MONSTER_Lv2_EQUIPMENT);
        this.setProbability_Lv3_Equipment(MonsterConstant.PROBABILITY_BIG_MONSTER_Lv3_EQUIPMENT);
    }

    public void die() {
        log(getName() + " 被你击杀了");
        GameContext.getTheHero().gainExp(MonsterConstant.EXP_BIG_MONSTER);
        GameContext.getTheMonster().deleteObserver(GameContext.getMonsterObserver());
        GameContext.setTheMonster(null);
        GameContext.setMonsterObserver(null);
        GameContext.setEquipmentOntheGround(new EquipmentFactory().monsterDie(this));
    }
}
