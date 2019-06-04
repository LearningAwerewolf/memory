package rcy.Basics;

import rcy.Package.ServicePackage;

/**
 * 手机卡类
 * 
 * @author Administrator
 *
 */
public class MobileCard {
	private String cardNumber;// 卡号
	private String userName;// 用户名
	private String passworld;// 密码
	private ServicePackage serPackage;// 所属套餐
	private double consumAmount;// 当月消费金额:消费金额=套餐费+实际消费金额
	private double money;// 账户余额:当前余额=充值钱数-consumAmount（消费金额）
	private int realTalkTime;// 当月通话时长
	private int realSMSCount;// 当月发送短信数量
	private int realFlow;// 当月上网流量
	/*
	 * 构造方法
	 */

	public MobileCard() {

	}

	public MobileCard(String cardNumber, String userName, String passworld, ServicePackage serPackage,
			double consumAmount, double money) {
		this.userName = userName;
		this.passworld = passworld;
		this.cardNumber = cardNumber;
		this.serPackage = serPackage;
		this.consumAmount = consumAmount;
		this.money = money;
	}

	public void showMeg() {

		System.out.println("卡号：" + this.cardNumber + "用户名:" + this.userName + "当前余额：" + this.money + "元");

		this.serPackage.showInfo();

	}

	/* getXxx，SetXxx方法 */

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassworld() {
		return passworld;
	}

	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}

	public ServicePackage getSerPackage() {
		return serPackage;
	}

	public void setSerPackage(ServicePackage serPackage) {
		this.serPackage = serPackage;
	}

	public double getConsumAmount() {
		return consumAmount;
	}

	public void setConsumAmount(double consumAmount) {
		this.consumAmount = consumAmount;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getRealTalkTime() {
		return realTalkTime;
	}

	public void setRealTalkTime(int realTalkTime) {
		this.realTalkTime = realTalkTime;
	}

	public int getRealSMSCount() {
		return realSMSCount;
	}

	public void setRealSMSCount(int realSMSCount) {
		this.realSMSCount = realSMSCount;
	}

	public int getRealFlow() {
		return realFlow;
	}

	public void setRealFlow(int realFlow) {
		this.realFlow = realFlow;
	}
}
