package test.usingTimer;

import java.text.*;
import java.util.*;

public class demoTimer {

	public static void main(String[] args) {
		demoTimer t1 = new demoTimer();
		t1.testScheduleDelay();
		System.out.println("");
		t1.testScheduleDelayAndPeriod();
		System.out.println("");
		t1.testScheduleDateAndPeriod();
	}

	void testScheduleDelay() {
		Timer timer = new Timer();
		System.out.println("Delay:3s ");
		System.out.println("In Demo-1:\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));

		timer.schedule(new DateTask(), 3000);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}
		timer.cancel();
		System.out.println("End Demo-1:\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
	}

	void testScheduleDelayAndPeriod() {
		Timer timer = new Timer();
		System.out.println("Delay:3s , Period:2s");
		System.out.println("In Demo-2:\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));

		timer.schedule(new DateTask(), 3000, 2000);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}
		timer.cancel();
		System.out.println("End Demo-2:\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
	}

	void testScheduleDateAndPeriod() {
		Timer timer = new Timer();
		Calendar calendar = Calendar.getInstance();

		// 設定填入schedule中的Date firstTime為現在的15秒後
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 15);

		Date firstTime = calendar.getTime();
		String runTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(firstTime);

		// 也可用simpleDateFormat直接設定 firstTime的精確時間
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// Date firstTime = dateFormat.parse("2015/12/25 13:30:00");
		System.out.println("設定執行 Date 為15秒後：" + runTime + ", Period：10秒");
		System.out.println("In Demo-3:\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
		// System.out.println("設定執行 Date 為15秒後：" + runTime + ", Period：10秒");

		timer.schedule(new DateTask(), firstTime, 10000);

		try {
			Thread.sleep(30000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		timer.cancel();
		System.out.println("End Demo-3:\t" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));

	}

}
