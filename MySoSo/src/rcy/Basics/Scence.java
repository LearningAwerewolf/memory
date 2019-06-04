package rcy.Basics;

/**
 * 使用场景类
 * 
 * @author Administrator
 *
 */
public class Scence {
	private String type;// 场景类型
	private int data;// 场景消费数据
	private String description;// 场景描述

	/* 构造方法 */
	public Scence() {
		// TODO Auto-generated constructor stub
	}

	public Scence(String type, int data, String description) {
		this.type = type;
		this.data = data;
		this.description = description;
	}

	/* getXxx,SetXxx方法 */
	public  String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
