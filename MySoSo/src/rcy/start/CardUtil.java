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
 * ������
 * 
 * @author Administrator
 *
 */
public class CardUtil {

	private static final ServicePackage TalkPackage = null;
	private static final ServicePackage NetPackage = null;
	private static final ServicePackage SuperPackage = null;

	// map���ϴ��濨����Ϣ����ͨ�����Ų鵽��Ӧ����������Ϣ
	/**
	 * ����
	 */
	Map<String, MobileCard> cards = new HashMap<String, MobileCard>();
	// ���п��ŵ����Ѽ�¼�б�
	/**
	 * ���ŵ����Ѽ�¼�б�
	 */
	Map<String, List<ConsumInfo>> consumInfos = new HashMap<String, List<ConsumInfo>>();
	List<ConsumInfo> list = new ArrayList<ConsumInfo>();
	// ���泡���б�
	/**
	 * �����б�
	 */
	List<Scence> scences = new ArrayList<Scence>();

	// �����ֻ�������--�������
	/**
	 * �ֻ�������
	 */
	MobileCard card = new MobileCard();
	// �����ײͷ������
	/**
	 * �ײͷ������
	 */
	ServicePackage servicePackage = null;
	Scanner sc = new Scanner(System.in);

	/**
	 * ʹ�ó�����ʼ��
	 */
	public void initScence() {
		scences.add(new Scence("ͨ��", 90, "�ʺ�ͻ���˭֪������Ѳ� ͨ��90����"));
		scences.add(new Scence("ͨ��", 30, "ѯ����������״�� ����ͨ��30����"));
		scences.add(new Scence("����", 5, "���뻷������ʵʩ�����ʾ���� ���Ͷ���5��"));
		scences.add(new Scence("����", 50, "֪ͨ�����ֻ����ţ����Ͷ���50��"));
		scences.add(new Scence("����", 1 * 1024, "��Ů��΢����Ƶ����   ʹ������1G"));
		scences.add(new Scence("����", 2 * 1024, "�����ֻ����߿����磬������˯������ ʹ������ 2G"));
	}

	/**
	 * �û����ݳ�ʼ��
	 */
	public void initData() {
		// ��ʼ�������ֻ���,����ӽ�����
		MobileCard card1 = new MobileCard("13979387057", "��1", "1234", new TalkPackage(), 68, 32);// �����ײ�
		MobileCard card2 = new MobileCard("13979387058", "��2", "12345", new NetPackage(), 78, 22);// �����ײ�
		MobileCard card3 = new MobileCard("13979387059", "��3", "123456", new SuperPackage(), 88, 12);// �����ײ�
		cards.put("13979387057", card1);
		cards.put("13979387058", card2);
		cards.put("13979387059", card3);
		// ���Ѽ�¼��ʼ��
		ConsumInfo info = new ConsumInfo("13979387057", "ͨ��", 200);
		list.add(info);
		consumInfos.put("13979387057", list);
	}

	/**
	 * ���ݿ��ź����룬�ÿ��Ƿ�ɵ�¼��-��һ�ַ�����ѡ-��
	 * 
	 * @param number
	 * @param passWord
	 * @return
	 */
	public boolean isExistCard(String number, String passWord) {
		boolean flage = false;
		Set<String> keys = cards.keySet();// ��ȡ���ļ���
		Iterator<String> ite = keys.iterator();// ������

		while (ite.hasNext()) {
			String key = ite.next();// ��ȡ���е�Ԫ��
			MobileCard card = cards.get(number);
			if (key.equals(number) && card.getPassworld().equals(passWord)) {
				flage = true;
			}
		}
		return flage;
	}

	/**
	 * ���ݿ��ţ��ÿ��Ƿ��ע��
	 * 
	 * @param number
	 * @return
	 */
	public boolean isExistCard(String number) {

		return false;
	}

	/**
	 * ��¼
	 * 
	 * @throws IOException
	 */
	public void loginSoso() throws IOException {

		System.out.print("�������ֻ����ţ�");
		String yourNumber = sc.next();// �û��ֻ���
		System.out.print("���������룺");
		String yourPassWord = sc.next();// �û�����
		// �ж��ֻ����ڼ������Ƿ����
		// �ж����� ͨ����ֵ K-V
		boolean isExit = isExistCard(yourNumber, yourPassWord);
		if (isExit == true) {
			System.out.println("��½�ɹ�������");
			// �ֻ��ţ�������ȷ����������˵�
			boolean isCount = true;
			do {
				System.out.println();
				System.out.println("*****���ƶ��û��˵�*****");
				System.out.print("1.�����˵���ѯ \n2.�ײ�������ѯ \n3.��ӡ�����굥 \n4.�ײͱ�� \n5.�������� \n��ѡ��(����1~5ѡ���ܣ�������������һ��)��");
				// ѡ�����
				int erjicaidan = sc.nextInt();

				switch (erjicaidan) {
				case 1:// �����˵���ѯ
					showAmountDetail(yourNumber);
					break;
				case 2:// �ײ�������ѯ
					showRemainDetail(yourNumber);
					break;
				case 3:// ��ӡ�����굥
					printConsumInfo(yourNumber);
					break;
				case 4:// �ײͱ��
					changingPack(yourNumber);
					break;
				case 5:// ��������
					delCard(yourNumber);
					break;
				default:// �˳������˵�
					isCount = false;
					break;
				}
			} while (isCount);
		} else {
			System.out.println("��¼ʧ�ܣ������ֻ�����������Ƿ���ȷ������");
		}

	}

	/**
	 * ��������ֻ���
	 */
	public String createNumber() {
		Random random = new Random();
		int temp = 0;// ���������
		String number = "139";// ƴ���ֻ���
		boolean flage = false;// Ĭ���������в�����

		do {
			do {
				temp = random.nextInt(100000000);
			} while (temp < 10000000);// ��ѭ���õ�һ���������
			number = number + temp;
			if (cards.get(number) != null) {
				flage = true;// ����ѭ����ȡ�����
			}
		} while (flage);// ��ѭ��ȥ�����Ƿ����
		return number;
	}

	/**
	 * ����ָ�����������б�
	 * 
	 * @param count
	 * @return
	 */
	public String[] getNewNumbers(int count) {

		String[] nums = new String[count];
		int num = nums.length;// ���鳤��
		for (int i = 0; i < num; i++) {// count����ѭ��count�Σ�����count���������
			nums[i] = createNumber();
		}
		return nums;
	}

	/**
	 * ע���¿�
	 */
	public void addCard() {

		System.out.println("*****��ѡ��Ŀ���*****");
		// ���շ��صĵ绰����
		String[] cardRandom = getNewNumbers(9);
		// һ����ʾ����
		// ��������
		for (int i = 0; i < cardRandom.length; i++) {
			System.out.print((i + 1) + "��" + cardRandom[i] + "\t");// �±걻����1
			// ��֤ÿһ��ֻ��ʾ��������
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
		System.out.print("��ѡ�񿨺ţ�����1~9����ţ���");
		int chooseCardId = sc.nextInt();
		card.setCardNumber(cardRandom[chooseCardId - 1]);// ���ֻ����ࣺ������и�ֵ
		// ѡ���ײ�
		System.out.print("1.�����ײ�  2.�����ײ�  3.�����ײͣ�  ��ѡ���ײ�(�������)��");
		int choosePackage = sc.nextInt();// �ײ�ѡ��
		System.out.print("������������");
		String cardName = sc.next();// ������¼
		card.setUserName(cardName);
		System.out.print("���������룺");
		String passWord = sc.next();// �����¼
		card.setPassworld(passWord);
		System.out.print("������Ԥ�滰�ѣ�");
		double pay = sc.nextDouble();
		// ����ѡ����ײ�ʵ������
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
			System.out.println("��������");
			break;
		}
		//// �����ײ͸�ֵ
		card.setSerPackage(servicePackage);
		// �������ѽ��
		card.setConsumAmount(servicePackage.price);
		// ���
		card.setMoney(pay - card.getConsumAmount());
		// �ж�����Ƿ�֧���ײͿ۷ѣ���������۷Ѵ��³�ֵ��
		while (card.getMoney() < 0) {
			System.out.print("�������ֵ��");
			pay = sc.nextDouble();
			card.setMoney(pay - card.getConsumAmount());
		}
		// ���뼯��-Map//����ʾ������ϢshowMeg()
		cards.put(card.getCardNumber(), card);
		if (cards.containsKey(card.getCardNumber())) {
			// ��ʾ�ײ���Ϣ
			card.showMeg();
			// ��ʾע��ɹ�
			System.out.println("ע��ɹ�������");
		} else {
			System.out.println("ע��ʧ�ܣ�������ע�ᣡ");
		}
	}

	/**
	 * �����˵���ѯ
	 * 
	 * @param number
	 */
	public void showAmountDetail(String yourNumber) {
		StringBuffer meg = new StringBuffer();
		card = cards.get(yourNumber);
		meg.append("\n*****�����˵���ѯ*****\n");
		meg.append("��Ŀ����ǣ�" + card.getCardNumber() + ",�����˵���\n");
		meg.append("�ײ��ʷѣ�" + servicePackage.price + "Ԫ");
		meg.append("�ϼƣ�" + dataFormat(cards.get(yourNumber).getConsumAmount()) + "Ԫ\n");
		meg.append("�˻���" + dataFormat(cards.get(yourNumber).getMoney()) + "Ԫ");
		System.out.println(meg);
	}

	/**
	 * ת��ʽ---���磺78.00
	 * 
	 * @param consumAmount
	 * @return
	 */
	private String dataFormat(double data) {
		// DecimalFormatʹ�κε��������ֽ����͸�ʽ��������֧�����������������ӡ������
		DecimalFormat format = new DecimalFormat("##.00");
		return format.format(data);
	}

	/**
	 * �ײ�������ѯ
	 * 
	 * @param number
	 */
	public void showRemainDetail(String yourNumber) {
		StringBuffer meg = new StringBuffer();
		// Ҫ��ѯ�Ŀ�
		int remainTalkTime;// ͨ��ʱ��
		int remainSmsCount;// ��������
		int remainFlow;// ��������
		meg.append("\n*****�ײ�������ѯ*****\n");
		// �ɿ��Ż�ȡ������ļ���Ӧ��ֵ���ײ����ͣ�
		meg.append("��Ŀ����ǣ�" + yourNumber + ",�ײ�ʣ�ࣺ\n");
		servicePackage = cards.get(yourNumber).getSerPackage();// ��ȡ�����ײ�--����ת��ͬ��ʵ��
		if (servicePackage instanceof TalkPackage) {
			// �����ײ�
			TalkPackage tp = (TalkPackage) servicePackage;
			// �ײʹ���ͨ�������ײͶ�Ӧ��ʵ������tp.getTalkTime()��ȡ�������ѵ������ɼ���Ӧ���ֻ�������cards.get(yourNumber).getRealTalkTime()����ȡ��
			remainTalkTime = tp.getTalkTime() > cards.get(yourNumber).getRealTalkTime()
					? (tp.getTalkTime() - cards.get(yourNumber).getRealTalkTime())
					: 0;
			meg.append("ͨ��ʱ����" + remainTalkTime + "����\n");
			// �ײʹ��Ķ�Ϣ�����ײͶ�Ӧ��ʵ������tp.tp.getSmsCount()��ȡ�������ѵ������ɼ���Ӧ���ֻ�������cards.get(yourNumber).getRealSMSCount()����ȡ��
			remainSmsCount = tp.getSmsCount() > cards.get(yourNumber).getRealSMSCount()
					? (tp.getSmsCount() - cards.get(yourNumber).getRealSMSCount())
					: 0;
			meg.append("����������" + remainSmsCount + "��");

		} else if (servicePackage instanceof NetPackage) {
			// �����ײ�
			NetPackage np = (NetPackage) servicePackage;
			// �ײʹ���ͨ�������ײͶ�Ӧ��ʵ������np.getFlow()��ȡ�������ѵ������ɼ���Ӧ���ֻ�������cards.get(yourNumber).getRealFlow()����ȡ��
			remainFlow = np.getFlow() > cards.get(yourNumber).getRealFlow()
					? (np.getFlow() - cards.get(yourNumber).getRealFlow())
					: 0;
			meg.append("ʣ��������" + remainFlow + "MB");

		} else {
			// �����ײ�
			SuperPackage sp = (SuperPackage) servicePackage;

			// �ײʹ���ͨ�������ײͶ�Ӧ��ʵ������sp.getTalkTime()��ȡ�������ѵ������ɼ���Ӧ���ֻ�������cards.get(yourNumber).getRealTalkTime()����ȡ��
			remainTalkTime = sp.getTalkTime() > cards.get(yourNumber).getRealTalkTime()
					? (sp.getTalkTime() - cards.get(yourNumber).getRealTalkTime())
					: 0;
			meg.append("ͨ��ʱ����" + remainTalkTime + "����\n");

			// �ײʹ��Ķ�Ϣ�����ײͶ�Ӧ��ʵ������sp.getSmsCount()��ȡ�������ѵ������ɼ���Ӧ���ֻ�������cards.get(yourNumber).getRealSMSCount()����ȡ��
			remainSmsCount = sp.getSmsCount() > cards.get(yourNumber).getRealSMSCount()
					? (sp.getSmsCount() - cards.get(yourNumber).getRealSMSCount())
					: 0;
			meg.append("����������" + remainSmsCount + "��\n");

			// �ײʹ���ͨ�������ײͶ�Ӧ��ʵ������sp.getFlow()��ȡ�������ѵ������ɼ���Ӧ���ֻ�������cards.get(yourNumber).getRealFlow()����ȡ��
			remainFlow = sp.getFlow() > cards.get(yourNumber).getRealFlow()
					? (sp.getFlow() - cards.get(yourNumber).getRealFlow())
					: 0;
			meg.append("ʣ��������" + remainFlow + "MB");
		}
		System.out.println(meg);
	}

	/**
	 * ��ӡ�����굥
	 * 
	 * @param number
	 * @throws IOException
	 */
	public void printConsumInfo(String yourNumber) throws IOException {

		Set<String> numbles = consumInfos.keySet();// ��ȡ���е����Ѽ�¼map�����еĺ���
		// ����set���ϣ��жϴο����Ƿ�������Ѽ�¼
		Iterator<String> it = numbles.iterator();

		// �ж������б����Ƿ��д˿������Ѽ�¼
		boolean flag = false;// false������ // Ĭ��û�м�¼
		while (it.hasNext()) {
			String numbleKey = it.next();
			if (numbleKey.equals(yourNumber) && consumInfos.get(yourNumber).size() != 0) {
				flag = true;
			}
		}
		// ������ڴ˿����Ѽ�¼�����ӡ����������˵��
		if (flag) {
			StringBuffer bf = new StringBuffer("*********" + yourNumber + "���Ѽ�¼" + "*********\n");
			bf.append("���\t����\t����(ͨ��������/������MB��/���ţ�����)\n");
			List<ConsumInfo> infos = consumInfos.get(yourNumber);
			for (int i = 0; i < infos.size(); i++) {
				ConsumInfo info = infos.get(i);
				bf.append((i + 1) + ".\t" + info.getType() + "\t" + info.getConsumData() + "\n");
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter("���Ѽ�¼.txt"));
			bw.write(bf.toString());
			bw.flush();// ˢ��
			System.out.println("���Ѽ�¼��ӡ��ϣ�����");
			bw.close();
		} else {
			System.out.println("���޴˿����Ѽ�¼������");
		}
	}

	/**
	 * �ײͱ��
	 * 
	 * @param number
	 * @param packNum
	 */
	public void changingPack(String yourNumber) {
		// boolean isCoreact = true;// ��ǣ��ײ��Ƿ���ȷ���
		System.out.print("1.�����ײ�  2.�����ײ�  3.�����ײͣ�  ������ѡ���ײ�(�������)��");
		int optionrevie = sc.nextInt();
		switch (optionrevie) {
		case 1:
			servicePackage = new TalkPackage();
			if (cards.get(yourNumber).getSerPackage() instanceof TalkPackage) {
				System.out.println("�����Ǵ��ײͣ���������");
			} else {
				cards.get(yourNumber).setSerPackage(new TalkPackage());
				System.out.println("�ײ͸��ĳɹ���");
			}
			break;
		case 2:
			servicePackage = new NetPackage();
			if (cards.get(yourNumber).getSerPackage() instanceof NetPackage) {
				System.out.println("�����Ǵ��ײͣ���������");
			} else {
				cards.get(yourNumber).setSerPackage(new NetPackage());
				System.out.println("�ײ͸��ĳɹ���");
			}
			break;
		case 3:
			servicePackage = new SuperPackage();
			if (cards.get(yourNumber).getSerPackage() instanceof SuperPackage) {
				System.out.println("�����Ǵ��ײͣ���������");
			} else {
				cards.get(yourNumber).setSerPackage(new SuperPackage());
				System.out.println("�ײ͸��ĳɹ���");
			}
			break;
		default:
			System.out.println("��������ȷ����ţ�");
			break;
		}
	}

	/**
	 * ��������
	 */
	public void delCard(String yourNumber) {
		// �Ӹ��жϷ�ֹ�û������������
		System.out.print("��ȷ��ע�����ֻ�������Y/N:");
		String chouseyes = sc.next();
		if (chouseyes.equalsIgnoreCase("Y")) {
			cards.remove(yourNumber);
			System.out.println("���ѳɹ�ע�����ֻ��ţ�");
		}

	}

	/**
	 * ������Ѽ�¼
	 * 
	 * @param number
	 * @param info
	 */
	public void addConsumInfo(String number, ConsumInfo info) {

	}

	/**
	 * ʹ����
	 * 
	 * @param number
	 */
	public void useSoso() {
		System.out.print("�������ֻ��ţ�");
		String yourNumber = sc.next();
		System.out.print("���������룺");
		String yourPassWord = sc.next();
		boolean flage = isExistCard(yourNumber, yourPassWord);
		if (flage == true) {
			card = cards.get(yourNumber);// ��ȡ�ֻ���������Ӧ���ֻ��������Ϣ������
			ServicePackage pack = card.getSerPackage();// ��ȡ�ײ�����
			Random random = new Random();// �������������
			int chooseSence = 0;// ���������
			int temp = 0;// ��¼ÿ�������е�ʵ������
			boolean iscontinued = true;// ͣ��
			do {
				chooseSence = random.nextInt(6);// �������0-5������
				Scence scence = scences.get(chooseSence);// ��������λ�õ�Ԫ��
				switch (chooseSence) {
				case 0:
				case 1:
					// �жϿ��������ײ��Ƿ��д�绰�Ĺ���
					if (pack instanceof CallService) {
						// ����ÿ��ײ�֧��ͨ������
						// ִ��ͨ������
						System.out.println(scence.getDescription());// �������
						CallService callService = (CallService) pack;
						try {
							temp = callService.call(scence.getData(), card);// ������������-�ֻ�������
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// ������Ѽ�¼
						list.add(new ConsumInfo(yourNumber, scence.getType(), temp));
						iscontinued = false;
						break;// �˳�
					} else {
						// ����ÿ��ײͲ�֧��ͨ�����ܣ����������������ѡ����������
						continue;
					}

				case 2:
				case 3:

					// ����ÿ��ײ�֧�ֶ��Ź���
					if (pack instanceof SendService) {
						// ����ÿ��ײ�֧�ֶ��Ź���
						// ִ��ͨ������
						System.out.println(scence.getDescription());// �������
						SendService sendService = (SendService) pack;
						try {
							temp = sendService.send(scence.getData(), card);// ������������-�ֻ�������
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// ������Ѽ�¼
						list.add(new ConsumInfo(yourNumber, scence.getType(), temp));
						iscontinued = false;
						break;// �˳�
					} else {
						// ����ÿ��ײͲ�֧��ͨ�����ܣ����������������ѡ����������
						continue;
					}

				case 4:
				case 5:

					// ����ÿ��ײ�֧����������
					if (pack instanceof NetService) {
						// ����ÿ��ײ�֧�ֶ��Ź���
						// ִ��ͨ������
						System.out.println(scence.getDescription());// �������
						NetService netService = (NetService) pack;
						try {
							temp = netService.netPlay(scence.getData(), card);// ������������-�ֻ�������
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						// ������Ѽ�¼
						list.add(new ConsumInfo(yourNumber, scence.getType(), temp));
						iscontinued = false;
						break;// �˳�
					} else {
						// ����ÿ��ײͲ�֧��ͨ�����ܣ����������������ѡ����������
						continue;
					}
				}
				System.out.println("���һ�����Ѽ�¼!");
				consumInfos.put(yourNumber, list);
			} while (iscontinued);
		} else {
			System.out.println("������������ֻ���������룡����");
		}
	}

	/**
	 * �ʷ�˵��
	 * 
	 * @throws FileNotFoundException
	 */

	public void showDescription() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("�ʷ�˵��.txt"), "UTF-8"));
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
	 * ���ѳ�ֵ
	 * 
	 * @param number
	 * @param money
	 */
	// public void chargeMoney(String number, double money) {}

	public void addPayMoney() {
		System.out.print("��������Ҫ��ֵ���ֻ����룺");
		String yourNumber = sc.next();
		System.out.print("��������Ҫ��ֵ�ֻ���������룺");
		String yourPassWord = sc.next();
		if (cards.containsKey(yourNumber)) {
			if (cards.get(yourNumber).getPassworld().equals(yourPassWord)) {
				System.out.print("��������Ҫ��ֵ�Ľ�");
				double payMoney = sc.nextDouble();
				cards.get(yourNumber).setMoney(cards.get(yourNumber).getMoney() + payMoney);
				System.out.println("���ѳ�ֵ�ɹ�������ǰ�������" + cards.get(yourNumber).getMoney() + "Ԫ");
			} else {
				System.out.println("�����������");
			}
		} else {
			System.out.println("�Բ������������Ϣ�����޷���¼��");
		}

	}

}
