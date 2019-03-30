package Observer;

import Service.GameContext;
import UI.MainJpanel;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class HeroObserver implements Observer {

    public void update(Observable o, Object arg) {
        //从 GameContext 得到Hero对象继而得到数据

        MainJpanel.setHero(GameContext.getTheHero().getDefensiveNum(),
        GameContext.getTheHero().getAttackNum(),
        GameContext.getTheHero().getLevel(),
        GameContext.getTheHero().getHP(),
        GameContext.getTheHero().getExp(),
        GameContext.getTheHero().getMaxHP());

    }
}
