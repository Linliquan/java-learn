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

/**
 *  软件测试作业---电话号码归属地查询
 */
public class CheckPhoneNum extends JFrame{

	/**
	 * 面板容器
	 */
	private JPanel contentPane;
	/**
	 * 电话号码框
	 */
	private JTextField phoneField;

	public static void main(String[] args){
//		CheckPhoneNum.readTxtFile("电话号码归属地判断/city.txt");
		System.out.println(CheckPhoneNum.readTxtFile("电话号码归属地判断/city.txt"));
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				try{
					CheckPhoneNum frame = new CheckPhoneNum();
					frame.setTitle("手机号码归属地查询系统");
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}


	public CheckPhoneNum(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		/**
		 * 设置窗口位置和大小
		 */
		setBounds(500,40,900,760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20,20,20,20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("使用说明：本系统可查询固定电话的归属地、手机号码的归属地和运营商。");
		JLabel labe2 = new JLabel("<html><body>"
				+ "<br/> 1.固定电话查询："
				+ "<br/>格式：2~4位的区号+7位或8位的电话号码(有“-”分隔或者没有分隔都可以)"
				+"<br/>如0771-86225824、0771-8622582、010-65246622、01065246622"
				+ "<p></p>"
				+ "<p>2.手机号码查询：</p>"
				+ "<p>格式：输入7~11位的手机号码，如：13457855034、1345785</p>"
				+ "<p></p>"
				+ "<p>3.急救号码、常用号码查询：</p>"
				+ "<p>格式：如：110、120、119、122、12315、10086、10000</p>"
				+ "<p></p>"
				+ "<p>注意：</p>"
				+ "<p>1.因国内手机号码的地区号码段不外传，网上无法查询到地区号码段，" +
				"故有一些手机号码无法查询到归属地，只能查询到运营商</p></body></html>");

		JLabel labe3 = new JLabel("软件工程 软件Q164 林李权 201609601282");
		label.setBounds(10,15,700,20);
		labe2.setBounds(50,10,700,300);
		labe3.setBounds(250,600,700,20);

		//设置标签字体
		label.setFont(new Font("宋体",1,16));
		labe2.setFont(new Font("宋体",1,16));
		labe3.setFont(new Font("宋体",1,20));
		labe3.setForeground(Color.MAGENTA);
		contentPane.add(label);
		contentPane.add(labe2);
		contentPane.add(labe3);

		/**
		 * 设置背景图片
		 */
		ImageIcon img = new ImageIcon("电话号码归属地判断/bg.jpg");
		//要设置的背景图片
		JLabel imgLabel = new JLabel(img);
		//将背景图放在标签里。
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		//将背景标签添加到jfram的LayeredPane面板里。
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		// 设置背景标签的位置
		Container contain = this.getContentPane();
		// 将内容面板设为透明。将LayeredPane面板中的背景显示出来。
		((JPanel) contain).setOpaque(false);
		validate();  //刷新

		//设置手机图标
		Icon icon = new ImageIcon("电话号码归属地判断/phone.png");
		JLabel label_2 = new JLabel("电话号码查询");
		label_2.setBounds(50,330,300,35);
		contentPane.add(label_2);
		label_2.setIcon(icon);

		//设置字体大小和字体颜色
		label_2.setFont(new Font("宋体",1,30));//设置标签字体
		label_2.setForeground(Color.magenta);

		phoneField = new JTextField();
		phoneField.setFont(new Font("宋体",1,20));
		phoneField.setForeground(Color.blue);
		phoneField.setBounds(300,330,200,35);
		contentPane.add(phoneField);

		JButton button = new JButton("查询");
		button.setFont(new Font("宋体",1,16));
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				do_button_actionPerformed(e);
			}
		});
		button.setBounds(550,330,100,35);
		contentPane.add(button);
	}

	protected void do_button_actionPerformed(ActionEvent e){
		String text = phoneField.getText();

		//对输入的电话文本进行验证
		String info = check(text);
		JOptionPane.showMessageDialog(null,info);

	}

	/**
	 *
	 * 读取city.txt文件
	 * @return
	 */

	/**
	 * 功能：Java读取txt文件的内容
	 * 步骤：1：先获得文件句柄
	 * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流
	 * 4：一行一行的输出。readline()。
	 * 备注：需要考虑的是异常情况
	 * @param filePath
	 */


	public static Map<String, String> map = new HashMap<>();

	public static Map<String, String> readTxtFile(String filePath){

		try {
			String encoding="GBK";
			File file=new File(filePath);
			if(file.isFile() && file.exists()){ //判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file),encoding);//考虑到编码格式,要同IDE的编码一样
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while((lineTxt = bufferedReader.readLine()) != null){
                        System.out.println(lineTxt);
					String[] split = lineTxt.split("\\s+");
					map.put(split[0],split[1]);
				}
				read.close();
//				System.out.println(map.get("21"));

			}else{
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
//            System.out.println("读取文件内容出错");
//            e.printStackTrace();
		}
		return map;
	}

	public String check(String text){
		if(text == null || text.isEmpty()){
			return "请输入电话号码";
		}

		/**
		 *  急救号码
		 */
		if(text.equals("110")) {
			System.out.println("电话号码："+text+" 报警电话");
			return text + "\n报警电话";
		}
		if(text.equals("120")) {
			System.out.println("电话号码："+text+" 报急救中心");
			return text + "\n急救中心";
		}
		if(text.equals("119")) {
			System.out.println("电话号码："+text+" 火警");
			return text + "\n火警";
		}
		if(text.equals("122")) {
			System.out.println("电话号码："+text+" 道路交通事故报警");
			return text + "\n道路交通事故报警";
		}
		if(text.equals("112")) {
			System.out.println("电话号码："+text+" 通用紧急求救");
			return text + "\n通用紧急求救";
		}
		if(text.equals("10086")) {
			System.out.println("电话号码："+text+" 中国移动");
			return text + "\n中国移动";
		}
		if(text.equals("10010")) {
			System.out.println("电话号码："+text+" 中国联通");
			return text + "\n中国联通";
		}
		if(text.equals("10000")) {
			System.out.println("电话号码："+text+" 中国电信");
			return text + "\n中国电信";
		}
		if(text.equals("12315")) {
			System.out.println("电话号码："+text+" 消费者申诉举报");
			return text + "\n消费者申诉举报";
		}



		/**
		 * 	固定电话匹配，如0771-86245687、077186245687、771-86245687、77186245687、010-52365215、13457852366、1345785
		 * 	7~12位数字可通过此正则表达式
		 * 	正则表达式
		 */
		String regex = "^\\d{7,11}|\\d{2}-?\\d{7}|\\d{2}-?\\d{8}|\\d{3}-?\\d{7}|\\d{3}-?\\d{8}|\\d{4}-?\\d{8}|\\d{4}-?\\d{7}$";

		if(text.matches(regex)){


			//对key循环,4位
			for(String key : map.keySet()) {
				String str =text.substring(0,4);
				if((map.get(key)).equals(str)) {
					System.out.println("电话号码："+text+"  归属地："+key);
					return text + "\n归属地："+key;
				}
			}

			//对key循环，3位
			for(String key : map.keySet()) {
				String str =text.substring(0,3);
				if((map.get(key)).equals(str)) {
					System.out.println("电话号码："+text+"  归属地："+key);
					return text + "\n归属地："+key;
				}
			}

			/****************************************************************************************
			 ******************** 以下是牛逼的手机号码归属地判断 ************************************
			 ****************************************************************************************/


			/**
			 * 移动号码归属地
			 * 	依据前面3位判断运营商，4~7位判断手机号的地区
			 */
			String regexCm = "^1(3[4-9]|4[7]|5[0|1|2|7|8|9]|7[8]|8[2|3|4|7|8])\\d{4,8}$";
			if(text.matches(regexCm)){
				if((text.substring(3, 7)).equals("5785")) {
					System.out.println("电话号码："+text+"  归属地：广西 南宁(移动)");
					return text + "\n归属地：广西   南宁 (移动)";
				}
				//待补充
				System.out.println("电话号码："+text+"  移动");
				return text + "\n移动";
			}

			//联通号码归属地
			String regexCu = "^1(3[0-2]|5[5,6]|8[5,6]|4[5]|7[6])\\d{4,8}$";
			if(text.matches(regexCu)){

				//待补充
				System.out.println("电话号码："+text+"  联通");
				return text + "\n联通";
			}

			//电信号码归属地
			String regexCt = "^1(3[3]|5[3]|7[3|7]|8[0|1|9])\\d{4,8}$";
			if(text.matches(regexCt)){

				//待补充
				System.out.println("电话号码："+text+"  电信");
				return text + "\n电信";
			}

			return text + "\n请输入正确的电话号码！";
		}else{
			return text + "\n请输入正确的电话号码！";

		}
	}
}

