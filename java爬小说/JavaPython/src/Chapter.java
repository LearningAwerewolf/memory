/**
 * 章节名称，
 * 章节标题——————
 * 标题类（章节实体类）
 * 
 * @author Administrator
 *
 */
public class Chapter {
	private String name;// 标题
	private String countTxT;// 内容

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
