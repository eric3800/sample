package test.usingTimer;
import java.util.*;
import java.text.*;
public class DateTaskSleep4to8s extends TimerTask {
	@Override
	public void run(){
		 System.out.println("Task 預訂執行時間：\t" 
                 + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(this.scheduledExecutionTime()) 
                 + ", \nTask 實際執行時間：\t" 
                 + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
         try {
			int sleepSeconds = (int) (4 + Math.random() * 4);
			System.out.println("Task going to sleep " + sleepSeconds + "s.");
			Thread.sleep(sleepSeconds * 1000);
         }
             catch(InterruptedException e) {
         }
	}
}
