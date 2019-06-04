package rcy.Package;

import rcy.Basics.MobileCard;
import rcy.Service.CallService;
import rcy.Service.SendService;

/**
 * �����ײ�
 * 
 * @author Administrator
 *
 */
public class TalkPackage extends ServicePackage implements SendService, CallService {

	private int talkTime;// ͨ��ʱ��
	private int smsCount;// ��������

	public TalkPackage() {

		this.talkTime = 500;
		this.smsCount = 30;
		this.price = 58.0;
	}

	public int getTalkTime() {
		return talkTime;
	}

	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}

	public int getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}

	@Override
	public void showInfo() {
		System.out
				.println("�����ײͣ�ͨ��ʱ��Ϊ" + this.talkTime + "����/�£���������Ϊ" + this.smsCount + "��/�£��ʷ�Ϊ" + this.price + "Ԫ/�¡�");

	}

	@Override
	public int call(int minCount, MobileCard card) throws Exception {
		int temp = minCount;
		for (int i = 0; i < minCount; i++) {
			if (this.talkTime - card.getRealTalkTime() >= 1) {
				// ��һ��������ײ�ʣ��ͨ��ʱ����֧��1����ͨ��
				card.setRealTalkTime(card.getRealTalkTime() + 1);// ʵ��ͨ�����ݼ�1
			} else if (card.getMoney() >= 0.2) {
				// �ڶ���������ײ�ʱ�����꣬�˻����֧��һ�ε��˻�֧����һ��0.2Ԫ
				// ������ͨ������
				card.setRealTalkTime(card.getRealTalkTime() + 1);// ʵ��ͨ�����ݼ�1
				// ��������
				card.setMoney(card.getMoney() - 0.2);
				// ���ѽ�������
				card.setConsumAmount(card.getConsumAmount() + 0.2);
			} else {
				temp = i;// ��¼ͨ��������
				throw new Exception("������ͨ��" + temp + "���ӣ�������㣬���ֵ��ʹ�ã�����");

			}
		}

		return temp;
	}

	@Override
	public int send(int count, MobileCard card) throws Exception {

		int temp = count;
		for (int i = 0; i < count; i++) {
			if (this.smsCount - card.getRealSMSCount() >= 1) {
				card.setRealSMSCount(card.getRealSMSCount() + 1);
			} else if (card.getMoney() >= 0.1) {
				card.setRealSMSCount(card.getRealSMSCount() + 1);
				// �˻��������0.1Ԫ,���ѽ��Ҳ����0��1
				card.setMoney(card.getMoney() - 0.1);
				card.setConsumAmount(card.getConsumAmount() + 0.1);
			} else {
				temp = i;
				throw new Exception("���η�����" + i + "���ӣ��������㣬���ֵ����ʹ�ã�");
			}
		}
		return temp;

	}

}
