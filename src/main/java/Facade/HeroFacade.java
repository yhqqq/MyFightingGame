package Facade;

import Model.AbstractEquipment;
import Model.AbstractMonster;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public interface HeroFacade {

    /**
     * 游戏初始化时，根据用户选择，创建相应类型的英雄
     * @param heroType
     */
    void newHero(int heroType);

    /**
     * 与某一个怪物开始战斗，应当将这个怪物纳入观察者模式，
     * UI的表现是怪物出现血条，开始攻击
     * 怎么操作待定
     * @param monster
     */
    void beginFight(AbstractMonster monster);

    /**
     * 英雄释放技能
     * @param skillType
     * @return true表示释放成功，UI可以做出相应动作。
     *          false表示释放失败，可能是因为：不在战斗状态；CD等原因
     */
    Boolean doAttack(int skillType);

    /**
     * 逃脱，脱离战斗状态
     */
    void escape();

    /**
     * 英雄选择穿上一件装备
     * @param equipment
     */
    void getEquipment(AbstractEquipment equipment);

}
