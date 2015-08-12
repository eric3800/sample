package test.usingMATM;

public class Decode1043 {
    byte[] content = null;
    String downString = null;
    
	public Decode1043(String vbString) {
		try {
			content = vbString.getBytes("Big5");
		    downString=new String(content,"8859_1");
		} catch (Exception e) {
			// TODO: handle exception
		}
    
	}

	protected static String getString(String content, int start, int length, String cs) {
		try {
			if (cs.equals("Big5")) {
				return new String(content.getBytes("8859_1"), start, length, cs);
			} else {
				return new String(content.getBytes("8859_1"), start, length);
			}
		} catch (Exception e) {
			return "";
		}
	}

	public String getName() {
		return getString(downString, 117, 10, "Big5");
	}

	public String getSelfInActList() 
	{
		return  getString(downString,128,78,"");
	}	
	
	public String getOtherInActList() 
	{
		return  getString(downString,206,400,"");
	}	
	
	
}
