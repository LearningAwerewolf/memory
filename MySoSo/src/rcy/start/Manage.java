package rcy.start;

import java.io.IOException;
import java.util.Scanner;

/**
 * ��д�����߼�
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
			System.out.println("*************��ӭʹ�����ƶ�ҵ�����***************");
			System.out.println("1.�û���¼   2.�û�ע��   3.ʹ����   4.���ѳ�ֵ  5.�ʷ�˵��  6.�˳�ϵͳ");
			System.out.print("��ѡ��");
			c.initData();//�û����ݳ�ʼ��
			c.initScence();//ʹ�ó�����ʼ��
			int option = sc.nextInt();
			switch (option) {
			case 1:/* �û���¼ */
				c.loginSoso();
				break;
			case 2:/* �û�ע�� */
				c.addCard();
				break;
			case 3:/* ʹ���� */
				c.useSoso();
				break;
			case 4:/* ���ѳ�ֵ */
				c.addPayMoney();
				break;
			case 5:/* �ʷ�˵�� */
				c.showDescription();
				break;
			case 6:/* �˳�ϵͳ */
				isOk = false;
				break;
			default:
				isOk = false;
				break;
			}
		} while (isOk);
	}

}
