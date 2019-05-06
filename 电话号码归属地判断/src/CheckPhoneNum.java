/**
 * Demo class
 *
 * @author linliquan
 * @date 2019/4/20
 */
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

/**
 *  ���������ҵ---�绰��������ز�ѯ
 *  Ҫ�󣺾����Լ�д�ж�ϵͳ�����������ϵ绰�����ѯ�����ص�API�ӿ�
 *
 *  ��ϵͳ˵����1.�̶��绰�����ز�ѯ���ӱ���city.txt(300��������)�ļ���ȡ�����浽hashMap�У��ٽ���ѭ���жϡ�
 *              2.�ֻ������ز�ѯ�����ȱ����жϣ������жϲ��˾͵������Ͻӿ��жϡ�����Ϊ����û���ֻ��κŵ����ݣ�
 */
public class CheckPhoneNum extends JFrame {

	/**
	 * �������
	 */
	private JPanel contentPane;
	/**
	 * �绰�����
	 */
	private JTextField phoneField;

	public static void main(String[] args) {
//		CheckPhoneNum.readTxtFile("�绰����������ж�/city.txt");
		System.out.println(CheckPhoneNum.readTxtFile("�绰����������ж�/city.txt"));
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					CheckPhoneNum frame = new CheckPhoneNum();
					frame.setTitle("�ֻ���������ز�ѯϵͳ");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CheckPhoneNum() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		/**
		 * ���ô���λ�úʹ�С
		 */
		setBounds(500, 20, 900, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("ʹ��˵������ϵͳ�ɲ�ѯ�̶��绰�Ĺ����ء��ֻ�����Ĺ����غ���Ӫ�̡�");
		JLabel labe2 = new JLabel("<html><body>"
				+ "<br/> 1.�̶��绰��ѯ��"
				+ "<br/>��ʽ��2~4λ������+7λ��8λ�ĵ绰����(�С�-���ָ�����û�зָ�������)"
				+ "<br/>��0771-86225824��0771-8622582��010-65246622��01065246622"

				+ "<p></p>"
				+ "<p>2.�ֻ������ѯ��</p>"
				+ "<p>��ʽ������7~11λ���ֻ����룬�磺13457855034��1345785</p>"
				+ "<p></p>"
				+ "<p>3.���Ⱥ��롢���ú����ѯ��</p>"
				+ "<p>��ʽ���磺110��120��119��122��12315��10086��10000</p>"
				+ "<p></p>"
				+ "<p>ע�⣺</p>"
				+ "<p>1.�̶��绰�����ز�ѯ���ӱ���city.txt(300��������)�ļ���ȡ�����浽hashMap�У��ٽ���ѭ���жϡ�</p></body></html>");

		JLabel labe3 = new JLabel("������� ���Q164 ����Ȩ 201609601282");
		label.setBounds(10, 10, 700, 18);
		labe2.setBounds(50, 0, 700, 330);
		labe3.setBounds(250, 600, 700, 20);

		//���ñ�ǩ����
		label.setFont(new Font("����", 1, 16));
		labe2.setFont(new Font("����", 1, 16));
		labe3.setFont(new Font("����", 1, 20));
		labe3.setForeground(Color.MAGENTA);
		contentPane.add(label);
		contentPane.add(labe2);
		contentPane.add(labe3);

		/**
		 * ���ñ���ͼƬ
		 */
		ImageIcon img = new ImageIcon("�绰����������ж�/bg.jpg");
		//Ҫ���õı���ͼƬ
		JLabel imgLabel = new JLabel(img);
		//������ͼ���ڱ�ǩ�
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		//��������ǩ��ӵ�jfram��LayeredPane����
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		// ���ñ�����ǩ��λ��
		Container contain = this.getContentPane();
		// �����������Ϊ͸������LayeredPane����еı�����ʾ������
		((JPanel) contain).setOpaque(false);
		validate();  //ˢ��

		//�����ֻ�ͼ��
		Icon icon = new ImageIcon("�绰����������ж�/phone.png");
		JLabel label_2 = new JLabel("�绰�����ѯ");
		label_2.setBounds(50, 350, 300, 35);
		contentPane.add(label_2);
		label_2.setIcon(icon);

		//���������С��������ɫ
		label_2.setFont(new Font("����", 1, 30));//���ñ�ǩ����
		label_2.setForeground(Color.magenta);

		phoneField = new JTextField();
		phoneField.setFont(new Font("����", 1, 20));
		phoneField.setForeground(Color.blue);
		phoneField.setBounds(300, 350, 200, 35);
		contentPane.add(phoneField);

		JButton button = new JButton("��ѯ");
		button.setFont(new Font("����", 1, 16));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				do_button_actionPerformed(e);
			}
		});
		button.setBounds(550, 350, 100, 35);
		contentPane.add(button);
	}

	protected void do_button_actionPerformed(ActionEvent e) {
		String text = phoneField.getText();

		//������ĵ绰�ı�������֤
		String info = check(text);
		JOptionPane.showMessageDialog(null, info);

	}

	/**
	 *
	 * ��ȡcity.txt�ļ�
	 * @return
	 */

	/**
	 * ���ܣ�Java��ȡtxt�ļ�������
	 * ���裺1���Ȼ���ļ����
	 * 2������ļ��������������һ���ֽ���������Ҫ��������������ж�ȡ
	 * 3����ȡ������������Ҫ��ȡ�����ֽ���
	 * 4��һ��һ�е������readline()��
	 * ��ע����Ҫ���ǵ����쳣���
	 *
	 * @param filePath
	 */
	public static Map<String, String> map = new HashMap<>();

	public static Map<String, String> readTxtFile(String filePath) {
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { //�ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);//���ǵ������ʽ,ҪͬIDE�ı���һ��
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					System.out.println(lineTxt);
					String[] split = lineTxt.split("\\s+");
					map.put(split[0], split[1]);
				}
				read.close();
//				System.out.println(map.get("21"));

			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
//            System.out.println("��ȡ�ļ����ݳ���");
//            e.printStackTrace();
		}
		return map;
	}

	/**
	 * @param :����ӿ�
	 * @param httpArg :����
	 * @return ���ؽ��
	 */
	public static String request(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;

		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			// ����apikey��HTTP header
			connection.setRequestProperty("apikey",
					"��İٶ�api��Կ");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append(strRead + " ");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
//             e.printStackTrace();
		}
		return result;
	}

	public String check(String text) {
		if (text == null || text.isEmpty()) {
			return "������绰����";
		}

		/**
		 *  ���Ⱥ���
		 */
		if (text.equals("110")) {
			System.out.println("�绰���룺" + text + " �����绰");
			return text + "\n�����绰";
		}
		if (text.equals("120")) {
			System.out.println("�绰���룺" + text + " ����������");
			return text + "\n��������";
		}
		if (text.equals("119")) {
			System.out.println("�绰���룺" + text + " ��");
			return text + "\n��";
		}
		if (text.equals("122")) {
			System.out.println("�绰���룺" + text + " ��·��ͨ�¹ʱ���");
			return text + "\n��·��ͨ�¹ʱ���";
		}
		if (text.equals("112")) {
			System.out.println("�绰���룺" + text + " ͨ�ý������");
			return text + "\nͨ�ý������";
		}
		if (text.equals("10086")) {
			System.out.println("�绰���룺" + text + " �й��ƶ�");
			return text + "\n�й��ƶ�";
		}
		if (text.equals("10010")) {
			System.out.println("�绰���룺" + text + " �й���ͨ");
			return text + "\n�й���ͨ";
		}
		if (text.equals("10000")) {
			System.out.println("�绰���룺" + text + " �й�����");
			return text + "\n�й�����";
		}
		if (text.equals("12315")) {
			System.out.println("�绰���룺" + text + " ���������߾ٱ�");
			return text + "\n���������߾ٱ�";
		}


		/**
		 * 	�̶��绰ƥ�䣬��0771-86245687��077186245687��771-86245687��77186245687��010-52365215��13457852366��1345785
		 * 	7~12λ���ֿ�ͨ����������ʽ
		 * 	������ʽ
		 */
		String regex = "^\\d{7,11}|\\d{2}-?\\d{7}|\\d{2}-?\\d{8}|\\d{3}-?\\d{7}|\\d{3}-?\\d{8}|\\d{4}-?\\d{8}|\\d{4}-?\\d{7}$";

		if (text.matches(regex)) {


			//��keyѭ��,4λ
			for (String key : map.keySet()) {
				String str = text.substring(0, 4);
				if ((map.get(key)).equals(str)) {
					System.out.println("�绰���룺" + text + "  �����أ�" + key);
					return text + "\n�����أ�" + key;
				}
			}

			//��keyѭ����3λ
			for (String key : map.keySet()) {
				String str = text.substring(0, 3);
				if ((map.get(key)).equals(str)) {
					System.out.println("�绰���룺" + text + "  �����أ�" + key);
					return text + "\n�����أ�" + key;
				}
			}

			/****************************************************************************************
			 ******************** ������ţ�Ƶ��ֻ�����������ж� ************************************
			 ****************************************************************************************/


			/**
			 * �ж��Ƿ����ֻ���
			 * 	����ǰ��3λ�ж���Ӫ�̣�4~7λ�ж��ֻ��ŵĵ���
			 */
//			String regexCm = "^1(3[4-9]|4[7]|5[0|1|2|7|8|9]|7[8]|8[2|3|4|7|8])\\d{4,8}$";
			String regexCm = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|17[3|6|7|8]|18[0|1|2|3|4|5|6|7|8|9])\\d{8}$";
			if (text.matches(regexCm)) {

				if((text.substring(0, 7)).equals("1345785")) {
					System.out.println("�绰���룺"+text+"  �����أ����� ����(�ƶ�)");
					return text + "\n�����أ�����   ���� (�ƶ�)";
				}


				/**
				 *   �ٶ�API:http://mobsec-dianhua.baidu.com/dianhua_api/open/location?tel=�ֻ�����
				 */
				String httpUrl = "http://mobsec-dianhua.baidu.com/dianhua_api/open/location";
				String phone2 = text;
				String httpArg = "tel="+phone2;


				String jsonResult1 = request(httpUrl, httpArg);

				if(jsonResult1==null) {
					System.out.println("��������������²�ѯ��");
					return text + "\n��������������²�ѯ��";
				}else {
					System.out.println(jsonResult1);
				}


				JSONObject obj = JSONObject.fromObject(jsonResult1);

				String response = obj.getString("response");
				System.out.println(response);

				JSONObject obj2 = JSONObject.fromObject(response);
				String phone =obj2.getString(phone2);
				System.out.println(phone);

				JSONObject obj3 = JSONObject.fromObject(obj2.getString(phone2));
				String detail = obj3.getString("detail");
				System.out.println(detail);

				JSONObject obj4 = JSONObject.fromObject(detail);
				String [] area = {obj4.getString("area")};
				System.out.println(area[0]);

				String province = obj4.getString("province");
				String operator = obj4.getString("operator");

//          System.out.println(province);
//          System.out.println(operator);
//          System.out.println(province);
//          System.out.println(operator);
//          System.out.println(province);
//          System.out.println(operator);






				JSONArray obj5 =  JSONArray.fromObject(area);
				System.out.println(obj5.getJSONArray(0).get(0));

				JSONObject obj6 = JSONObject.fromObject(obj5.getJSONArray(0).get(0));
				String city = obj6.getString("city");
				System.out.println(city);
				System.out.println();

				System.out.println("�绰����:"+phone2+" �����أ�"+province+" "+city+" "+operator);

				return text + "\n�����أ�"+province+" "+city+" "+operator;

			} else {
				return text + "\n��������ȷ�ĵ绰���룡";

			}
		}
		return text + "\n��������ȷ�ĵ绰���룡";
	}
}

