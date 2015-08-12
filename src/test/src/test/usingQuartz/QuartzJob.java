package test.usingQuartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

//import sun.util.logging.resources.logging;

import java.util.Date;
import org.apache.log4j.Logger;;

public class QuartzJob implements Job {
	private final Logger log = Logger.getLogger(getClass());

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		String runTime = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
		log.debug(runTime + "QuartzJob--");
	}

}
