package test.usingTimer;
import java.util.*;
import java.text.*;
public class demoTimer2 {

	public static void main(String[] args) {
		demoTimer2 timerDemo = new demoTimer2();
		timerDemo.testSchedule();
		timerDemo.testScheduleAtFixedRate();
	}
	
    
    void testSchedule(){

        Timer timer = new Timer();
        System.out.println("testSchedule：");
        System.out.println("Delay：5秒, Period：5秒");
        System.out.println("In \t\t\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
        
        // schedule(TimerTask task, long delay, long period)
        timer.schedule(new DateTaskSleep4to8s(), new Date(), 5000);
        
        try {
            Thread.sleep(30000);
        }
            catch(InterruptedException e) {
        }

        timer.cancel();
        System.out.println("End \t\t\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()) + "\n");
    }
    
    void testScheduleAtFixedRate(){

        Timer timer = new Timer();
        System.out.println("testScheduleAtFixedRate：");
		System.out.println("Delay：5秒, Period：5秒");
		System.out.println("In " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
        
        // scheduleAtFixedRate(TimerTask task, long delay, long period)
		timer.scheduleAtFixedRate(new DateTaskSleep4to8s(), new Date(), 5000);
        
        try {
            Thread.sleep(30000);
        }
            catch(InterruptedException e) {
        }

        timer.cancel();
        System.out.println("End " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()) + "\n");
    }	

}
