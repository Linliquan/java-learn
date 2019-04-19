
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
	private JPanel contentPane;   //�������
//	private JTextField nameField; 
	private JTextField phoneField;  //�绰����
//	private JTextField ageField;
 
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					CheckPhoneNum frame = new CheckPhoneNum();
					frame.setTitle("�绰�����ж�ϵͳ");
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
 
 
	public CheckPhoneNum(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,200,900,730);  //���ô���λ�úʹ�С
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20,20,20,20));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 
		JLabel label = new JLabel("˵��������̶��ĵ绰������ֻ����롣��13457855034��0771862435");
		JLabel labe2 = new JLabel("<html><body><p align=\"left\">&nbsp;&nbsp;&nbsp;ע�⣺"
				+ "<br/> &nbsp;&nbsp;&nbsp;1.����Ϊ7~12����</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.��д</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;3.��д</p></body></html>");
		
		
		label.setBounds(10,15,522,15);
		labe2.setBounds(0,45,522,100);
		
		contentPane.add(label);
		contentPane.add(labe2);
 
//		nameField = new JTextField();
//		nameField.setBounds(80,10,141,25);
//		contentPane.add(nameField);
 
// 
//		JLabel label_1 = new JLabel("����");
//		label_1.setBounds(10,50,122,15);
//		contentPane.add(label_1);
// 
//		ageField = new JTextField();
//		ageField.setBounds(80,45,141,25);
//		contentPane.add(ageField);
		
		 ImageIcon img = new ImageIcon("����.jpg");
	 		//Ҫ���õı���ͼƬ
	 		JLabel imgLabel = new JLabel(img);
	 		//������ͼ���ڱ�ǩ�
	 		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
	 		//��������ǩ��ӵ�jfram��LayeredPane����
	 		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	 		// ���ñ�����ǩ��λ��
	 		Container contain = this.getContentPane();
	 		((JPanel) contain).setOpaque(false); 
	 		// �����������Ϊ͸������LayeredPane����еı�����ʾ������

	    	 validate();  //ˢ��
 
		JLabel label_2 = new JLabel("�绰����");
		label_2.setBounds(10,200,122,15);
		contentPane.add(label_2);
 
		phoneField = new JTextField();
		phoneField.setBounds(80,200,141,25);
		contentPane.add(phoneField);
 
		JButton button = new JButton("��֤");
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
		String info = check(text);  //������ĵ绰�ı�������֤
		JOptionPane.showMessageDialog(null,info);
	}
 
	public String check(String text){
		if(text == null || text.isEmpty()){
			return "������绰����";
		}
		
		
		//���ü��Ⱥ��롢�̺�
		if(text.equals("110")) {
			return text + "\n�����绰";
		}
		if(text.equals("120")) {
			return text + "\n��������";
		}
		if(text.equals("119")) {
			return text + "\n��";
		}
		if(text.equals("122")) {
			return text + "\n��·��ͨ�¹ʱ���";
		}
		if(text.equals("112")) {
			return text + "\nͨ�ý������";
		}
		if(text.equals("10086")) {
			return text + "\n�й��ƶ�";
		}
		if(text.equals("10010")) {
			return text + "\n�й���ͨ";
		}
		if(text.equals("10000")) {
			return text + "\n�й�����";
		}
		if(text.equals("12315")) {
			return text + "\n���������߾ٱ�";
		}
		
		
		//�̶��绰ƥ�䣬��0771-86245687��077186245687��771-86245687��77186245687��010-52365215��13457852366��1345785
		//7~12λ���ֿ�ͨ����������ʽ
		String regex = "^\\d{7,11}|\\d{2}-?\\d{7}|\\d{2}-?\\d{8}|\\d{3}-?\\d{7}|\\d{3}-?\\d{8}|\\d{4}-?\\d{8}|\\d{4}-?\\d{7}$";  //������ʽ
		
		if(text.matches(regex)){
			
			/****************************************************************************************
			 ************************   �̶��绰��������ز�ѯ        *******************************************
			 ****************************************************************************************/
			
			//����
			if((text.substring(0, 4)).equals("0771")||(text.substring(0, 3)).equals("771")) {
				return text + "\n�����أ�����    ����";
			}
			if((text.substring(0, 4)).equals("0776")||(text.substring(0, 3)).equals("776")) {
				return text + "\n�����أ�����    ��ɫ";
			}
			if((text.substring(0, 4)).equals("0779")||(text.substring(0, 3)).equals("779")) {
				return text + "\n�����أ�����    ����";
			}
			if((text.substring(0, 4)).equals("0773")||(text.substring(0, 3)).equals("773")) {
				return text + "\n�����أ�����    ����";
			}
			if((text.substring(0, 4)).equals("0772")||(text.substring(0, 3)).equals("772")) {
				return text + "\n�����أ�����    ����";
			}
			if((text.substring(0, 4)).equals("0778")||(text.substring(0, 3)).equals("778")) {
				return text + "\n�����أ�����    �ӳ�";
			}
			
			
			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
				return text + "\n�����أ�����";
			}
			if((text.substring(0, 3)).equals("021")||(text.substring(0, 2)).equals("21")) {
				return text + "\n�����أ��Ϻ�";
			}
			if((text.substring(0, 3)).equals("022")||(text.substring(0, 2)).equals("22")) {
				return text + "\n�����أ����";
			}
			if((text.substring(0, 3)).equals("023")||(text.substring(0, 2)).equals("23")) {
				return text + "\n�����أ�����";
			}
			
			//���ɹ�
			if((text.substring(0, 4)).equals("0471")||(text.substring(0, 3)).equals("471")) {
				return text + "\n�����أ����ɹ�   ���ͺ�����";
			}
			//����ӡ�����
			
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
//			if((text.substring(0, 3)).equals("010")||(text.substring(0, 2)).equals("10")) {
//				return text + "\n�����أ�����";
//			}
			
			/****************************************************************************************
			 ********************    ������ ţ�Ƶ��ֻ�����������ж�              **************************************
			 ****************************************************************************************/
			
			//�ƶ����������
			//����ǰ��3λ�ж���Ӫ�̣�4~7λ�ж��ֻ��ŵĵ���
			if(text.length() >= 7 && text.length() <= 11) {
				
				//134��ͷ
				if((text.substring(0, 3)).equals("134")) {
					if((text.substring(3, 7)).equals("5785")) {
						return text + "\n�����أ�����   ���� (�ƶ�)";
					}
					//������..
		
					return text + "\n�ƶ�";
				}
				
				//150��ͷ
				if((text.substring(0, 3)).equals("150")) {
					if((text.substring(3, 7)).equals("7827")) {
						return text + "\n�����أ�����   ���� (�ƶ�)";
					}
					//������..
		
					return text + "\n�ƶ�";
				}
				
				//139��ͷ
				if((text.substring(0, 3)).equals("139")) {
					
					return text + "\n�ƶ�";
				}
				
				//138��ͷ
				if((text.substring(0, 3)).equals("138")) {
					
					return text + "\n�ƶ�";
				}
				
				//137��ͷ
				if((text.substring(0, 3)).equals("137")) {
					
					return text + "\n�ƶ�"; 
				}
				
				//136��ͷ
				if((text.substring(0, 3)).equals("136")) {
					
					return text + "\n�ƶ�";
				}
				
				//135��ͷ
				if((text.substring(0, 3)).equals("135")) {
					
					return text + "\n�ƶ�";
				}
				
				//147��ͷ
				if((text.substring(0, 3)).equals("147")) {
					
					return text + "\n�ƶ�";
				}
				
				//150��ͷ
				if((text.substring(0, 3)).equals("150")) {
					
					return text + "\n�ƶ�";
				}
				
				//151��ͷ
				if((text.substring(0, 3)).equals("151")) {
					
					return text + "\n�ƶ�";
				}
				
				//152��ͷ
				if((text.substring(0, 3)).equals("152")) {
					
					return text + "\n�ƶ�";
				}
				
				//157��ͷ
				if((text.substring(0, 3)).equals("157")) {
					
					return text + "\n�ƶ�";
				}
				
				//158��ͷ
				if((text.substring(0, 3)).equals("158")) {
					
					return text + "\n�ƶ�";
				}
				
				//159��ͷ
				if((text.substring(0, 3)).equals("159")) {
					
					return text + "\n�ƶ�";
				}
				
				//178��ͷ
				if((text.substring(0, 3)).equals("178")) {
					
					return text + "\n�ƶ�";
				}
				
				//182��ͷ
				if((text.substring(0, 3)).equals("182")) {
					
					return text + "\n�ƶ�";
				}
				
				
				//��ͨ����    ��ͨ����    ��ͨ����    ��ͨ����    ��ͨ����    ��ͨ����    
				
				//130��ͷ
				if((text.substring(0, 3)).equals("130")) {
					
					return text + "\n��ͨ";
				}
				
				//131��ͷ
				if((text.substring(0, 3)).equals("131")) {
					
					return text + "\n��ͨ";
				}
				
				//132��ͷ
				if((text.substring(0, 3)).equals("132")) {
					
					return text + "\n��ͨ";
				}
				
				//155��ͷ
				if((text.substring(0, 3)).equals("155")) {
					
					return text + "\n��ͨ";
				}
				
				//156��ͷ
				if((text.substring(0, 3)).equals("156")) {
					
					return text + "\n��ͨ";
				}
				
				//185��ͷ
				if((text.substring(0, 3)).equals("185")) {
					
					return text + "\n��ͨ";
				}
				
				//186��ͷ
				if((text.substring(0, 3)).equals("186")) {
					
					return text + "\n��ͨ";
				}
				
				//145��ͷ
				if((text.substring(0, 3)).equals("145")) {
					
					return text + "\n��ͨ";
				}
				
				//178��ͷ
				if((text.substring(0, 3)).equals("178")) {
					
					return text + "\n��ͨ";
				}
				
				//���ź���     ���ź���     ���ź���     ���ź���     ���ź���     ���ź���     
				
				//133��ͷ
				if((text.substring(0, 3)).equals("133")) {
					
					return text + "\n����";
				}
				
				//153��ͷ
				if((text.substring(0, 3)).equals("153")) {
					
					return text + "\n����";
				}
				
				//177��ͷ
				if((text.substring(0, 3)).equals("177")) {
					
					return text + "\n����";
				}
				
				//173��ͷ
				if((text.substring(0, 3)).equals("173")) {
					
					return text + "\n����";
				}
				
				//180��ͷ
				if((text.substring(0, 3)).equals("180")) {
					
					return text + "\n����";
				}
				
				//181��ͷ
				if((text.substring(0, 3)).equals("181")) {
					
					return text + "\n����";
				}
				
				//189��ͷ
				if((text.substring(0, 3)).equals("189")) {
					
					return text + "\n����"; 
				}
			
				
			}
			
			
			
			return text + "\n��������ȷ�ĵ绰���룡";
		}else{
			return text + "\n��������ȷ�ĵ绰���룡";
			
		}
	}
}

