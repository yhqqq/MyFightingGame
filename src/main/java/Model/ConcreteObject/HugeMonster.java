package Model.ConcreteObject;

import Constant.MonsterConstant;
import Model.AbstractMonster;
import Service.GameContext;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class HugeMonster extends AbstractMonster {

    public HugeMonster(){
        this.setLevel(3);
        this.setName("BOSS");
        this.setMaxHP(500);
        this.setHP(getMaxHP());
        this.setAttackNum(50);
        this.setDefensiveNum(50);
        this.setProbability_Lv1_Equipment(0);
        this.setProbability_Lv2_Equipment(0);
        this.setProbability_Lv3_Equipment(0);
    }

    public void die() {
        GameContext.getHero().gainExp(MonsterConstant.EXP_HUGE_MONSTER);
        GameContext.setTheMonster(null);
    }
}
