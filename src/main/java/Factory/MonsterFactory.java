package Factory;

import Model.ConcreteMonsterObject.BigMonster;
import Model.ConcreteMonsterObject.HugeMonster;
import Model.ConcreteMonsterObject.SmallMonster;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public class MonsterFactory {

    public SmallMonster newSmallMonster(){
        return new SmallMonster();
    }

    public BigMonster newBigMonster(){
        return new BigMonster();
    }

    public HugeMonster newHugeMonster(){
        return new HugeMonster();
    }
}
