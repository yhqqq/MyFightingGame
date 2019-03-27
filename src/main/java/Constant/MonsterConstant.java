package Constant;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public class MonsterConstant {

    //游戏初始化时各类型怪物的数量
    public static final int NUM_SMALL_MONSTER = 10;
    public static final int NUM_BIG_MONSTER = 3;
    public static final int NUM_HUGE_MONSTER = 1;

    //怪物刷新间隔 min
    public static final int REFRESH_MONSTER_CLOCK = 1;

    //怪物刷新频率 ：地图会随机刷新各个级别的怪物
    public static final int NUM_SMALL_MONSTER_REFRESH = 4;
    public static final int NUM_BIG_MONSTER_REFRESH = 2;
    public static final int NUM_HUGE_MONSTER_REFRESH = 0;

    //小怪物掉落一级二级三级装备的概率
    public static final double PROBABILITY_SMALL_MONSTER_Lv1_EQUIPMENT = 0.6;
    public static final double PROBABILITY_SMALL_MONSTER_Lv2_EQUIPMENT = 0.35;
    public static final double PROBABILITY_SMALL_MONSTER_Lv3_EQUIPMENT = 0.05;

    //大怪物掉落一级二级三级装备的概率
    public static final double PROBABILITY_BIG_MONSTER_Lv1_EQUIPMENT = 0.15;
    public static final double PROBABILITY_BIG_MONSTER_Lv2_EQUIPMENT = 0.6;
    public static final double PROBABILITY_BIG_MONSTER_Lv3_EQUIPMENT = 0.25;

    //大小怪物掉落经验值
    public static final int EXP_SMALL_MONSTER = 1;
    public static final int EXP_BIG_MONSTER = 5;
    public static final int EXP_HUGE_MONSTER = 10;

    //攻击频率
    public static final int ATTACK_CD = 1;
}
