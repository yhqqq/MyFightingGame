package Factory;

import Model.AbstractEquipment;
import Model.AbstractMonster;
import Model.ConcreteEquipmentObject.*;

import java.util.Random;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public class EquipmentFactory {

    public AbstractEquipment getSword(int level){
        if(level == 1){
            return new Sword1();
        }else if(level == 2){
            return new Sword2();
        }else if(level == 3){
            return new Sword3();
        }else {
            return new Sword1();
        }
    }

    public AbstractEquipment getShield(int level){
        if(level == 1){
            return new Shield1();
        }else if(level == 2){
            return new Shield2();
        }else if(level == 3){
            return new Shield3();
        }else {
            return new Shield1();
        }
    }

    public AbstractEquipment monsterDie(AbstractMonster monster){
        Random random = new Random();
        double swordOrShield = random.nextDouble();
        double levelrandom = random.nextDouble();
        int level = -1;
        if(levelrandom < monster.getProbability_Lv1_Equipment()){
            level = 1;
        }else if(levelrandom < monster.getProbability_Lv1_Equipment() + monster.getProbability_Lv2_Equipment()){
            level = 2;
        }else {
            level = 3;
        }
        if(swordOrShield < 0.5){
            return getShield(level);
        }else {
            return getSword(level);
        }
    }
}
