package rcy.start;

import java.io.IOException;
import java.util.Scanner;

/**
 * 编写规则，逻辑
 * 
 * @author Administrator
 *
 */
public class Manage {
	CardUtil c = new CardUtil();
	Scanner sc = new Scanner(System.in);

	public void mainmenu() throws IOException {
		boolean isOk = true;
		do {
			System.out.println();
			System.out.println("*************欢迎使用嗖嗖移动业务大厅***************");
			System.out.println("1.用户登录   2.用户注册   3.使用嗖嗖   4.话费充值  5.资费说明  6.退出系统");
			System.out.print("请选择：");
			c.initData();//用户数据初始化
			c.initScence();//使用场景初始化
			int option = sc.nextInt();
			switch (option) {
			case 1:/* 用户登录 */
				c.loginSoso();
				break;
			case 2:/* 用户注册 */
				c.addCard();
				break;
			case 3:/* 使用嗖嗖 */
				c.useSoso();
				break;
			case 4:/* 话费充值 */
				c.addPayMoney();
				break;
			case 5:/* 资费说明 */
				c.showDescription();
				break;
			case 6:/* 退出系统 */
				isOk = false;
				break;
			default:
				isOk = false;
				break;
			}
		} while (isOk);
	}

}
