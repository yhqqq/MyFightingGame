package Facade.Impl;

import Facade.HeroFacade;
import Model.AbstractEquipment;
import Model.AbstractMonster;

import static Enum.HeroType.KNIGHT;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public class HeroFacadeImpl implements HeroFacade {
    public void newHero(int heroType) {
//        if(heroType == KNIGHT.getType())
    }

    public void beginFight(AbstractMonster monster) {

    }

    public Boolean doAttack(int skillType) {
        return null;
    }

    public void escape() {

    }

    public void getEquipment(AbstractEquipment equipment) {

    }
}
