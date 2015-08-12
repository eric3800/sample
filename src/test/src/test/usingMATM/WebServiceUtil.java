package test.usingMATM;

import java.util.Date;

import org.apache.log4j.Logger;
import java.util.concurrent.atomic.AtomicInteger;

//import com.cienet.adpt.cosmos.cache.AdptCfgCacheStore;
//import com.cienet.svc.mbank.util.IntfUtil;
//
//import cosmos.netbank.code.DecodeV364;
//import cosmos.netbank.code.MakeV364;
//import cosmos.netbank.util.Tools;

import service.client.NetBankService;
import service.client.NetBankServiceImplService;
import service.client.UtilVO;

public class WebServiceUtil {
    private static final Logger log = Logger.getLogger(WebServiceUtil.class);

	static AtomicInteger AI = new AtomicInteger();

	private static NetBankService getService() {
		NetBankServiceImplService ss = new NetBankServiceImplService();
		NetBankService service = ss.getNetBankServiceImplPort();
		return service;
	}

	public static String changePassword(String loginPwd) {
		UtilVO  encodePasswd1 = new UtilVO();
		encodePasswd1.setOp("C");
		encodePasswd1.setStr1(loginPwd);
		String ep = getService().encodePasswordBasedOnAlgorithm(
				getWsSysCode(), getWsAccessId(), encodePasswd1);
		log.trace("loginPwd:" + loginPwd + ",encrypted:" + ep);		
		return ep;
	}

	private static String getWsAccessId() {
//		if (IntfUtil.isLocalTest) {
			return "mbank";
//		}
//		return AI.getAndIncrement() + ".." + System.currentTimeMillis();
	}

	private static String getWsSysCode() {
		
//		if (IntfUtil.isLocalTest) {
			return "mbank";
//		}
//		return AdptCfgCacheStore.getWsSysCode();
	}

	public static String packPassword(String... sa) {
		if (sa == null || sa.length == 0) {
			return "";
		}

		UtilVO  encodePasswd1 = new UtilVO();
		encodePasswd1.setOp(getOp(sa.length));
		encodePasswd1.setStr1(sa[0]);
		if (sa.length >= 2) {
			encodePasswd1.setStr2(sa[1]);
		}
		if (sa.length >= 3) {
			encodePasswd1.setStr3(sa[2]);
		}
		if (sa.length >= 4) {
			encodePasswd1.setStr4(sa[3]);
		}
		if (sa.length >= 5) {
			encodePasswd1.setStr5(sa[4]);
		}
		if (sa.length >= 6) {
			encodePasswd1.setStr6(sa[5]);
		}
		if (sa.length >= 7) {
			encodePasswd1.setStr7(sa[6]);
		}
		if (sa.length >= 8) {
			encodePasswd1.setStr8(sa[7]);
		}
		if (sa.length >= 9) {
			encodePasswd1.setStr9(sa[8]);
		}
		return getService().encodePasswordBasedOnAlgorithm(
				getWsSysCode(), getWsAccessId(), encodePasswd1);
	}		
		
	private static String getOp(int len) {
		switch (len) {
		case 6:
			return "R";
		case 5: 
			return "S";
		case 3:
			return "E";
		case 7:
			return "Q";
		case 8:
			return "P";
		case 9:
			return "O";
		}
		throw new RuntimeException("Unsupported..");
	}

	public static String encryptUserId(String loginId, String userId) {
		UtilVO  preCrypto = new UtilVO();
		preCrypto.setOp("A");
		preCrypto.setStr1(loginId);
		preCrypto.setStr2(userId);
		String afterCryUserNo = getService().cryptUserNo(
					getWsSysCode(), getWsAccessId(), preCrypto);
		log.trace("loginId:" + loginId + ",userId:" + userId + ",encrypted:" + afterCryUserNo);
		return afterCryUserNo;
	}

	public static String changePasswdPrevious(String newPasswd) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String PasswdChange(String s) {
		UtilVO  encodePasswd1 = new UtilVO();
		encodePasswd1.setOp("B");
		encodePasswd1.setStr1(s);
		String ep = getService().encodePasswordBasedOnAlgorithm(
				getWsSysCode(), getWsAccessId(), encodePasswd1);
		log.trace("loginPwd:" + s + ",encrypted:" + ep);	
		return ep;
	}

	public static void main(String...args) throws Exception {
		String time = new java.text.SimpleDateFormat("HHmmss").format(new Date());
		/*
		String getString = packPassword("VB38",
				"5555", Tools.fillstring(Tools.IdChangeNumAll("A123456789"),11,'0',Tools.FILL_LAST),
					Tools.fillstring(Tools.IdChangeNumAll("026118039604"),14,'0',Tools.FILL_LAST),
					Tools.fillstring(Tools.IdChangeNumAll("019532173506"),14,'0',Tools.FILL_LAST),
					Tools.fillstring(Tools.IdChangeNumAll("1000"),11,'0',Tools.FILL_PREV),time);
		
		
		System.out.println("1:" + Tools.IdChangeNumAll("A123456789"));
		System.out.println("2:" + Tools.fillstring(Tools.IdChangeNumAll("A123456789"),11,'0',Tools.FILL_LAST));
		
		System.out.println("2:" + Tools.fillstring(Tools.IdChangeNumAll("026118039604"),14,'0',Tools.FILL_LAST));
		System.out.println("2:" + Tools.fillstring(Tools.IdChangeNumAll("019532173506"),14,'0',Tools.FILL_LAST));
		System.out.println("2:" + Tools.fillstring(Tools.IdChangeNumAll("1000"),11,'0',Tools.FILL_PREV));
		
		System.out.println(getString);
		
		UtilVO  encodePasswd1 = new UtilVO();
		encodePasswd1.setOp("E");
		encodePasswd1.setStr1("VB38");
		encodePasswd1.setStr2("5555");
		encodePasswd1.setStr3("01123456789");
		encodePasswd1.setStr4("026118039604");
		encodePasswd1.setStr5("019532173506");
		encodePasswd1.setStr6("1000");
		encodePasswd1.setStr7("144000");
		
		System.out.println(getService().encodePasswordBasedOnAlgorithm(
				getWsSysCode(), getWsAccessId(), encodePasswd1));
		*/
		
		UtilVO  encodePasswd1 = new UtilVO();
		encodePasswd1.setOp("O");
		encodePasswd1.setStr1("V364");
		encodePasswd1.setStr2("5555");
		encodePasswd1.setStr3("2");
		encodePasswd1.setStr4("10153103690500");
		encodePasswd1.setStr5("110901");
		encodePasswd1.setStr6("110901");
		encodePasswd1.setStr7("10000000000000000000000000000000");
		encodePasswd1.setStr8("00000000700");
		encodePasswd1.setStr9("111309");
		/*
		private  MakeV364(String pid,String temp,String amount,String account_no, String unifiedId,String sendSn,String authPwd,String func,String r_sdate,String r_edate) throws Exception {		
			customerId, loginPwd, 
					"" + tf.getTransferAmount(), tf.getAccount(), unifiedId, "1", authCode, "1",
					tdate, tdate);

			Date datetime=new Date();
			querytime=datetime;
			String time = new java.text.SimpleDateFormat("HHmmss").format(datetime);	
			
			amount = Tools.fillstring(amount,11,'0',cosmos.netbank.util.Tools.FILL_PREV);
			unifiedId=Tools.fillstring(unifiedId,11,' ',Tools.FILL_LAST);

			String getString = WebServiceUtil.packPassword("V364",temp,unifiedId,
					Tools.fillstring(Tools.IdChangeNumAll(account_no),14,'0',Tools.FILL_LAST),
					r_sdate,r_edate,func,amount,time);
	*/
		System.out.println("res:" + getService().encodePasswordBasedOnAlgorithm(
				getWsSysCode(), getWsAccessId(), encodePasswd1));
		
		/*
		NetBankServiceImplService ss = new NetBankServiceImplService();
		NetBankService service = ss.getNetBankServiceImplPort();
		
		String beforeEncodePwd="F120828797";
		String sysCode="mbank";
		String acessId ="mbank";
		String custId="D100373600"; //014561684003
		String userNo="A123456789";
		String afterEncodePwd ="";
		
		//test changeId
		//try {
		 //afterEncodePwd =  service.encodeId(sysCode,acessId,beforeEncodePwd);
		 //System.out.println("#########test changeId_BeforeEncodePwd: " + 
		//		 beforeEncodePwd+ ", AfterEncodePwd: " + afterEncodePwd);
		System.out.println(service.encodeId(sysCode,acessId,beforeEncodePwd));

		//}catch (Exception e) {
		//	e.printStackTrace();
		//}
		*/
		
		//NetBankServiceImplService ss = new NetBankServiceImplService();
		//NetBankService service = ss.getNetBankServiceImplPort();
		//System.out.println(getService().encodeId(getWsSysCode(), getWsAccessId(), "F120828797"));
		//System.out.println(encryptPid("F12082897"));
		 
		 
	}
	public static String encryptPid(String pid) {
		//new cosmos.netbank.creditcard.changeId().Encode(customerId)
		return getService().encodeId(getWsSysCode(), getWsAccessId(), pid);
	}
}
