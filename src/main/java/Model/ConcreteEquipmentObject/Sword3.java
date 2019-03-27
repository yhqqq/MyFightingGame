package Model.ConcreteEquipmentObject;

import Model.AbstractEquipment;

import static Enum.EquipmentType.SWORD;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class Sword3 extends AbstractEquipment {

    public Sword3(){
        this.setType(SWORD.getType());
        this.setLevel(3);
        this.setAttackNum(50);
        this.setDefensiveNum(0);
        this.setName("三级剑");
    }

}
