package Model.ConcreteEquipmentObject;

import Model.AbstractEquipment;

import static Enum.EquipmentType.SWORD;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class Sword2 extends AbstractEquipment {

    public Sword2(){
        this.setType(SWORD.getType());
        this.setLevel(2);
        this.setAttackNum(20);
        this.setDefensiveNum(0);
        this.setName("二级剑");
    }

}
