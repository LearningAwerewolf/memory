package Test_Tos6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 版本1.0
 * 
 * @author Administrator
 */
public class PlayingCard1_0 {

	public static void main(String[] args) {
		List<String> poker = new ArrayList<String>();
		/* 装牌 */
		String[] huase = { "♥", "♣", "♦", "♠" };
		String[] daxiao = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		for (String color : huase) {
			for (String number : daxiao) {
				poker.add(color.concat(number));
			}
		}
		poker.add("大王");
		poker.add("小王");
		// System.out.println(poker);
		/* 洗牌 */
		Collections.shuffle(poker);
		// System.out.println(poker);
		/* 发牌 */
		ArrayList<String> xiaofei = new ArrayList<String>();// 窦绍飞
		ArrayList<String> xiaoqiang = new ArrayList<String>();// 袁浩强
		ArrayList<String> xiaole = new ArrayList<String>();// 周家乐
		ArrayList<String> dipai = new ArrayList<String>();// 底牌
		for (int i = 0; i < poker.size(); i++) {
			if (i >= poker.size() - 3) {
				dipai.add(poker.get(i));
			} else if (i % 3 == 0) {
				xiaofei.add(poker.get(i));
			} else if (i % 3 == 1) {
				xiaoqiang.add(poker.get(i));
			} else if (i % 3 == 2) {
				xiaole.add(poker.get(i));
			}
		}
		/* 看牌 */
		lookpoker("窦绍飞", xiaofei);
		lookpoker("周家乐", xiaole);
		lookpoker("袁浩强", xiaoqiang);
		lookpoker("底牌    ", dipai);
	}

	public static void lookpoker(String name, ArrayList<String> list) {
		System.out.print(name + "的牌是：");
		System.out.print(list + " ");
		System.out.println();
	}
}
