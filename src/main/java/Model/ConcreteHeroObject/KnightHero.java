package Model.ConcreteHeroObject;

import Model.AbstractHero;

import static Enum.HeroType.KNIGHT;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class KnightHero extends AbstractHero {

    public KnightHero(){
        this.setLevel(1);
        this.setMaxHP(200);
        this.setHP(getMaxHP());
        this.setAttackNum(20);
        this.setDefensiveNum(8);
        this.setExp(0);
        this.setHeroType(KNIGHT.getType());
        this.setShield(null);
        this.setSword(null);
    }
}
