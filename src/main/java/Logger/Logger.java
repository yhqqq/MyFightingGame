package Logger;

import UI.MainJpanel;

/**
 * Created by yuhqqq on 2019/3/26.
 */
public class Logger {

    private volatile static Logger singleton;

    private Logger(){
    }

    public static Logger getInstance(){
        if(singleton == null){
            synchronized (Logger.class){
                if(singleton == null){
                    singleton = new Logger();
                }
            }
        }
        return singleton;
    }

    public void log(String s){
        //todo log
        //打印到信息输出台上
//        MainJpanel mainJpanel = new MainJpanel();
        MainJpanel.log(s);
        System.out.println(s);
    }
}
