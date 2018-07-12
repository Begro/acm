package liu.yan.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liu yan
 * @description
 * @date 2018/6/12
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        FixedTimerTask task = new FixedTimerTask();
        System.out.println("start");


        //0表示立即执行一次，以后每隔一段时间执行一次
        timer.schedule(task, 0, 5000);
    }
}


class FixedTimerTask extends TimerTask {

    @Override
    public void run() {
        Date d = new Date();
        for(int i=0;i<3;i++){
            try {
                Thread.sleep(1000);
                System.out.println("已执行【"+(i+1)+"】秒钟，at: "+d.toLocaleString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("本次任务调度结束，at: "+new Date().toLocaleString());
        System.out.println("---------------------------");
    }

}
