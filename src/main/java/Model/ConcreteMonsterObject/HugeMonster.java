package Model.ConcreteMonsterObject;

import Constant.MonsterConstant;
import Factory.EquipmentFactory;
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
        log(getName() + " 被你击杀了");
        GameContext.getTheHero().gainExp(MonsterConstant.EXP_HUGE_MONSTER);
        GameContext.getTheMonster().deleteObserver(GameContext.getMonsterObserver());
        GameContext.setTheMonster(null);
        GameContext.setMonsterObserver(null);
        GameContext.setEquipmentOntheGround(new EquipmentFactory().monsterDie(this));
    }
}
