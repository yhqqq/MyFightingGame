package Observer;

import Service.GameContext;
import UI.MainJpanel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class MonsterObserver implements Observer{


    public void update(Observable o, Object arg) {
        //todo
        //战斗的怪物的血量，死亡等
        MainJpanel.setMonster(GameContext.getTheMonster().getAttackNum(),
                GameContext.getTheMonster().getDefensiveNum(),
                GameContext.getTheMonster().getLevel(),
                GameContext.getTheMonster().getHP(),
                GameContext.getTheMonster().getMaxHP());
    }
}
