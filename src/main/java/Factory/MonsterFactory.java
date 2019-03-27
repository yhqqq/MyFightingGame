package Factory;

import Model.ConcreteObject.BigMonster;
import Model.ConcreteObject.HugeMonster;
import Model.ConcreteObject.SmallMonster;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public class MonsterFactory {

    public SmallMonster newSmallMonster(){
        return newSmallMonster();
    }

    public BigMonster newBigMonster(){
        return newBigMonster();
    }

    public HugeMonster newHugeMonster(){
        return newHugeMonster();
    }
}
