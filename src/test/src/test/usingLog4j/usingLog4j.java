package test.usingLog4j;

//import org.apache.log4j.BasicConfigurator; 
import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;


public class usingLog4j {
	private static Logger logger = Logger.getLogger(usingLog4j.class);
	
	public static void main(String[] args) {
//		BasicConfigurator.configure();
		logger.info("1.info...");
		logger.debug("1.debug...");
		logger.error("1.This is error message!!!");
		
		logger.debug("debug message");
		logger.info("info message");
		logger.warn("warn message");
		logger.error("error message");
		logger.fatal("fatal message");
		
//		PropertyConfigurator.configure("D:/sample/src/test/bin/Log4j.properties");
//		Logger logger = Logger.getLogger(usingLog4j.class);
//		logger.info("2.info...");
//		logger.debug("2.debug...");
//		logger.error("2.This is error message!!!");

	}

}
