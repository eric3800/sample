package test.usingTimer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class DateTaskWithBothTime extends TimerTask {
	@Override
	public void run(){
		 System.out.println("Task 預訂執行時間：\t" 
                 + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(this.scheduledExecutionTime()) 
                 + ", \nTask 實際執行時間：\t" 
                 + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
	}
}
