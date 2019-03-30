package UI;

import Facade.HeroFacade;
import Facade.Impl.HeroFacadeImpl;
import Facade.Impl.MonsterFactoryFacadeImpl;
import Facade.MonsterFactoryFacade;
import Model.AbstractMonster;
import Service.GameContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by alfred on 2019/3/24.
 */
public class MainJpanel extends JPanel {
    //声明全局的begin对象
    Begin begin;
    int index = 0;
    private ImageIcon background = new ImageIcon("src/main/resources/static/image/map.png");
    private ImageIcon photo = new ImageIcon("src/main/resources/static/image/saber.png");

    //声明玩家对象
    public Player player = new Player();
    //声明一个图片对象
    ImageIcon img = player.player1;
    ImageIcon monster = new ImageIcon("src/main/resources/static/image/monster.png");

    ImageIcon[] imgs = { new ImageIcon("src/main/resources/static/image/run_right/run_right_1.png"),
            new ImageIcon("src/main/resources/static/image/run_right/run_right_2.png"),
            new ImageIcon("src/main/resources/static/image/run_right/run_right_3.png"),
            new ImageIcon("src/main/resources/static/image/run_right/run_right_4.png"),
            new ImageIcon("src/main/resources/static/image/run_right/run_right_5.png")};
    ImageIcon[] attack = { new ImageIcon("src/main/resources/static/image/attack/attack_1.png"),
            new ImageIcon("src/main/resources/static/image/attack/attack_2.png")};
    ImageIcon[] r = { new ImageIcon("src/main/resources/static/image/r/r_1.png"),
            new ImageIcon("src/main/resources/static/image/r/r_2.png")};
    int state = 0;
    int monster_x = (int)(Math.random()*800)+100;
    int monster_y = (int)(Math.random()*400)+360;
    java.util.List<AbstractMonster> monsterFactoryList;
    //面板加载方法
    public void init(Begin begin) {
        this.begin = begin;
        //设置玩家出现的初始位置
        player.x = 200;
        player.y = 400;


        //给面板添加监听器
        KeyClick kc = new KeyClick();
        begin.addKeyListener(kc);

        HeroFacade heroFacade = new HeroFacadeImpl();
        MonsterFactoryFacade monsterFactoryFacade = new MonsterFactoryFacadeImpl();
        GameContext.setTheHero(heroFacade.newHero(0));
        monsterFactoryList = monsterFactoryFacade.initMonsters();

        //启用刷新面板线程
        MainThread rt = new MainThread(this);
        rt.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.background.getImage(), 0, 0, 980, 800, this);

//        monster 1
        if(player.x>220&&player.x<360&&player.y>410&player.y<520&&monsterFactoryList.get(0).getHP()>0){
            GameContext.setTheMonster(monsterFactoryList.get(0));
            GameContext.getTheHero().setHP(GameContext.getTheHero().getHP()-1);
            int temp_width = (int)(((double)GameContext.getTheMonster().getHP() / (double)GameContext.getTheMonster().getMaxHP()) * 50);

            System.out.println(temp_width);
//            g.drawRect(350 + 20, 500-10, 40, 10);
            g.setColor(Color.red);
//            g.drawRect(350, 490, temp_width, 8);
            g.fillRect(350, 490, temp_width, 8);
        }

        if(monsterFactoryList.get(0).getHP()>0){
            g.drawImage(this.monster.getImage(), 350, 500, 50, 50, this);
        }else{
//            monster die
//            GameContext.
            GameContext.setTheMonster(null);
        }
//monster2
        if(player.x>420&&player.x<580&&player.y>510&player.y<620&&monsterFactoryList.get(1).getHP()>0){
            GameContext.setTheMonster(monsterFactoryList.get(1));
            GameContext.getTheHero().setHP(GameContext.getTheHero().getHP()-1);
            int temp_width = (int)(((double)GameContext.getTheMonster().getHP() / (double)GameContext.getTheMonster().getMaxHP()) * 50);

            System.out.println(temp_width);
//            g.drawRect(350 + 20, 500-10, 40, 10);
            g.setColor(Color.red);
//            g.drawRect(350, 490, temp_width, 8);
            g.fillRect(550, 590, temp_width, 8);
        }
        if(monsterFactoryList.get(1).getHP()>0){
            g.drawImage(this.monster.getImage(), 550, 600, 50, 50, this);
        }else{
//            monster die
//            GameContext.
            GameContext.setTheMonster(null);
        }

        //
        if(player.x>670&&player.x<830&&player.y>310&player.y<420&&monsterFactoryList.get(2).getHP()>0){
        GameContext.setTheMonster(monsterFactoryList.get(2));
        GameContext.getTheHero().setHP(GameContext.getTheHero().getHP()-1);
        int temp_width = (int)(((double)GameContext.getTheMonster().getHP() / (double)GameContext.getTheMonster().getMaxHP()) * 50);

        System.out.println(temp_width);
//            g.drawRect(350 + 20, 500-10, 40, 10);
        g.setColor(Color.red);
//            g.drawRect(350, 490, temp_width, 8);
        g.fillRect(800, 390, temp_width, 8);
    }
        if(monsterFactoryList.get(2).getHP()>0){
            g.drawImage(this.monster.getImage(), 800, 400, 50, 50, this);
        }else{
//            monster die
//            GameContext.
            GameContext.setTheMonster(null);
        }




        g.setColor(Color.BLACK);
        g.fillRect(980, 0, 1, 800);
        g.fillRect(980, 220, 220, 1);
        g.drawImage(this.photo.getImage(), 990, 10, 200,200, this);
        g.drawString("等级      "+GameContext.getTheHero().getLevel(),990,250);
        g.drawString("经验值    "+GameContext.getTheHero().getExp(),990,280);
        g.drawString("生命值    "+GameContext.getTheHero().getHP()+'/'+GameContext.getTheHero().getMaxHP(),990,310);
        g.drawString("攻击力    "+GameContext.getTheHero().getAttackNum(),990,340);
        g.drawString("防御力    "+GameContext.getTheHero().getDefensiveNum(),990,370);
        g.fillRect(980, 400, 220, 1);
        if(GameContext.getTheMonster()!=null){
            g.drawString("对战信息      ",990,430);
            g.drawString("怪物生命      "+GameContext.getTheMonster().getHP()+"/"+GameContext.getTheMonster().getMaxHP(),990,460);
        }
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
            System.out.println("x:"+player.x+"---"+"y:"+player.y);

            switch (keyCode){
//                wasd
                case 87:
                    state = 0;
                    if(player.y>360){
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
                    if(player.y<700){
                        player.y = player.y + player.speed;

                    }
                    break;
                case 68:
                    state = 0;
                    if(player.x<800){
                        player.x = player.x + player.speed;

                    }
                    break;
//                    空格
                case 32:
                    if(GameContext.getTheMonster()!=null){
                        GameContext.getTheMonster().setHP(GameContext.getTheMonster().getHP()-5);
                    }
                    if(state!=1)state = 1;
                    break;
//                    r
                case 82:
                    if(GameContext.getTheMonster()!=null){
                        GameContext.getTheMonster().setHP(GameContext.getTheMonster().getHP()-10);
                    }
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

