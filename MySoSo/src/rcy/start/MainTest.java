package rcy.start;

import java.io.IOException;

/**
 * �������main�������ڵ�<����ϵͳ>
 * 
 * @author Administrator
 * @date 2019/5-30
 *
 */
public class MainTest {
	public static void main(String[] args) {
		Manage manage = new Manage();
		try {
			manage.mainmenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
