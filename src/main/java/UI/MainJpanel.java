package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import gif.Gif;
/**
 * Created by alfred on 2019/3/24.
 */
public class MainJpanel extends JPanel {
    //声明全局的begin对象
    Begin begin;
    int index = 0;
    //声明玩家对象
    public Player player = new Player();
    //声明一个图片对象
    ImageIcon img = player.player1;

    ImageIcon[] imgs = { new ImageIcon("static/image/run_right/run_right_1.png"),
            new ImageIcon("static/image/run_right/run_right_2.png"),
            new ImageIcon("static/image/run_right/run_right_3.png"),
            new ImageIcon("static/image/run_right/run_right_4.png"),
            new ImageIcon("static/image/run_right/run_right_5.png")};
    ImageIcon[] attack = { new ImageIcon("static/image/attack/attack_1.png"),
            new ImageIcon("static/image/attack/attack_2.png")};
    ImageIcon[] r = { new ImageIcon("static/image/r/r_1.png"),
            new ImageIcon("static/image/r/r_2.png")};
    int state = 0;
    //面板加载方法
    public void init(Begin begin) {
        this.begin = begin;
        //设置玩家出现的初始位置
        player.x = 200;
        player.y = 100;
        //给面板添加监听器
        KeyClick kc = new KeyClick();
        begin.addKeyListener(kc);
        //启用刷新面板线程
        Rethread rt = new Rethread(this);
        rt.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //在面板上面出玩家
        if(state == 0){
            index = (index +1)%5;
            switch (index){
                case 0:
                    img = imgs[0];
                    break;
                case 1:
                    img = imgs[1];
                    break;
                case 2:
                    img = imgs[2];
                    break;
                case 3:
                    img = imgs[3];
                    break;
                case 4:
                    img = imgs[4];
                    break;
                default:break;
            }
        }else if(state == 1){
            index = (index +1)%2;
            switch (index){
                case 0:
                    img = attack[0];
                    break;
                case 1:
                    img = attack[1];
                    break;
                default:break;
            }
        }else if(state == 2){
            index = (index +1)%2;
            switch (index){
                case 0:
                    img = r[0];
                    break;
                case 1:
                    img = r[1];
                    break;
                default:break;
            }
        }
        g.drawImage(img.getImage(), player.x, player.y,  this);
        g.drawString(".", player.x, player.y);



    }


    class KeyClick implements KeyListener {

        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
//                wasd
                case 87:
                    state = 0;
                    if(player.y>0){
                        player.y = player.y - player.speed;

                    }
                    break;
                case 65:
                    state = 0;
                    if(player.x>0){
                        player.x = player.x - player.speed;

                    }
                    break;
                case 83:
                    state = 0;
                    if(player.y<510){
                        player.y = player.y + player.speed;

                    }
                    break;
                case 68:
                    state = 0;
                    if(player.x<640){
                        player.x = player.x + player.speed;

                    }
                    break;
//                    空格
                case 32:
                    if(state!=1)state = 1;
                    break;
//                    r
                case 82:
                    if(state!=2)state = 2;
                    break;
                default:break;
            }
        }

        public void keyReleased(KeyEvent e) {
            state = 0;
        }
    }


}

