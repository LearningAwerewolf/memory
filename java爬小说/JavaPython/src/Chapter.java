/**
 * �½����ƣ�
 * �½ڱ��⡪����������
 * �����ࣨ�½�ʵ���ࣩ
 * 
 * @author Administrator
 *
 */
public class Chapter {
	private String name;// ����
	private String countTxT;// ����

	public Chapter(String name, String countTxT) {
		this.name = name;
		this.countTxT = countTxT;
	}

	public String toString() {
		return "Chapter{" + "name='" + name + '\'' + ",contTxT='" + countTxT + '\'' + '}';

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountTxT() {
		return countTxT;
	}

	public void setCountTxT(String countTxT) {
		this.countTxT = countTxT;
	}

}
