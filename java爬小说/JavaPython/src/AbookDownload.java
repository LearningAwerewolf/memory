import java.awt.image.BufferedImageFilter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AbookDownload {

	public static void main(String[] args) throws IOException {
		// ��ȡ�������е��½�����
		List<String> links = getAllLinks("https://www.23us.so/files/article/html/3/3574/index.html");
		// �����ļ����������
		FileWriter fileWriter = new FileWriter("�ɽ��ʵ�.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for (String link : links) {
			Chapter chapter = getChapter(link);
			bufferedWriter.write(chapter.getName());
			// ����
			bufferedWriter.newLine();
			// д������
			bufferedWriter.write(chapter.getCountTxT());
			// // ����
			bufferedWriter.newLine();
			System.out.println("�½ڣ� " + chapter.getName() + " ������ϣ�����");
		}
		// �ر���Դ
		bufferedWriter.close();
		fileWriter.close();
	}

	/**
	 * ͨ����ҳ���ӣ���ȡ�½����ӣ��洢�ڼ�����
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static List<String> getAllLinks(String url) throws IOException {
		List<String> list = new ArrayList<>();
		Document doc = Jsoup.connect(url).get();
		/* �½����Ӵ�����<a>��ǩ�ڣ���ȡa��ǩ�ڵ����� */
		Element div = doc.getElementById("at");
		Elements as = div.getElementsByTag("a");
		System.out.println(as);
		for (Element a : as) {
			String href = a.attr("abs:href");
			// �ѻ�ȡ��������ӵ�������
			list.add(href);
		}
		return list;
	}

	public static Chapter getChapter(String url) throws IOException {
		// ��ȡ�½�����
		Document doc = Jsoup.connect(url).get();
		// ��ȡ����
		String titleName = doc.getElementsByTag("h1").text();
		// ��ȡ����
		String countTxT = doc.getElementById("contents").text();
		Chapter chapter = new Chapter(titleName, countTxT);
		return chapter;
	}

}
