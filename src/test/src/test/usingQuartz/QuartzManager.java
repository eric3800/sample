package test.usingQuartz;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.truetel.jcorex.util.JBossNamingConverter;

public class QuartzManager {

	private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
	private static String JOB_GROUP_NAME = "TS_JOBGROUP_NAME";
	private static String TRIGGER_GROUP_NAME = "TS_TRIGGERGROUP_NAME";

	public static void addJob(String jobName, String jobClass, String time) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, Class.forName(jobClass)); // 任務名，任務組，任務執行類
			// 觸發器
			CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME); // 觸發器名,觸發器組
			trigger.setCronExpression(time); // 觸發器時間設定
			sched.scheduleJob(jobDetail, trigger);
			// 啟動
			if (!sched.isShutdown()) {
				sched.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
			String jobClass, String time) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			JobDetail jobDetail = new JobDetail(jobName, jobGroupName, Class.forName(jobClass)); // 任務名，任務組，任務執行類
			// 觸發器
			CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName); // 觸發器名,觸發器組
			trigger.setCronExpression(time); // 觸發器時間設定
			sched.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void modifyJobTime(String jobName, String time) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			CronTrigger trigger = (CronTrigger) sched.getTrigger(jobName, TRIGGER_GROUP_NAME);
			if (trigger == null) {
				return;
			}
			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(time)) {
				JobDetail jobDetail = sched.getJobDetail(jobName, JOB_GROUP_NAME);
				Class objJobClass = jobDetail.getJobClass();
				String jobClass = objJobClass.getName();
				removeJob(jobName);

				addJob(jobName, jobClass, time);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void modifyJobTime(String triggerName, String triggerGroupName, String time) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerName, triggerGroupName);
			if (trigger == null) {
				return;
			}
			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(time)) {
				CronTrigger ct = (CronTrigger) trigger;
				// 修改時間
				ct.setCronExpression(time);
				// 重啟觸發器
				sched.resumeTrigger(triggerName, triggerGroupName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void removeJob(String jobName) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			sched.pauseTrigger(jobName, TRIGGER_GROUP_NAME); // 停止觸發器
			sched.unscheduleJob(jobName, TRIGGER_GROUP_NAME); // 移除觸發器
			sched.deleteJob(jobName, JOB_GROUP_NAME); // 刪除任務
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			sched.pauseTrigger(triggerName, triggerGroupName); // 停止觸發器
			sched.unscheduleJob(triggerName, triggerGroupName); // 移除觸發器
			sched.deleteJob(jobName, jobGroupName); // 刪除任務
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 啟動所有定時任務
	 */
	public static void startJobs() {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			sched.start();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 關閉所有定時任務
	 */
	public static void shutdownJobs() {
		try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			if (!sched.isShutdown()) {
				sched.shutdown();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
