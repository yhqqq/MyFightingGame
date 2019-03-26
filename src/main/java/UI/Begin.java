package UI;

import gif.Gif;

import javax.swing.*;
import java.io.File;

/**
 * Created by alfred on 2019/3/24.
 */
public class Begin extends JFrame {
    /**
     * 初始化方法
     */
    public void init() {
        //设置标题
        this.setTitle("");
        //设置窗体大小
        this.setSize(1200, 800);
        //设置布局
        this.setLayout(null);
        //设置窗体关闭程序自动关闭
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置窗体居中显示
        this.setLocationRelativeTo(null);
        //添加主面板
        MainJpanel mainJpanel = new MainJpanel();
        mainJpanel.init(this);
        //设置面板大小
        mainJpanel.setBounds(0, 0, 800, 600);
        //设置主面板可见
        this.add(mainJpanel);
        //设置窗体可见
        this.setVisible(true);

        Gif gif = new Gif(new File(Begin.class.getResource("/static/image/monster.gif").getPath()), 10); //参数1文件路径，参数2gif图速度
        gif.setBounds(500, 500, 83, 78);
        mainJpanel.add(gif);
    }
}

