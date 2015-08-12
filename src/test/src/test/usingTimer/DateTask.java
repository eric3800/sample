package test.usingTimer;
import java.util.TimerTask;
import java.util.Date;
import java.text.*;
public class DateTask extends TimerTask {
	@Override	
	public void run(){
		System.out.println("Task 執行時間：\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
	}
}
