package Model.ConcreteEquipmentObject;

import Model.AbstractEquipment;

import static Enum.EquipmentType.SHIELD;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class Shield1 extends AbstractEquipment {

    public Shield1(){
        this.setType(SHIELD.getType());
        this.setLevel(1);
        this.setAttackNum(0);
        this.setDefensiveNum(10);
        this.setName("一级盾");
    }
}
