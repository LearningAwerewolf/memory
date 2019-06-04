package rcy.Basics;

import rcy.Package.ServicePackage;

/**
 * �ֻ�����
 * 
 * @author Administrator
 *
 */
public class MobileCard {
	private String cardNumber;// ����
	private String userName;// �û���
	private String passworld;// ����
	private ServicePackage serPackage;// �����ײ�
	private double consumAmount;// �������ѽ��:���ѽ��=�ײͷ�+ʵ�����ѽ��
	private double money;// �˻����:��ǰ���=��ֵǮ��-consumAmount�����ѽ�
	private int realTalkTime;// ����ͨ��ʱ��
	private int realSMSCount;// ���·��Ͷ�������
	private int realFlow;// ������������
	/*
	 * ���췽��
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

		System.out.println("���ţ�" + this.cardNumber + "�û���:" + this.userName + "��ǰ��" + this.money + "Ԫ");

		this.serPackage.showInfo();

	}

	/* getXxx��SetXxx���� */

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
