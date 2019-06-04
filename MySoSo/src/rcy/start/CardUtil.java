package rcy.start;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import rcy.Basics.ConsumInfo;
import rcy.Basics.MobileCard;
import rcy.Basics.Scence;
import rcy.Package.NetPackage;
import rcy.Package.ServicePackage;
import rcy.Package.SuperPackage;
import rcy.Package.TalkPackage;
import rcy.Service.CallService;
import rcy.Service.NetService;
import rcy.Service.SendService;

/**
 * 工具类
 * 
 * @author Administrator
 *
 */
public class CardUtil {

	private static final ServicePackage TalkPackage = null;
	private static final ServicePackage NetPackage = null;
	private static final ServicePackage SuperPackage = null;

	// map集合储存卡号信息，并通过卡号查到对应的姓名等信息
	/**
	 * 集合
	 */
	Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
	// 所有卡号的消费记录列表
	/**
	 * 卡号的消费记录列表
	 */
	Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();
	List<ConsumInfo> list = new ArrayList<ConsumInfo>();
	// 储存场景列表
	/**
	 * 场景列表
	 */
	List<Scence> scences = new ArrayList<Scence>();

	// 创建手机卡对象--对其操作
	/**
	 * 手机卡对象
	 */
	MobileCard card = new MobileCard();
	// 创建套餐服务对象
	/**
	 * 套餐服务对象
	 */
	ServicePackage servicePackage = null;
	Scanner sc = new Scanner(System.in);

	/**
	 * 使用场景初始化
	 */
	public void initScence() {
		scences.add(new Scence("通话", 90, "问候客户，谁知其如此难缠 通话90分钟"));
		scences.add(new Scence("通话", 30, "询问妈妈身体状况 本地通话30分钟"));
		scences.add(new Scence("短信", 5, "参与环境保护实施方案问卷调查 发送短信5条"));
		scences.add(new Scence("短信", 50, "通知朋友手机换号，发送短信50条"));
		scences.add(new Scence("上网", 1 * 1024, "和女友微信视频聊天   使用流量1G"));
		scences.add(new Scence("上网", 2 * 1024, "晚上手机在线看韩剧，不留神睡着啦！ 使用流量 2G"));
	}

	/**
	 * 用户数据初始化
	 */
	public void initData() {
		// 初始化三张手机卡,并添加进集合
		MobileCard card1 = new MobileCard("13979387057", "江1", "1234", new TalkPackage(), 68, 32);// 话痨套餐
		MobileCard card2 = new MobileCard("13979387058", "龙2", "12345", new NetPackage(), 78, 22);// 网虫套餐
		MobileCard card3 = new MobileCard("13979387059", "彬3", "123456", new SuperPackage(), 88, 12);// 超人套餐
		cards.put("13979387057", card1);
		cards.put("13979387058", card2);
		cards.put("13979387059", card3);
		// 消费记录初始化
		ConsumInfo info = new ConsumInfo("13979387057", "通话", 200);
		list.add(info);
		consumInfos.put("13979387057", list);
	}

	/**
	 * 根据卡号和密码，该卡是否可登录（-另一种方法可选-）
	 * 
	 * @param number
	 * @param passWord
	 * @return
	 */
	public boolean isExistCard(String number, String passWord) {
		boolean flage = false;
		Set<String> keys = cards.keySet();// 获取键的集合
		Iterator<String> ite = keys.iterator();// 迭代器

		while (ite.hasNext()) {
			String key = ite.next();// 获取所有的元素
			MobileCard card = cards.get(number);
			if (key.equals(number) && card.getPassworld().equals(passWord)) {
				flage = true;
			}
		}
		return flage;
	}

	/**
	 * 根据卡号，该卡是否可注册
	 * 
	 * @param number
	 * @return
	 */
	public boolean isExistCard(String number) {

		return false;
	}

	/**
	 * 登录
	 * 
	 * @throws IOException
	 */
	public void loginSoso() throws IOException {

		System.out.print("请输入手机卡号：");
		String yourNumber = sc.next();// 用户手机号
		System.out.print("请输入密码：");
		String yourPassWord = sc.next();// 用户密码
		// 判断手机号在集合中是否存在
		// 判断密码 通过键值 K-V
		boolean isExit = isExistCard(yourNumber, yourPassWord);
		if (isExit == true) {
			System.out.println("登陆成功！！！");
			// 手机号，密码正确，进入二级菜单
			boolean isCount = true;
			do {
				System.out.println();
				System.out.println("*****嗖嗖移动用户菜单*****");
				System.out.print("1.本月账单查询 \n2.套餐余量查询 \n3.打印消费详单 \n4.套餐变更 \n5.办理退网 \n请选择(输入1~5选择功能，其他键返回上一级)：");
				// 选择序号
				int erjicaidan = sc.nextInt();

				switch (erjicaidan) {
				case 1:// 本月账单查询
					showAmountDetail(yourNumber);
					break;
				case 2:// 套餐余量查询
					showRemainDetail(yourNumber);
					break;
				case 3:// 打印消费详单
					printConsumInfo(yourNumber);
					break;
				case 4:// 套餐变更
					changingPack(yourNumber);
					break;
				case 5:// 办理退网
					delCard(yourNumber);
					break;
				default:// 退出二级菜单
					isCount = false;
					break;
				}
			} while (isCount);
		} else {
			System.out.println("登录失败，请检查手机号码和密码是否正确！！！");
		}

	}

	/**
	 * 随机生成手机号
	 */
	public String createNumber() {
		Random random = new Random();
		int temp = 0;// 接收随机数
		String number = "139";// 拼接手机号
		boolean flage = false;// 默认在数据中不存在

		do {
			do {
				temp = random.nextInt(100000000);
			} while (temp < 10000000);// 内循环得到一个随机号码
			number = number + temp;
			if (cards.get(number) != null) {
				flage = true;// 继续循环获取随机数
			}
		} while (flage);// 外循环去处理是否存在
		return number;
	}

	/**
	 * 生成指定个数卡号列表
	 * 
	 * @param count
	 * @return
	 */
	public String[] getNewNumbers(int count) {

		String[] nums = new String[count];
		int num = nums.length;// 数组长度
		for (int i = 0; i < num; i++) {// count代表循环count次，产生count个随机号码
			nums[i] = createNumber();
		}
		return nums;
	}

	/**
	 * 注册新卡
	 */
	public void addCard() {

		System.out.println("*****可选择的卡号*****");
		// 接收返回的电话号码
		String[] cardRandom = getNewNumbers(9);
		// 一行显示三个
		// 遍历数组
		for (int i = 0; i < cardRandom.length; i++) {
			System.out.print((i + 1) + "、" + cardRandom[i] + "\t");// 下标被加了1
			// 保证每一行只显示三个号码
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
		System.out.print("请选择卡号（输入1~9的序号）：");
		int chooseCardId = sc.nextInt();
		card.setCardNumber(cardRandom[chooseCardId - 1]);// 对手机卡类：号码进行赋值
		// 选择套餐
		System.out.print("1.话唠套餐  2.网虫套餐  3.超人套餐，  请选择套餐(输入序号)：");
		int choosePackage = sc.nextInt();// 套餐选择
		System.out.print("请输入姓名：");
		String cardName = sc.next();// 姓名记录
		card.setUserName(cardName);
		System.out.print("请输入密码：");
		String passWord = sc.next();// 密码记录
		card.setPassworld(passWord);
		System.out.print("请输入预存话费：");
		double pay = sc.nextDouble();
		// 根据选择的套餐实例对象
		switch (choosePackage) {
		case 1:
			servicePackage = new TalkPackage();
			break;
		case 2:
			servicePackage = new NetPackage();
			break;
		case 3:
			servicePackage = new SuperPackage();
			break;
		default:
			System.out.println("输入有误！");
			break;
		}
		//// 所属套餐赋值
		card.setSerPackage(servicePackage);
		// 当月消费金额
		card.setConsumAmount(servicePackage.price);
		// 余额
		card.setMoney(pay - card.getConsumAmount());
		// 判断余额是否支持套餐扣费（如果不够扣费从新充值）
		while (card.getMoney() < 0) {
			System.out.print("余额不足请充值：");
			pay = sc.nextDouble();
			card.setMoney(pay - card.getConsumAmount());
		}
		// 存入集合-Map//便显示卡的信息showMeg()
		cards.put(card.getCardNumber(), card);
		if (cards.containsKey(card.getCardNumber())) {
			// 显示套餐信息
			card.showMeg();
			// 提示注册成功
			System.out.println("注册成功！！！");
		} else {
			System.out.println("注册失败，请重新注册！");
		}
	}

	/**
	 * 本月账单查询
	 * 
	 * @param number
	 */
	public void showAmountDetail(String yourNumber) {
		StringBuffer meg = new StringBuffer();
		card = cards.get(yourNumber);
		meg.append("\n*****本月账单查询*****\n");
		meg.append("你的卡号是：" + card.getCardNumber() + ",当月账单：\n");
		meg.append("套餐资费：" + servicePackage.price + "元");
		meg.append("合计：" + dataFormat(cards.get(yourNumber).getConsumAmount()) + "元\n");
		meg.append("账户余额：" + dataFormat(cards.get(yourNumber).getMoney()) + "元");
		System.out.println(meg);
	}

	/**
	 * 转格式---例如：78.00
	 * 
	 * @param consumAmount
	 * @return
	 */
	private String dataFormat(double data) {
		// DecimalFormat使任何地区的数字解析和格式化，包括支持西方，阿拉伯语和印度数字
		DecimalFormat format = new DecimalFormat("##.00");
		return format.format(data);
	}

	/**
	 * 套餐余量查询
	 * 
	 * @param number
	 */
	public void showRemainDetail(String yourNumber) {
		StringBuffer meg = new StringBuffer();
		// 要查询的卡
		int remainTalkTime;// 通话时长
		int remainSmsCount;// 短信条数
		int remainFlow;// 上网流量
		meg.append("\n*****套餐余量查询*****\n");
		// 由卡号获取集合里的键对应的值（套餐类型）
		meg.append("你的卡号是：" + yourNumber + ",套餐剩余：\n");
		servicePackage = cards.get(yourNumber).getSerPackage();// 获取所属套餐--方便转不同的实例
		if (servicePackage instanceof TalkPackage) {
			// 话唠套餐
			TalkPackage tp = (TalkPackage) servicePackage;
			// 套餐带的通话量（套餐对应的实例对象tp.getTalkTime()获取），消费的量（由键对应的手机卡对象cards.get(yourNumber).getRealTalkTime()来获取）
			remainTalkTime = tp.getTalkTime() > cards.get(yourNumber).getRealTalkTime()
					? (tp.getTalkTime() - cards.get(yourNumber).getRealTalkTime())
					: 0;
			meg.append("通话时长：" + remainTalkTime + "分钟\n");
			// 套餐带的短息量（套餐对应的实例对象tp.tp.getSmsCount()获取），消费的量（由键对应的手机卡对象cards.get(yourNumber).getRealSMSCount()来获取）
			remainSmsCount = tp.getSmsCount() > cards.get(yourNumber).getRealSMSCount()
					? (tp.getSmsCount() - cards.get(yourNumber).getRealSMSCount())
					: 0;
			meg.append("短信条数：" + remainSmsCount + "条");

		} else if (servicePackage instanceof NetPackage) {
			// 网虫套餐
			NetPackage np = (NetPackage) servicePackage;
			// 套餐带的通话量（套餐对应的实例对象np.getFlow()获取），消费的量（由键对应的手机卡对象cards.get(yourNumber).getRealFlow()来获取）
			remainFlow = np.getFlow() > cards.get(yourNumber).getRealFlow()
					? (np.getFlow() - cards.get(yourNumber).getRealFlow())
					: 0;
			meg.append("剩余流量：" + remainFlow + "MB");

		} else {
			// 超人套餐
			SuperPackage sp = (SuperPackage) servicePackage;

			// 套餐带的通话量（套餐对应的实例对象sp.getTalkTime()获取），消费的量（由键对应的手机卡对象cards.get(yourNumber).getRealTalkTime()来获取）
			remainTalkTime = sp.getTalkTime() > cards.get(yourNumber).getRealTalkTime()
					? (sp.getTalkTime() - cards.get(yourNumber).getRealTalkTime())
					: 0;
			meg.append("通话时长：" + remainTalkTime + "分钟\n");

			// 套餐带的短息量（套餐对应的实例对象sp.getSmsCount()获取），消费的量（由键对应的手机卡对象cards.get(yourNumber).getRealSMSCount()来获取）
			remainSmsCount = sp.getSmsCount() > cards.get(yourNumber).getRealSMSCount()
					? (sp.getSmsCount() - cards.get(yourNumber).getRealSMSCount())
					: 0;
			meg.append("短信条数：" + remainSmsCount + "条\n");

			// 套餐带的通话量（套餐对应的实例对象sp.getFlow()获取），消费的量（由键对应的手机卡对象cards.get(yourNumber).getRealFlow()来获取）
			remainFlow = sp.getFlow() > cards.get(yourNumber).getRealFlow()
					? (sp.getFlow() - cards.get(yourNumber).getRealFlow())
					: 0;
			meg.append("剩余流量：" + remainFlow + "MB");
		}
		System.out.println(meg);
	}

	/**
	 * 打印消费详单
	 * 
	 * @param number
	 * @throws IOException
	 */
	public void printConsumInfo(String yourNumber) throws IOException {

		Set<String> numbles = consumInfos.keySet();// 获取所有的消费记录map集合中的号码
		// 遍历set集合，判断次卡号是否存在消费记录
		Iterator<String> it = numbles.iterator();

		// 判断消费列表中是否有此卡的消费记录
		boolean flag = false;// false不存在 // 默认没有记录
		while (it.hasNext()) {
			String numbleKey = it.next();
			if (numbleKey.equals(yourNumber) && consumInfos.get(yourNumber).size() != 0) {
				flag = true;
			}
		}
		// 如果存在此卡消费记录，则打印，不存在则说明
		if (flag) {
			StringBuffer bf = new StringBuffer("*********" + yourNumber + "消费记录" + "*********\n");
			bf.append("序号\t类型\t数据(通话（条）/上网（MB）/短信（条）)\n");
			List<ConsumInfo> infos = consumInfos.get(yourNumber);
			for (int i = 0; i < infos.size(); i++) {
				ConsumInfo info = infos.get(i);
				bf.append((i + 1) + ".\t" + info.getType() + "\t" + info.getConsumData() + "\n");
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter("消费记录.txt"));
			bw.write(bf.toString());
			bw.flush();// 刷新
			System.out.println("消费记录打印完毕！！！");
			bw.close();
		} else {
			System.out.println("暂无此卡消费记录！！！");
		}
	}

	/**
	 * 套餐变更
	 * 
	 * @param number
	 * @param packNum
	 */
	public void changingPack(String yourNumber) {
		// boolean isCoreact = true;// 标记，套餐是否正确变更
		System.out.print("1.话唠套餐  2.网虫套餐  3.超人套餐，  请重新选择套餐(输入序号)：");
		int optionrevie = sc.nextInt();
		switch (optionrevie) {
		case 1:
			servicePackage = new TalkPackage();
			if (cards.get(yourNumber).getSerPackage() instanceof TalkPackage) {
				System.out.println("您已是此套餐，无需变更！");
			} else {
				cards.get(yourNumber).setSerPackage(new TalkPackage());
				System.out.println("套餐更改成功！");
			}
			break;
		case 2:
			servicePackage = new NetPackage();
			if (cards.get(yourNumber).getSerPackage() instanceof NetPackage) {
				System.out.println("您已是此套餐，无需变更！");
			} else {
				cards.get(yourNumber).setSerPackage(new NetPackage());
				System.out.println("套餐更改成功！");
			}
			break;
		case 3:
			servicePackage = new SuperPackage();
			if (cards.get(yourNumber).getSerPackage() instanceof SuperPackage) {
				System.out.println("您已是此套餐，无需变更！");
			} else {
				cards.get(yourNumber).setSerPackage(new SuperPackage());
				System.out.println("套餐更改成功！");
			}
			break;
		default:
			System.out.println("请输入正确的序号！");
			break;
		}
	}

	/**
	 * 办理退网
	 */
	public void delCard(String yourNumber) {
		// 加个判断防止用户手误输入错误
		System.out.print("您确定注销此手机号码吗？Y/N:");
		String chouseyes = sc.next();
		if (chouseyes.equalsIgnoreCase("Y")) {
			cards.remove(yourNumber);
			System.out.println("您已成功注销该手机号！");
		}

	}

	/**
	 * 添加消费记录
	 * 
	 * @param number
	 * @param info
	 */
	public void addConsumInfo(String number, ConsumInfo info) {

	}

	/**
	 * 使用嗖嗖
	 * 
	 * @param number
	 */
	public void useSoso() {
		System.out.print("请输入手机号：");
		String yourNumber = sc.next();
		System.out.print("请输入密码：");
		String yourPassWord = sc.next();
		boolean flage = isExistCard(yourNumber, yourPassWord);
		if (flage == true) {
			card = cards.get(yourNumber);// 获取手机卡号所对应的手机卡类的信息（对象）
			ServicePackage pack = card.getSerPackage();// 获取套餐类型
			Random random = new Random();// 创建随机数对象
			int chooseSence = 0;// 接收随机数
			int temp = 0;// 记录每个场景中的实际消费
			boolean iscontinued = true;// 停下
			do {
				chooseSence = random.nextInt(6);// 随机生成0-5的数字
				Scence scence = scences.get(chooseSence);// 返回索引位置的元素
				switch (chooseSence) {
				case 0:
				case 1:
					// 判断卡所属的套餐是否有打电话的功能
					if (pack instanceof CallService) {
						// 如果该卡套餐支持通话功能
						// 执行通话方法
						System.out.println(scence.getDescription());// 输出描述
						CallService callService = (CallService) pack;
						try {
							temp = callService.call(scence.getData(), card);// 场景消费数据-手机卡对象
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// 添加消费记录
						list.add(new ConsumInfo(yourNumber, scence.getType(), temp));
						iscontinued = false;
						break;// 退出
					} else {
						// 如果该卡套餐不支持通话功能，则重新生成随机数选择其他场景
						continue;
					}

				case 2:
				case 3:

					// 如果该卡套餐支持短信功能
					if (pack instanceof SendService) {
						// 如果该卡套餐支持短信功能
						// 执行通话方法
						System.out.println(scence.getDescription());// 输出描述
						SendService sendService = (SendService) pack;
						try {
							temp = sendService.send(scence.getData(), card);// 场景消费数据-手机卡对象
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// 添加消费记录
						list.add(new ConsumInfo(yourNumber, scence.getType(), temp));
						iscontinued = false;
						break;// 退出
					} else {
						// 如果该卡套餐不支持通话功能，则重新生成随机数选择其他场景
						continue;
					}

				case 4:
				case 5:

					// 如果该卡套餐支持上网功能
					if (pack instanceof NetService) {
						// 如果该卡套餐支持短信功能
						// 执行通话方法
						System.out.println(scence.getDescription());// 输出描述
						NetService netService = (NetService) pack;
						try {
							temp = netService.netPlay(scence.getData(), card);// 场景消费数据-手机卡对象
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						// 添加消费记录
						list.add(new ConsumInfo(yourNumber, scence.getType(), temp));
						iscontinued = false;
						break;// 退出
					} else {
						// 如果该卡套餐不支持通话功能，则重新生成随机数选择其他场景
						continue;
					}
				}
				System.out.println("添加一条消费记录!");
				consumInfos.put(yourNumber, list);
			} while (iscontinued);
		} else {
			System.out.println("输入错误，请检查手机号码和密码！！！");
		}
	}

	/**
	 * 资费说明
	 * 
	 * @throws FileNotFoundException
	 */

	public void showDescription() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("资费说明.txt"), "UTF-8"));
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 话费充值
	 * 
	 * @param number
	 * @param money
	 */
	// public void chargeMoney(String number, double money) {}

	public void addPayMoney() {
		System.out.print("请输入您要充值的手机号码：");
		String yourNumber = sc.next();
		System.out.print("请输入您要充值手机号码的密码：");
		String yourPassWord = sc.next();
		if (cards.containsKey(yourNumber)) {
			if (cards.get(yourNumber).getPassworld().equals(yourPassWord)) {
				System.out.print("请输入您要充值的金额：");
				double payMoney = sc.nextDouble();
				cards.get(yourNumber).setMoney(cards.get(yourNumber).getMoney() + payMoney);
				System.out.println("话费充值成功，您当前话费余额" + cards.get(yourNumber).getMoney() + "元");
			} else {
				System.out.println("密码输入错误！");
			}
		} else {
			System.out.println("对不起，您输入的信息有误，无法登录！");
		}

	}

}
