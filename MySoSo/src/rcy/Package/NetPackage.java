package rcy.Package;

import rcy.Basics.MobileCard;

import rcy.Service.NetService;

/**
 * �����ײ�
 * 
 * @author Administrator
 *
 */
public class NetPackage extends ServicePackage implements NetService {

	private int flow;// ��������

	public NetPackage() {
		this.price = 68.0;
		this.flow = 3 * 1024;
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	@Override
	public void showInfo() {
		System.out.println("�����ײͣ���������Ϊ" + (this.flow / 1024) + "G/�£��ʷ�Ϊ" + this.price + "Ԫ/�¡�");
	}

	@Override
	public int netPlay(int flow, MobileCard card) {
		// TODO Auto-generated method stub
		return 0;
	}

}
