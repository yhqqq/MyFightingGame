package UI;

/**
 * Created by alfred on 2019/3/24.
 */
public class MainThread extends Thread{
    MainJpanel mainJpanel;
    public MainThread(MainJpanel mainJpanel){
        this.mainJpanel=mainJpanel;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(200);
            } catch (Exception e) {

                e.printStackTrace();
            }
            mainJpanel.repaint();
        }
    }
}


