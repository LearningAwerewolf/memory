package Test_Tos6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
/**
 * 版本2.0
 * 
 * @author Administrator
 */
public class PlayingCard2_0 {
	public static void main(String[] args) {
		// 创建HashMap集合
		HashMap<Integer, String> poker = new HashMap<Integer, String>();
		// 创建ArrayList集合
		ArrayList<Integer> array = new ArrayList<Integer>();
		// 创建花色，数字集合
		// 在HashMap里从0开始存编号，并存储对应的值
		// 在ArrayList存储编号
		String[] huase = { "♥", "♣", "♦", "♠" };// 花色数组
		String[] daxiao = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };// 数字数组
		int index = 0;// 初始化编号
		for (String number : daxiao) {
			for (String color : huase) {
				String card = color.concat(number);// 做字符串的拼接
				poker.put(index, card);// 把值存入HashMap里
				array.add(index);// 在ArrayList里存储编号
				index++;// 编号累加
			}
		}
		poker.put(index, "大王");
		index++;
		poker.put(index, "小王");
		// 洗牌(洗的是编号)
		Collections.shuffle(array);
		//System.out.println(array);
		// 发牌（排序，用TreeSet接收）
		TreeSet<Integer> xiaofei = new TreeSet<Integer>();// 窦绍飞
		TreeSet<Integer> xiaoqiang = new TreeSet<Integer>();// 袁浩强
		TreeSet<Integer> xiaole = new TreeSet<Integer>();// 周家乐
		TreeSet<Integer> dipai = new TreeSet<Integer>(); // 底牌
		for (int i = 0; i < array.size(); i++) {
			if (i >= array.size() - 3) {
				dipai.add(array.get(i));
			} else if (i % 3 == 0) {
				xiaofei.add(array.get(i));
			} else if (i % 3 == 1) {
				xiaoqiang.add(array.get(i));
			} else if (i % 3 == 2) {
				xiaole.add(array.get(i));
			}
		}
		// 看牌（通过编号去HashMap集合里拿牌）
		lookpoker("窦绍飞", xiaofei, poker);
		lookpoker("周家乐", xiaole, poker);
		lookpoker("袁浩强", xiaoqiang, poker);
		lookpoker("底牌    ", dipai, poker);
	}
	public static void lookpoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> poker) {
		System.out.print(name + "的牌是：");
		for (Integer key : ts) {
			String value = poker.get(key);
			System.out.print(value + " ");
		}
		System.out.println();
	}
}
