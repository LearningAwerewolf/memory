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
		// 获取所有所有的章节链接
		List<String> links = getAllLinks("https://www.23us.so/files/article/html/3/3574/index.html");
		// 创建文件输出流对象
		FileWriter fileWriter = new FileWriter("飞剑问道.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for (String link : links) {
			Chapter chapter = getChapter(link);
			bufferedWriter.write(chapter.getName());
			// 换行
			bufferedWriter.newLine();
			// 写入内容
			bufferedWriter.write(chapter.getCountTxT());
			// // 换行
			bufferedWriter.newLine();
			System.out.println("章节： " + chapter.getName() + " 下载完毕！！！");
		}
		// 关闭资源
		bufferedWriter.close();
		fileWriter.close();
	}

	/**
	 * 通过首页链接，获取章节链接，存储在集合里
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static List<String> getAllLinks(String url) throws IOException {
		List<String> list = new ArrayList<>();
		Document doc = Jsoup.connect(url).get();
		/* 章节链接储存在<a>标签内，获取a标签内的内容 */
		Element div = doc.getElementById("at");
		Elements as = div.getElementsByTag("a");
		System.out.println(as);
		for (Element a : as) {
			String href = a.attr("abs:href");
			// 把获取的链接添加到集合里
			list.add(href);
		}
		return list;
	}

	public static Chapter getChapter(String url) throws IOException {
		// 获取章节内容
		Document doc = Jsoup.connect(url).get();
		// 获取标题
		String titleName = doc.getElementsByTag("h1").text();
		// 获取内容
		String countTxT = doc.getElementById("contents").text();
		Chapter chapter = new Chapter(titleName, countTxT);
		return chapter;
	}

}
