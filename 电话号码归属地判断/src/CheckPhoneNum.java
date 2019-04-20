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


public class CheckPhoneNum extends JFrame{
	//面板容器
	private JPanel contentPane;
	//	private JTextField nameField;
	//电话号码
	private JTextField phoneField;
//	private JTextField ageField;

	public static void main(String[] args){

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

		//设置窗口位置和大小
		setBounds(500,180,900,730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20,20,20,20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("说明：输入固定的电话号码或手机号码。如13457855034，0771862435");
		JLabel labe2 = new JLabel("<html><body><p align=\"left\">&nbsp;&nbsp;&nbsp;注意："
				+ "<br/> &nbsp;&nbsp;&nbsp;1.必须为7~12数字</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.待写都是法国第三方根深蒂固商店告诉对方广东佛山高大上发给十多个</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.待写都是法国第三方根深蒂固商店告诉对方广东佛山高大上发给十多个</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.待写都是法国第三方根深蒂固商店告诉对方广东佛山高大上发给十多个</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.待写都是法国第三方根深蒂固商店告诉对方广东佛山高大上发给十多个</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.待写都是法国第三方根深蒂固商店告诉对方广东佛山高大上发给十多个</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;3.待写</p></body></html>");


		label.setBounds(10,15,600,35);
		labe2.setBounds(0,45,600,150);

		contentPane.add(label);
		contentPane.add(labe2);

//		nameField = new JTextField();
//		nameField.setBounds(80,10,141,25);
//		contentPane.add(nameField);

//
//		JLabel label_1 = new JLabel("年龄");
//		label_1.setBounds(10,50,122,15);
//		contentPane.add(label_1);
//
//		ageField = new JTextField();
//		ageField.setBounds(80,45,141,25);
//		contentPane.add(ageField);



//		labePhone.setIcon(icon);

		ImageIcon img = new ImageIcon("电话号码归属地判断/bg.jpg");
		//要设置的背景图片
		JLabel imgLabel = new JLabel(img);
		//将背景图放在标签里。
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		//将背景标签添加到jfram的LayeredPane面板里。
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		// 设置背景标签的位置
		Container contain = this.getContentPane();
		((JPanel) contain).setOpaque(false);
		// 将内容面板设为透明。将LayeredPane面板中的背景显示出来。

		validate();  //刷新

		Icon icon = new ImageIcon("电话号码归属地判断/logo.png");
		JLabel label_2 = new JLabel("电话号码查询");
		label_2.setBounds(50,180,300,35);
		contentPane.add(label_2);
		label_2.setIcon(icon);

		//设置字体大小和字体颜色
		label_2.setFont(new Font("宋体",1,30));//设置标签字体
		label_2.setForeground(Color.magenta);

		phoneField = new JTextField();
		phoneField.setFont(new Font("宋体",1,20));
		phoneField.setForeground(Color.blue);
		phoneField.setBounds(300,180,200,35);
		contentPane.add(phoneField);

		JButton button = new JButton("验证");
		button.setFont(new Font("宋体",1,16));
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				do_button_actionPerformed(e);
			}
		});
		button.setBounds(550,180,100,35);
		contentPane.add(button);
	}

	protected void do_button_actionPerformed(ActionEvent e){
		String text = phoneField.getText();

		String info = check(text);  //对输入的电话文本进行验证
		JOptionPane.showMessageDialog(null,info);
	}

	public String check(String text){
		if(text == null || text.isEmpty()){
			return "请输入电话号码";
		}


		//常用急救号码、短号
		if(text.equals("110")) {
			return text + "\n报警电话";
		}
		if(text.equals("120")) {
			return text + "\n急救中心";
		}
		if(text.equals("119")) {
			return text + "\n火警";
		}
		if(text.equals("122")) {
			return text + "\n道路交通事故报警";
		}
		if(text.equals("112")) {
			return text + "\n通用紧急求救";
		}
		if(text.equals("10086")) {
			return text + "\n中国移动";
		}
		if(text.equals("10010")) {
			return text + "\n中国联通";
		}
		if(text.equals("10000")) {
			return text + "\n中国电信";
		}
		if(text.equals("12315")) {
			return text + "\n消费者申诉举报";
		}


		//固定电话匹配，如0771-86245687、077186245687、771-86245687、77186245687、010-52365215、13457852366、1345785
		//7~12位数字可通过此正则表达式
		String regex = "^\\d{7,11}|\\d{2}-?\\d{7}|\\d{2}-?\\d{8}|\\d{3}-?\\d{7}|\\d{3}-?\\d{8}|\\d{4}-?\\d{8}|\\d{4}-?\\d{7}$";  //正则表达式

		if(text.matches(regex)){

			/****************************************************************************************
			 ************************   固定电话号码归属地查询        *******************************************
			 ****************************************************************************************/

			//广西
			if((text.substring(0, 4)).equals("0771")||(text.substring(0, 3)).equals("771")) {
				return text + "\n归属地：广西    南宁";
			}
			if((text.substring(0, 4)).equals("0776")||(text.substring(0, 3)).equals("776")) {
				return text + "\n归属地：广西    百色";
			}
			if((text.substring(0, 4)).equals("0779")||(text.substring(0, 3)).equals("779")) {
				return text + "\n归属地：广西    北海";
			}
			if((text.substring(0, 4)).equals("0773")||(text.substring(0, 3)).equals("773")) {
				return text + "\n归属地：广西    桂林";
			}
			if((text.substring(0, 4)).equals("0772")||(text.substring(0, 3)).equals("772")) {
				return text + "\n归属地：广西    柳州";
			}
			if((text.substring(0, 4)).equals("0778")||(text.substring(0, 3)).equals("778")) {
				return text + "\n归属地：广西    河池";
			}


			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
				return text + "\n归属地：北京";
			}
			if((text.substring(0, 3)).equals("021")||(text.substring(0, 2)).equals("21")) {
				return text + "\n归属地：上海";
			}
			if((text.substring(0, 3)).equals("022")||(text.substring(0, 2)).equals("22")) {
				return text + "\n归属地：天津";
			}
			if((text.substring(0, 3)).equals("023")||(text.substring(0, 2)).equals("23")) {
				return text + "\n归属地：重庆";
			}

			//内蒙古
			if((text.substring(0, 4)).equals("0471")||(text.substring(0, 3)).equals("471")) {
				return text + "\n归属地：内蒙古   呼和浩特市";
			}
			//待添加。。。

//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n归属地：北京";
//			}

			/****************************************************************************************
			 ******************** 以下是牛逼的手机号码归属地判断 **************************************
			 ****************************************************************************************/

			//移动号码归属地
			//依据前面3位判断运营商，4~7位判断手机号的地区

			String regexCm = "^1(3[4-9]|4[7]|5[0|1|2|7|8|9]|7[8]|8[2|3|4|7|8])\\d{4,8}$";
			if(text.matches(regexCm)){
				if((text.substring(3, 7)).equals("5785")) {
					return text + "\n归属地：广西   南宁 (移动)";
				}
				//待补充

				return text + "\n移动";
			}

			//联通号码归属地
			String regexCu = "^1(3[0-2]|5[5,6]|8[5,6]|4[5]|7[6])\\d{4,8}$";
			if(text.matches(regexCu)){

				//待补充

				return text + "\n联通";
			}

			//电信号码归属地
			String regexCt = "^1(3[3]|5[3]|7[3|7]|8[0|1|9])\\d{4,8}$";
			if(text.matches(regexCt)){

				//待补充

				return text + "\n电信";
			}


			return text + "\n请输入正确的电话号码！";
		}else{
			return text + "\n请输入正确的电话号码！";

		}
	}
}

