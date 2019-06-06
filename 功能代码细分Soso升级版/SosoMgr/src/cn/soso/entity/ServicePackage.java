package cn.soso.entity;
/**
 * 嗖嗖移动卡套餐
 * @author 
 *
 */
public abstract class ServicePackage {
	//protected String name;  //套餐名称
	protected double price;  //套餐月资费(元)
    /*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	
    
    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	//显示套餐数据
    public abstract void showInfo();
}
