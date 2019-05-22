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
		//模拟浏览器请求页面服务器，获取页面内容并打印
		Document doc = Jsoup.connect("http://www.xs222.cc/html/0/312/").get();
		System.out.println(doc);

	}

	//for (String link : links) {
//		// 获取章节对象
//		Chapter chapter = getChapter(link);
//		// 写入标题
//		bufferedWriter.write(chapter.getName());
//		// 换行
//		bufferedWriter.newLine();
//		// 写入内容
//		bufferedWriter.write(chapter.getCountTxT());
//		// 换行
//		bufferedWriter.newLine();
//		System.out.println("章节：       " + chapter.getName() + "     下载完毕！！！");
//
//	}
}
