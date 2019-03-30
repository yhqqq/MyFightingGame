package UI;

import gif.Gif;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by alfred on 2019/3/24.
 */
public class Begin extends JFrame {
    /**
     * 初始化方法
     */
    public void init() {
        this.setTitle("");
        this.setSize(1200, 800);
        this.setLayout(null);
        //设置窗体关闭程序自动关闭
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置窗体居中显示
        this.setLocationRelativeTo(null);

        //添加主面板
        MainJpanel mainJpanel = new MainJpanel();
        mainJpanel.init(this);
        mainJpanel.setBounds(0, 0, 1200, 800);

        //添加日志面板
//        LogJpanel logJpanel = new LogJpanel();
//        logJpanel.init(this);
//        logJpanel.setBounds(800,0,400,800);
//        logJpanel.setBackground(Color.BLACK);

//        Gif gif = new Gif(new File("src/main/resources/static/gif/monster.gif"),10); //参数1文件路径，参数2gif图速度
//        gif.setBounds(500, 500, 83, 78);
//        mainJpanel.add(gif);

//        JLabel life = new JLabel("生命值：");
//        life.setBounds(1000,0,100,50);
//        mainJpanel.add(life);
//
//        JLabel attack = new JLabel("攻击力：");
//        attack.setBounds(1000,60,100,50);
//        mainJpanel.add(attack);
//
//        JLabel depend = new JLabel("防御力：");
//        depend.setBounds(1000,120,100,50);
//        mainJpanel.add(depend);

        this.add(mainJpanel);
//        this.add(logJpanel);
        this.setVisible(true);
    }
}

