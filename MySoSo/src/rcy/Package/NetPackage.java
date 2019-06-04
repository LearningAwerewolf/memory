package rcy.Package;

import rcy.Basics.MobileCard;

import rcy.Service.NetService;

/**
 * 网虫套餐
 * 
 * @author Administrator
 *
 */
public class NetPackage extends ServicePackage implements NetService {

	private int flow;// 上网流量

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
		System.out.println("网虫套餐：上网流量为" + (this.flow / 1024) + "G/月，资费为" + this.price + "元/月。");
	}

	@Override
	public int netPlay(int flow, MobileCard card) {
		// TODO Auto-generated method stub
		return 0;
	}

}
