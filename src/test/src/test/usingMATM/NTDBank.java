package test.usingMATM;

import java.io.Serializable;
import java.math.BigDecimal;

//@Entity
//@Table(name = "Bank_data")
public class NTDBank implements Serializable{
	
	private static final long serialVersionUID = -1L;
	
//	@Id
//	@Column(name="idx")
//	private BigDecimal idx;
//	
//	@Column(name="bank_no")
	private String bankNo;
	
//	@Column(name="bank_name")
	private String bankName;

//	public BigDecimal getIdx() {
//		return idx;
//	}
//
//	public void setIdx(BigDecimal idx) {
//		this.idx = idx;
//	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
//	public Obj toObj() {
//		Obj obj = new Obj();
//		obj.setCls("NTDBank");	
//		IntfResObjUtil.addAttrToObj(obj, "bankNo", "" + getBankNo());
//		IntfResObjUtil.addAttrToObj(obj, "bankName", "" + getBankName());
//		
//		return obj;
//	}

}