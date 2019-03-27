package Model.ConcreteObject;

import Constant.MonsterConstant;
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
        GameContext.getHero().gainExp(MonsterConstant.EXP_BIG_MONSTER);
        GameContext.setTheMonster(null);
    }
}
