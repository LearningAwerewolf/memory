package rcy.Basics;

/**
 * ʹ�ó�����
 * 
 * @author Administrator
 *
 */
public class Scence {
	private String type;// ��������
	private int data;// ������������
	private String description;// ��������

	/* ���췽�� */
	public Scence() {
		// TODO Auto-generated constructor stub
	}

	public Scence(String type, int data, String description) {
		this.type = type;
		this.data = data;
		this.description = description;
	}

	/* getXxx,SetXxx���� */
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
