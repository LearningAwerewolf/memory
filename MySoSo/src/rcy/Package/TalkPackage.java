package rcy.Package;

import rcy.Basics.MobileCard;
import rcy.Service.CallService;
import rcy.Service.SendService;

/**
 * 话唠套餐
 * 
 * @author Administrator
 *
 */
public class TalkPackage extends ServicePackage implements SendService, CallService {

	private int talkTime;// 通话时长
	private int smsCount;// 短信条数

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
				.println("话唠套餐：通话时长为" + this.talkTime + "分钟/月，短信条数为" + this.smsCount + "条/月，资费为" + this.price + "元/月。");

	}

	@Override
	public int call(int minCount, MobileCard card) throws Exception {
		int temp = minCount;
		for (int i = 0; i < minCount; i++) {
			if (this.talkTime - card.getRealTalkTime() >= 1) {
				// 第一种情况：套餐剩余通话时长可支持1分钟通话
				card.setRealTalkTime(card.getRealTalkTime() + 1);// 实际通话数据加1
			} else if (card.getMoney() >= 0.2) {
				// 第二种情况：套餐时长用完，账户余额支付一次的账户支付，一次0.2元
				// 先增加通话数据
				card.setRealTalkTime(card.getRealTalkTime() + 1);// 实际通话数据加1
				// 余额的增减
				card.setMoney(card.getMoney() - 0.2);
				// 消费金额的增加
				card.setConsumAmount(card.getConsumAmount() + 0.2);
			} else {
				temp = i;// 记录通话分钟数
				throw new Exception("本次已通话" + temp + "分钟，你的余额不足，请充值后使用！！！");

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
				// 账户余额增加0.1元,消费金额也增加0。1
				card.setMoney(card.getMoney() - 0.1);
				card.setConsumAmount(card.getConsumAmount() + 0.1);
			} else {
				temp = i;
				throw new Exception("本次发短信" + i + "分钟，您的余额不足，请充值后再使用！");
			}
		}
		return temp;

	}

}
