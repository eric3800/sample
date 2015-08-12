package test.usingQuartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DumbJob implements Job {

//	@Override
//	public void execute(JobExecutionContext arg0) throws JobExecutionException {
//		System.out.println("#### DumbJob........");
//	}

	public synchronized void execute(JobExecutionContext arg0) throws JobExecutionException{
		System.out.println("#### DumbJob........");
	}

}
