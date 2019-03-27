package Model.ConcreteEquipmentObject;

import Model.AbstractEquipment;

import static Enum.EquipmentType.SHIELD;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class Shield2 extends AbstractEquipment {

    public Shield2(){
        this.setType(SHIELD.getType());
        this.setLevel(2);
        this.setAttackNum(0);
        this.setDefensiveNum(20);
        this.setName("二级盾");
    }

}
