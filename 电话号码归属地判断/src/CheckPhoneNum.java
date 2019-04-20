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
	//�������
	private JPanel contentPane;
	//	private JTextField nameField;
	//�绰����
	private JTextField phoneField;
//	private JTextField ageField;

	public static void main(String[] args){

		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				try{
					CheckPhoneNum frame = new CheckPhoneNum();
					frame.setTitle("�ֻ���������ز�ѯϵͳ");
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}


	public CheckPhoneNum(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//���ô���λ�úʹ�С
		setBounds(500,180,900,730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20,20,20,20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("˵��������̶��ĵ绰������ֻ����롣��13457855034��0771862435");
		JLabel labe2 = new JLabel("<html><body><p align=\"left\">&nbsp;&nbsp;&nbsp;ע�⣺"
				+ "<br/> &nbsp;&nbsp;&nbsp;1.����Ϊ7~12����</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.��д���Ƿ�������������ٹ��̵���߶Է��㶫��ɽ�ߴ��Ϸ���ʮ���</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.��д���Ƿ�������������ٹ��̵���߶Է��㶫��ɽ�ߴ��Ϸ���ʮ���</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.��д���Ƿ�������������ٹ��̵���߶Է��㶫��ɽ�ߴ��Ϸ���ʮ���</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.��д���Ƿ�������������ٹ��̵���߶Է��㶫��ɽ�ߴ��Ϸ���ʮ���</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;2.��д���Ƿ�������������ٹ��̵���߶Է��㶫��ɽ�ߴ��Ϸ���ʮ���</p>"
				+ "<p>&nbsp;&nbsp;&nbsp;3.��д</p></body></html>");


		label.setBounds(10,15,600,35);
		labe2.setBounds(0,45,600,150);

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



//		labePhone.setIcon(icon);

		ImageIcon img = new ImageIcon("�绰����������ж�/bg.jpg");
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

		Icon icon = new ImageIcon("�绰����������ж�/logo.png");
		JLabel label_2 = new JLabel("�绰�����ѯ");
		label_2.setBounds(50,180,300,35);
		contentPane.add(label_2);
		label_2.setIcon(icon);

		//���������С��������ɫ
		label_2.setFont(new Font("����",1,30));//���ñ�ǩ����
		label_2.setForeground(Color.magenta);

		phoneField = new JTextField();
		phoneField.setFont(new Font("����",1,20));
		phoneField.setForeground(Color.blue);
		phoneField.setBounds(300,180,200,35);
		contentPane.add(phoneField);

		JButton button = new JButton("��֤");
		button.setFont(new Font("����",1,16));
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
			 ******************** ������ţ�Ƶ��ֻ�����������ж� **************************************
			 ****************************************************************************************/

			//�ƶ����������
			//����ǰ��3λ�ж���Ӫ�̣�4~7λ�ж��ֻ��ŵĵ���

			String regexCm = "^1(3[4-9]|4[7]|5[0|1|2|7|8|9]|7[8]|8[2|3|4|7|8])\\d{4,8}$";
			if(text.matches(regexCm)){
				if((text.substring(3, 7)).equals("5785")) {
					return text + "\n�����أ�����   ���� (�ƶ�)";
				}
				//������

				return text + "\n�ƶ�";
			}

			//��ͨ���������
			String regexCu = "^1(3[0-2]|5[5,6]|8[5,6]|4[5]|7[6])\\d{4,8}$";
			if(text.matches(regexCu)){

				//������

				return text + "\n��ͨ";
			}

			//���ź��������
			String regexCt = "^1(3[3]|5[3]|7[3|7]|8[0|1|9])\\d{4,8}$";
			if(text.matches(regexCt)){

				//������

				return text + "\n����";
			}


			return text + "\n��������ȷ�ĵ绰���룡";
		}else{
			return text + "\n��������ȷ�ĵ绰���룡";

		}
	}
}

