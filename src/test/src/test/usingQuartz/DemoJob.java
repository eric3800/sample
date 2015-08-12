package test.usingQuartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class DemoJob {

	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory scheds = new StdSchedulerFactory();
		Scheduler sched = scheds.getScheduler();
		JobDetail detail = new JobDetail("jobName", "jobGroup", DumbJob.class);
		Trigger DailyTrigger = TriggerUtils.makeDailyTrigger(16, 59);
		DailyTrigger.setName("TiggerName");
		DailyTrigger.setGroup("jobGroup");
		DailyTrigger.setJobGroup("jobGroup");
		DailyTrigger.setJobName("jobName");
		sched.scheduleJob(detail, DailyTrigger);

	}

}
