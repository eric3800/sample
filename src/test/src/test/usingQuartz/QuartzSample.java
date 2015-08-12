package test.usingQuartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

//import com.schedule.QuartzJob;

public class QuartzSample {

	public static void main(String[] args) {
		try {
			String JOB_GROUP_NAME = "TS_JOBGROUP_NAME";
			String TRIGGER_GROUP_NAME = "TS_TRIGGERGROUP_NAME";
			String jobName = "jobName";
			String triggerName = "triggerName";

			StdSchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = gSchedulerFactory.getScheduler();

			if (scheduler.getJobDetail(jobName, JOB_GROUP_NAME) != null) {
				scheduler.deleteJob(jobName, JOB_GROUP_NAME);
			}
			JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, QuartzJob.class);
			CronTrigger trigger = new CronTrigger(triggerName, TRIGGER_GROUP_NAME, "0 0/1 * * * ?");
			scheduler.scheduleJob(jobDetail, trigger);

			if (!scheduler.isShutdown()) {
				scheduler.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
