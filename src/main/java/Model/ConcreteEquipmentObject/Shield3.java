package Model.ConcreteEquipmentObject;

import Model.AbstractEquipment;

import static Enum.EquipmentType.SHIELD;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class Shield3 extends AbstractEquipment{

    public Shield3(){

        this.setType(SHIELD.getType());
        this.setLevel(3);
        this.setAttackNum(0);
        this.setDefensiveNum(50);
        this.setName("三级盾");
    }

}
