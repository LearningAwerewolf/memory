package rcy.Basics;

/**
 * 消费记录
 * 
 * @author
 *
 */
public class ConsumInfo {
	private String cardNumber;//手机卡号
	private String type;//套餐类型
	private int consumData;//消费记录

	/* 构造方法 */
	public ConsumInfo() {
		// TODO Auto-generated constructor stub
	}

	public ConsumInfo(String cardNumber, String type, int consumData) {
		this.cardNumber = cardNumber;
		this.type = type;
		this.consumData = consumData;
	}

	/* getXxx,SetXxx方法 */
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getConsumData() {
		return consumData;
	}

	public void setConsumData(int consumData) {
		this.consumData = consumData;
	}

}
