package Model.ConcreteHeroObject;

import Model.AbstractHero;

import static Enum.HeroType.WARRIOR;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class WarriorHero extends AbstractHero {

    public WarriorHero(){
        this.setLevel(1);
        this.setMaxHP(150);
        this.setHP(getMaxHP());
        this.setAttackNum(25);
        this.setDefensiveNum(6);
        this.setExp(0);
        this.setHeroType(WARRIOR.getType());
        this.setShield(null);
        this.setSword(null);
    }

}
