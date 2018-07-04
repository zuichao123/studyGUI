package com.sunjian.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sunjian.constant.Constant;

/**
 * java.io��ͼ�ν��棺������ϰ��
 * 
 * 	��ϰ�����˵���ʾ
 * 
 * 		������
 * 			ʹ��IO�������һ���򵥵Ĳ˵�����������ʾ��
 * 			xxxxϵͳ
 * 			��1����������
 * 			��2��ɾ������
 * 			��3���޸�����
 * 			��4���鿴����
 * 			��0��ϵͳ�˳�
 * 			
 * 			��ѡ��
 * 
 * 			����û�����ı�Ų���ȷ����Ҫ����������ʾ�����ȴ��û�����ѡ��
 * 
 * 		˼·��
 * 			����Ҫ��һ���˵�����ʾ������ʵ����ÿ��ѡ��֮�󶼿϶������Լ������ɸ�������
 * 			����Ϊ�˷���������������¼����ࣺ
 * 			Menu�ࣨר����ʾ�˵���Ϣ��
 * 			Operate����ʾ�����ࣩ�Ժ����书��ʱ��ֱ���޸Ĵ���
 * 
 * 		��ϰ�ܽ᣺
 * 			�ڿ�����һ��Ҫ����ɹ��ܣ�֮���ٿ��������ƣ�
 * 			����������һ���ͻ��ˣ�����Խ��Խ�á�
 * 
 * 
 * 	ʵ��Ҫ��
 * 		��֮ǰ�Ĳ˵�����������䣬Ҫ�����ӵ�ʱ���������һ���˵�������Ϣ���˵���Ϣ�������������䡣����֮��Ҳ�����޸Ĵ���Ϣ��ɾ������Ϣ����ѯ����Ϣ���˴���������ɣ�
 * 		��ʾ��
 * 			ʹ�ö�������л����档
 * 		��ʱ������ʹ��֮ǰ�����ĵļ����ࣺInputData��Person��Operate��Menu��
 * 		��Ҫ�����ļ������࣬ר�Ÿ��𱣴�Ͷ�ȡ�ļ������ݣ��Լ��޸�Operate�࣬Ϊ����������Ĳ�������ʱ����Ĳ������£�
 * 
 * @author sunjian
 *
 */
public class MyWindow extends JFrame {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int screenWidth = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
	private int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
	private int WINDOW_LOCATION_X = screenWidth / 2 - Constant.WIDTH_WINDOW / 2 + 50;
	private int WINDOW_LOCATION_Y = screenHeight / 2 - Constant.HEIGHT_WINDOW / 2 + 30;
	
	//System.out.println("��Ļ�ֱ��ʣ�"+screenWidth+":"+screenHeight);
	
	JFrame mJframe;
	JPanel mJpanle;
	
	JLabel mJlGreeting;
	JLabel mJlOne;
	JLabel mJlTwo;
	JLabel mJlThree;
	JLabel mJlFour;
	JLabel mJlZero;
	JLabel mJlPleaseChoose;
	JLabel mJlResult;
	JLabel mJlImageFB;
	
	JTextField mJTextField;
	JTextArea mJTextArea;
	
	JScrollPane mJtascrol;
	
	JComboBox<Object> mJcbPleaseChoose;
	
	JButton mJbConfirm;
	
	ImageIcon mIconFB;
	
	public MyWindow(){
		/***ʵ�������塢�������***/
		this.mJframe = new JFrame();
		this.mJpanle = new JPanel();	
		
		/***�������Ԫ��***/
		this.mJlGreeting = new JLabel(Constant.system_Name);
		this.mJlOne = new JLabel(Constant.option_One,SwingConstants.LEFT);
		this.mJlTwo = new JLabel(Constant.option_Two);
		this.mJlThree = new JLabel(Constant.option_Three);
		this.mJlFour = new JLabel(Constant.option_Four);
		this.mJlZero = new JLabel(Constant.option_Zero);
		this.mIconFB = new ImageIcon(Constant.mIcom_Path);
		this.mJlImageFB = new JLabel(mIconFB);
		this.mJTextField = new JTextField(Constant.please_Input,10);
		this.mJlPleaseChoose = new JLabel(Constant.please_Select);
		this.mJlResult = new JLabel(Constant.result);
		this.mJcbPleaseChoose = new JComboBox<Object>(Constant.font_Size);
		this.mJTextArea = new JTextArea(3,50);
		this.mJbConfirm = new JButton(Constant.confirm);
	}
	
	public void run(){
		/***��ӵ������������ӵ�λ�á���С��**************/
		this.mJlGreeting.setSize(450, 40);
		this.mJlGreeting.setLocation(200,0);
		this.mJlGreeting.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE,28));
		this.mJlGreeting.setBackground(Color.blue);
		this.mJpanle.add(mJlGreeting);
		
		this.mJlOne.setSize(130, 130);
		this.mJlOne.setLocation(20, 25);
		this.mJlOne.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE, 14));
		this.mJlOne.setBackground(Color.BLACK);
		this.mJpanle.add(mJlOne);
		
		this.mJlTwo.setSize(130, 130);
		this.mJlTwo.setLocation(this.mJlOne.getX(),this.mJlOne.getY() + 50);
		this.mJlTwo.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE,14));
		this.mJlTwo.setBackground(Color.blue);
		this.mJpanle.add(mJlTwo);
		
		this.mJlThree.setSize(130, 130);
		this.mJlThree.setLocation(this.mJlOne.getX(),this.mJlTwo.getY() + 50);
		this.mJlThree.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE,14));
		this.mJlThree.setBackground(Color.blue);
		this.mJpanle.add(mJlThree);
		
		this.mJlFour.setSize(130, 130);
		this.mJlFour.setLocation(this.mJlOne.getX(),this.mJlThree.getY() + 50);
		this.mJlFour.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE,14));
		this.mJlFour.setBackground(Color.blue);
		this.mJpanle.add(mJlFour);
		
		this.mJlZero.setSize(130, 130);
		this.mJlZero.setLocation(this.mJlOne.getX(),this.mJlFour.getY() + 50);
		this.mJlZero.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE,14));
		this.mJlZero.setBackground(Color.blue);
		this.mJpanle.add(mJlZero);
		
		this.mJlPleaseChoose.setSize(100, 100);
		this.mJlPleaseChoose.setLocation(this.mJlOne.getX() + 5,this.mJlZero.getY() + 80);
		this.mJlPleaseChoose.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE,14));
		this.mJlPleaseChoose.setBackground(Color.blue);
		this.mJpanle.add(mJlPleaseChoose);
		
		this.mJlResult.setSize(100, 100);
		this.mJlResult.setLocation(mJlPleaseChoose.getX(),mJlPleaseChoose.getY()+50);
		this.mJlResult.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE,14));
		this.mJlResult.setBackground(Color.blue);
		this.mJpanle.add(mJlResult);
		
		/*�����ı���
		this.mJTextField.setSize(30, 30);
		this.mJTextField.setLocation(120,355);
		this.mJTextField.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE,14));
		this.mJTextField.setForeground(Color.lightGray);
		this.mJTextField.setBackground(Color.white);
		this.mJTextField.setEnabled(true);
		this.mJpanle.add(mJTextField);*/	
		
		this.mJcbPleaseChoose.setSize(102, 20);
		this.mJcbPleaseChoose.setLocation(mJlPleaseChoose.getX()+65,mJcbPleaseChoose.getY()+345);
		this.mJcbPleaseChoose.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE,14));
		this.mJcbPleaseChoose.setBackground(Color.white);
		this.mJcbPleaseChoose.setMaximumRowCount(4);
		this.mJpanle.add(mJcbPleaseChoose);
		
		this.mJTextArea.setSize(150, 120);
		this.mJTextArea.setLocation(mJlResult.getX()+65,mJlResult.getY()+40);
		this.mJTextArea.setFont(new Font(Constant.songTi, Font.BOLD, 10));
		this.mJTextArea.setBackground(Color.WHITE);
		this.mJTextArea.setEnabled(false);//�ɱ༭
		this.mJTextArea.setLineWrap(true);//�Զ�����
		this.mJpanle.add(mJTextArea);
		
		this.mJtascrol = new JScrollPane(this.mJTextArea);
		this.mJtascrol.setSize(this.mJTextArea.getWidth(), this.mJTextArea.getHeight());
		this.mJtascrol.setLocation(mJlResult.getX()+65,mJlResult.getY()+40);
		this.mJpanle.add(mJtascrol);		
		
		this.mJbConfirm.setSize(60,60);
		this.mJbConfirm.setLocation(this.mJlGreeting.getX()+200,this.mJlGreeting.getY()+510);
		this.mJbConfirm.setFont(new Font(Constant.songTi, Font.CENTER_BASELINE, 10));
		this.mJpanle.add(mJbConfirm);
		
		this.mJlImageFB.setSize(490,450);
		this.mJlImageFB.setLocation(mJlOne.getX()+260, mJlOne.getY()+10);
		this.mJlImageFB.setBackground(Color.WHITE);
		this.mJpanle.add(mJlImageFB);
			
		//������������Ϊ��
		this.setLayout(null);
		this.mJpanle.setLayout(null);
		
		//�������ӵ�����������
		this.mJframe.getContentPane().add(mJpanle, BorderLayout.CENTER);
		
		//���ô���
		this.mJframe.setSize(820,620);
		this.mJframe.setLocation(WINDOW_LOCATION_X + 200,WINDOW_LOCATION_Y);
		this.mJframe.setResizable(false);
		this.mJframe.setVisible(true);
		//this.mJframe.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.mJframe.setTitle(Constant.main_Title);	
			
		this.mJTextField.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				if (mJTextField.getText().equals(Constant.please_Input)) {
					mJTextField.setText(Constant.null_Char);
				}
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String mJcbContent = mJcbPleaseChoose.getSelectedItem().toString();
				
				if (e.getSource() == mJbConfirm) {
					
					mJTextArea.setText(Constant.null_Char);
					
					if (mJcbContent.equals(Constant.one)) {//�����Ա	
						disableMainFrame();		
						new MyWindowAdd(mJframe,mJTextArea).add();									
						enableMainFrame();
					}
					if (mJcbContent.equals(Constant.two)) {//ɾ����Ա
						disableMainFrame();
						new MyWindowDelete(mJframe).delete();
						enableMainFrame();
					}
					if (mJcbContent.equals(Constant.three)) {//������Ա
						disableMainFrame();
						new MyWindowUpdate(mJframe, mJTextArea).update();
						enableMainFrame();
					}
					if (mJcbContent.equals(Constant.four)) {//�鿴��Ա
						disableMainFrame();
						new MyWindowSelect(mJframe).look();
						enableMainFrame();
					}
					if (mJcbContent.equals(Constant.zero)) {//ϵͳ�˳�
						mJTextArea.setText(Constant.bye);
						System.exit(1);
					}					
					if (mJcbContent.equals(Constant.null_Char)) {
						mJTextArea.setText(Constant.please_Choose);
					}
				}	
			}
		
		});
		
		this.mJframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
		
	}
	
	private void disableMainFrame() {	
//		this.mJframe.setFocusable(false);
		this.mJframe.setEnabled(false);
		this.mJcbPleaseChoose.setFocusable(false);
		this.mJTextArea.setEnabled(false);
		this.mJbConfirm.setEnabled(false);
	}
	public void enableMainFrame(){
//		this.mJframe.setFocusable(true);
		this.mJframe.setEnabled(true);
		this.mJcbPleaseChoose.setEnabled(true);
		this.mJTextArea.setEnabled(true);
		this.mJbConfirm.setEnabled(true);
	}
	
	public static void main(String[] args) {
		new MyWindow().run();
	}
}
