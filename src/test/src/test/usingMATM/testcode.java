package test.usingMATM;

import java.io.*;
import java.util.*;
import java.lang.Math;

import org.exolab.castor.xml.Marshaller;
import com.truetel.jcore.util.TimeUtil;
import java.io.StringWriter;

public class testcode {

	public static void main(String[] args) {

		String tryId = "5";

		// =================================================
			
		if (tryId.equals("5"))
			try {
				String d1 = "20150728112001";
				String d2 = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				System.out.println(d2);
				long i1 = Long.parseLong(d1, 10);
				long i2 = Long.parseLong(d2, 10);

				System.out.println(i1);
				System.out.println(i2);
				System.out.println(i2 - i1);
				System.out.println(i1 - i2);
				System.out.println(Math.abs(i1 - i2));

				long diffTime = i2 - i1;
				System.out.println(String.valueOf(diffTime));
				if (diffTime < 500) {
					System.out.println("< 500");
				} else if (diffTime < 6000) {
					System.out.println("< 6000");
				} else {
					System.out.println("> 6000");
				}

				return;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} // =================================================
		if (tryId.equals("4"))
			try {
				String LoginPwd = "12345";
				String LoginId = "A123";
				String UserId = "Eric";
				String pwd = "";
				String uid = "";

				pwd = WebServiceUtil.changePassword(LoginPwd);
				System.out.println("pwd:" + pwd);
				uid = WebServiceUtil.encryptUserId(LoginId, UserId);
				System.out.println("uid:" + uid);

				return;
			} catch (Exception e) {
				e.printStackTrace();
			}

		// =================================================
		if (tryId.equals("3"))
			try {
				String trxTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				System.out.println(trxTime);
				System.out.println(TimeUtil.dateToY12s(new Date()));
				System.out.println(trxTime.substring(10));
				System.out.println(trxTime.substring(0, 16));
				return;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		// =================================================
		if (tryId.equals("2"))
			try {
				List<NTDBank> lists = new ArrayList();
				/*
				 * <Obj cls="NTDBank"> <Attr name="bankNo">807</Attr> <Attr
				 * name="bankName">永豐銀行</Attr> </Obj> <Obj cls="NTDBank"> <Attr
				 * name="bankNo">808</Attr> <Attr name="bankName">玉山銀行</Attr>
				 * </Obj> <Obj cls="NTDBank"> <Attr name="bankNo">809</Attr>
				 * <Attr name="bankName">凱基銀行</Attr> </Obj>
				 */

				NTDBank bank = new NTDBank();
				bank.setBankNo("807");
				bank.setBankName("永豐銀行");
				lists.add(bank);
				bank = null;
				bank = new NTDBank();

				bank.setBankNo("808");
				bank.setBankName("玉山銀行");
				lists.add(bank);
				bank = null;
				bank = new NTDBank();

				bank.setBankNo("809");
				bank.setBankName("凱基銀行");
				lists.add(bank);

				Map<String, String> map = new HashMap<String, String>();

				for (int i = 0; i < lists.size(); i++) {
					// System.out.println(lists.get(i).getBankNo());
					// System.out.println(lists.get(i).getBankName());
					map.put(lists.get(i).getBankNo(), lists.get(i).getBankName());
				}

				String bankName = "";

				String downString = "021010430000000000000000000000407211256070000MATM0019530010218001000000000000000000000000000000000000000000000000019 ＬｐＡＨ　  100530700505 100530185502 404040404040 404040404040 404040404040 404040404040Y0090005050512453900Y8086873268127837218 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000 0000000000000000000";
				Decode1043 d1043 = new Decode1043(downString);

				String sName = d1043.getName();
				System.out.println(sName);

				String sSelfActList = d1043.getSelfInActList();
				String sOtherActList = d1043.getOtherInActList();
				System.out.println("自行:" + sSelfActList);
				System.out.println("他行:" + sOtherActList);
				System.out.println();

				String flag = "";
				String bankID = "";
				String accountNo = "";

				for (int i = 0; i < 6; i++) {
					flag = sSelfActList.substring(i * 13, i * 13 + 1);
					accountNo = sSelfActList.substring(i * 13 + 1, (i * 13 + 1) + 12);
					if (!"404040404040".equals(accountNo))
						System.out.printf("%s\t%s\t%s\n", "銀行代碼:809", "銀行:凱基銀行", "帳號:" + accountNo);
				}
				System.out.println();
				System.out.println(sSelfActList.length());
				System.out.println();

				for (int i = 0; i < 20; i++) {
					flag = sOtherActList.substring(i * 20, i * 20 + 1);
					bankID = sOtherActList.substring(i * 20 + 1, (i * 20 + 1) + 3);
					accountNo = sOtherActList.substring(i * 20 + 4, (i * 20 + 1) + 19);
					bankName = getBankName(bankID, map);
					if (!"0000000000000000".equals(accountNo))
						System.out.printf("%s\t%s\t%s\n", "銀行代碼:" + bankID, "銀行:" + bankName, "帳號:" + accountNo);
				}
				System.out.println();
				System.out.println(sOtherActList.length());
				System.out.println();

				return;
			} catch (Exception e) {
				// TODO: handle exception
			}

		// =================================================
		if (tryId.equals("1"))
			try {
				AppIntfRes res = new AppIntfRes();

				res.setFunctionId("8_2_1_002");
				res.setDeviceOS("iPhone OS");
				res.setDeviceType("1");
				res.setDeviceIdentify("15FD69F8B9EF4D4A863B3754856FDE82");
				res.setReqTime("20150721083704");
				res.setSession("");
				res.setUserIdentify("");
				res.setResTime(TimeUtil.dateToY12s(new Date()));
				res.setMAC("");
				res.setResCode("0000");

				String returnStr = marshalRes(res);
				System.out.println(returnStr);

				return;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		// =================================================

	}

	/**
	 * 查詢銀行中文名稱
	 * 
	 * @param bankID
	 *            輸入查詢銀行代碼
	 * @param map
	 *            傳入銀行代碼對照表
	 * @return 回傳銀行中文名稱
	 */
	protected static String getBankName(String bankID, Map<String, String> map) {
		String bankName = "";
		bankName = map.get(bankID);
		if (null == bankName || "".equals(bankName)) {
			bankName = "";
			// System.out.println("bankName:null 或者 空白");
		} else {
			// System.out.println("bankName:" + bankName);
		}
		return bankName;
	}

	private static String marshalRes(AppIntfRes res) throws Exception {
		StringWriter writer = new CRLFStringWriter();
		Marshaller marshal = new Marshaller(writer);
		marshal.marshal(res);
		return writer.toString();
	}

	// private static String genTimeStamp(String inFormat) {
	//
	// Date datetime = new Date();
	// String sTimeStamp = new
	// java.text.SimpleDateFormat(inFormat).format(datetime);
	//
	// return strLeft(sTimeStamp, 2);
	// }
	//
	// private static String strLeft(String str, int n) {
	// if (n <= 0)
	// return "";
	// else if (n > str.length())
	// return str;
	// else
	// return str.substring(0, n);
	// }
	//
	// private static String strRight(String str, int n) {
	// if (n <= 0)
	// return "";
	// else if (n > str.length())
	// return str;
	// else {
	// int iLen = str.length();
	// // System.out.println("### [i] iLen=" + iLen);
	// return str.substring(iLen - n);
	// }
	// }

}
