import UI.Begin;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public class Application {

    /**
     * 游戏入口：
     * 应当作的是：
     * 初始化游戏界面
     * 让用户选择英雄类型然后初始化英雄，将英雄存入@GameContext方便全局调用
     * 初始化怪物列表
     *
     * 英雄属性显示 @HeroObserver
     * 控制台输出log信息 @Logger
     */

    public static void main(String[] args) {
        Begin begin = new Begin();
        begin.init();
    }

}
