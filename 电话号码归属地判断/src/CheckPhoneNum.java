
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
 
public class CheckPhoneNum extends JFrame{
	private JPanel contentPane;   //面板容器
//	private JTextField nameField; 
	private JTextField phoneField;  //电话号码
//	private JTextField ageField;
 
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					CheckPhoneNum frame = new CheckPhoneNum();
					frame.setTitle("电话号码判断系统");
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
 
 
	public CheckPhoneNum(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,200,900,730);  //设置窗口位置和大小
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20,20,20,20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 
		JLabel label = new JLabel("说明：输入固定的电话号码或手机号码。如13457855034，0771862435");
		JLabel labe2 = new JLabel("<html><body><p align=\"left\">&nbsp;&nbsp;&nbsp;注意："
				+ "<br/> &nbsp;&nbsp;&nbsp;1.必须为7~12数字</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.待写</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;3.待写</p></body></html>");
		
		
		label.setBounds(10,15,522,15);
		labe2.setBounds(0,45,522,100);
		
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
		
		 ImageIcon img = new ImageIcon("背景.jpg");
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
 
		JLabel label_2 = new JLabel("电话号码");
		label_2.setBounds(10,200,122,15);
		contentPane.add(label_2);
 
		phoneField = new JTextField();
		phoneField.setBounds(80,200,141,25);
		contentPane.add(phoneField);
 
		JButton button = new JButton("验证");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_button_actionPerformed(e);
			}
		});
		button.setBounds(250,200,60,25);
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
			 ********************    以下是 牛逼的手机号码归属地判断              **************************************
			 ****************************************************************************************/
			
			//移动号码归属地
			//依据前面3位判断运营商，4~7位判断手机号的地区
			if(text.length() >= 7 && text.length() <= 11) {
				
				//134开头
				if((text.substring(0, 3)).equals("134")) {
					if((text.substring(3, 7)).equals("5785")) {
						return text + "\n归属地：广西   南宁 (移动)";
					}
					//待补充..
		
					return text + "\n移动";
				}
				
				//150开头
				if((text.substring(0, 3)).equals("150")) {
					if((text.substring(3, 7)).equals("7827")) {
						return text + "\n归属地：广西   柳州 (移动)";
					}
					//待补充..
		
					return text + "\n移动";
				}
				
				//139开头
				if((text.substring(0, 3)).equals("139")) {
					
					return text + "\n移动";
				}
				
				//138开头
				if((text.substring(0, 3)).equals("138")) {
					
					return text + "\n移动";
				}
				
				//137开头
				if((text.substring(0, 3)).equals("137")) {
					
					return text + "\n移动"; 
				}
				
				//136开头
				if((text.substring(0, 3)).equals("136")) {
					
					return text + "\n移动";
				}
				
				//135开头
				if((text.substring(0, 3)).equals("135")) {
					
					return text + "\n移动";
				}
				
				//147开头
				if((text.substring(0, 3)).equals("147")) {
					
					return text + "\n移动";
				}
				
				//150开头
				if((text.substring(0, 3)).equals("150")) {
					
					return text + "\n移动";
				}
				
				//151开头
				if((text.substring(0, 3)).equals("151")) {
					
					return text + "\n移动";
				}
				
				//152开头
				if((text.substring(0, 3)).equals("152")) {
					
					return text + "\n移动";
				}
				
				//157开头
				if((text.substring(0, 3)).equals("157")) {
					
					return text + "\n移动";
				}
				
				//158开头
				if((text.substring(0, 3)).equals("158")) {
					
					return text + "\n移动";
				}
				
				//159开头
				if((text.substring(0, 3)).equals("159")) {
					
					return text + "\n移动";
				}
				
				//178开头
				if((text.substring(0, 3)).equals("178")) {
					
					return text + "\n移动";
				}
				
				//182开头
				if((text.substring(0, 3)).equals("182")) {
					
					return text + "\n移动";
				}
				
				
				//联通号码    联通号码    联通号码    联通号码    联通号码    联通号码    
				
				//130开头
				if((text.substring(0, 3)).equals("130")) {
					
					return text + "\n联通";
				}
				
				//131开头
				if((text.substring(0, 3)).equals("131")) {
					
					return text + "\n联通";
				}
				
				//132开头
				if((text.substring(0, 3)).equals("132")) {
					
					return text + "\n联通";
				}
				
				//155开头
				if((text.substring(0, 3)).equals("155")) {
					
					return text + "\n联通";
				}
				
				//156开头
				if((text.substring(0, 3)).equals("156")) {
					
					return text + "\n联通";
				}
				
				//185开头
				if((text.substring(0, 3)).equals("185")) {
					
					return text + "\n联通";
				}
				
				//186开头
				if((text.substring(0, 3)).equals("186")) {
					
					return text + "\n联通";
				}
				
				//145开头
				if((text.substring(0, 3)).equals("145")) {
					
					return text + "\n联通";
				}
				
				//178开头
				if((text.substring(0, 3)).equals("178")) {
					
					return text + "\n联通";
				}
				
				//电信号码     电信号码     电信号码     电信号码     电信号码     电信号码     
				
				//133开头
				if((text.substring(0, 3)).equals("133")) {
					
					return text + "\n电信";
				}
				
				//153开头
				if((text.substring(0, 3)).equals("153")) {
					
					return text + "\n电信";
				}
				
				//177开头
				if((text.substring(0, 3)).equals("177")) {
					
					return text + "\n电信";
				}
				
				//173开头
				if((text.substring(0, 3)).equals("173")) {
					
					return text + "\n电信";
				}
				
				//180开头
				if((text.substring(0, 3)).equals("180")) {
					
					return text + "\n电信";
				}
				
				//181开头
				if((text.substring(0, 3)).equals("181")) {
					
					return text + "\n电信";
				}
				
				//189开头
				if((text.substring(0, 3)).equals("189")) {
					
					return text + "\n电信"; 
				}
			
				
			}
			
			
			
			return text + "\n请输入正确的电话号码！";
		}else{
			return text + "\n请输入正确的电话号码！";
			
		}
	}
}

