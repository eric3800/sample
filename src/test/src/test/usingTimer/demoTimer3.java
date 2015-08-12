package test.usingTimer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class demoTimer3 {

	public static void main(String[] args) {
		demoTimer3 timerDemo = new demoTimer3();
		timerDemo.testSchedulePassedDate();
		timerDemo.testScheduleAtFixedRatePassedDate();
	}
	
    void testSchedulePassedDate(){
    	 
        Timer timer = new Timer();
        System.out.println("testSchedulePassedDate：");
        System.out.println("Period：2秒");
		System.out.println("In \t\t\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
        
        // 設定填入schedule中的 Date firstTime 為現在的3秒前
        Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 3);
        Date firstTime = calendar.getTime();
        
        // 也可用 simpleDateFormat 直接設定 firstTime 的精確時間
        // SimpleDateFormat dateFormatter = 
        //      new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
        // Date firstTime = dateFormatter.parse("2011/12/25 13:30:00");
        
        // schedule(TimerTask task, Date firstTime, long period)
        timer.schedule(new DateTaskWithBothTime(), firstTime, 2000);
        
        try {
            Thread.sleep(10000);
        }
            catch(InterruptedException e) {
        }

        timer.cancel();
        System.out.println("End \t\t\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()) + "\n");
    }
    
    void testScheduleAtFixedRatePassedDate(){

        Timer timer = new Timer();
        System.out.println("testScheduleAtFixedRatePassedDate：");
        System.out.println("Period：2秒");
        System.out.println("In \t\t\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
        
        // 設定填入schedule中的 Date firstTime 為現在的3秒前
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 3);
        Date firstTime = calendar.getTime();
        
        // schedule(TimerTask task, Date firstTime, long period)
		timer.scheduleAtFixedRate(new DateTaskWithBothTime(), firstTime, 2000);
        
        try {
            Thread.sleep(10000);
        }
            catch(InterruptedException e) {
        }

        timer.cancel();
        System.out.println("End \t\t\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date())  + "\n");
    }

}
