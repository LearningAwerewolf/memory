import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
 * 
 * @author Administrator
 *
 */
public class YanShi {
	public static void main(String[] args) throws IOException {
		//ģ�����������ҳ�����������ȡҳ�����ݲ���ӡ
		Document doc = Jsoup.connect("http://www.xs222.cc/html/0/312/").get();
		System.out.println(doc);

	}

	//for (String link : links) {
//		// ��ȡ�½ڶ���
//		Chapter chapter = getChapter(link);
//		// д�����
//		bufferedWriter.write(chapter.getName());
//		// ����
//		bufferedWriter.newLine();
//		// д������
//		bufferedWriter.write(chapter.getCountTxT());
//		// ����
//		bufferedWriter.newLine();
//		System.out.println("�½ڣ�       " + chapter.getName() + "     ������ϣ�����");
//
//	}
}
