/*
 * 一对一关联关系
 * 通过身份证可以把人的信息加载上来
 */

package po;

public class CardNo {
	private Integer cid;
	private String cardNo;
	
	//通过卡拿人的信息（关联关系是单向的，如果想通过人拿卡的关系，在人的类里面加卡的属性）
	private Person person;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "CardNo [cid=" + cid + ", cardNo=" + cardNo + ", person=" + person + "]";
	}
	
}
