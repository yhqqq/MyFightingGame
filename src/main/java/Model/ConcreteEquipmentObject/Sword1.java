package Model.ConcreteEquipmentObject;

import Model.AbstractEquipment;

import static Enum.EquipmentType.SWORD;

/**
 * Created by yuhqqq on 2019/3/27.
 */
public class Sword1 extends AbstractEquipment {

    public Sword1(){
        this.setType(SWORD.getType());
        this.setLevel(1);
        this.setAttackNum(10);
        this.setDefensiveNum(0);
        this.setName("一级剑");
    }

}
