package Factory;

import Model.ConcreteMonsterObject.BigMonster;
import Model.ConcreteMonsterObject.HugeMonster;
import Model.ConcreteMonsterObject.SmallMonster;

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
