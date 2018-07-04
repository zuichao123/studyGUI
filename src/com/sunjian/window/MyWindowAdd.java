package com.sunjian.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sunjian.bean.Person;
import com.sunjian.constant.Constant;
import com.sunjian.dao.DBOperate;


public class MyWindowAdd extends MyWindow{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int myJFrameGetX = 0;
	private int myJFrameGetY = 0;

	/**************init*******************/
	JFrame mJframeAdd;
	JPanel mJpanelAdd;
	
	JLabel mJlName;
	JLabel mJlAge;
	JLabel mJlSex;
	
	JRadioButton mJrbMan;
	JRadioButton mJrbWoman;
	
	JTextField mJtfName;
	JTextField mJtfAge;
	
	JButton mJbConfirm;
	JButton mJbCancel;
	
	ImageIcon mIcon;
	JLabel mJlNImageR;
	JLabel mJlNImageW;
	JLabel mJlAImageR;
	JLabel mJlAImageW;
	
	JTextArea superMJtextArea;
	
	public MyWindowAdd(JFrame mJFrame,JTextArea mJTextArea){
		this.myJFrameGetX = mJFrame.getX();
		this.myJFrameGetY = mJFrame.getY();
		this.superMJtextArea = mJTextArea;
		/************定义组件****************/
		this.mJframeAdd = new JFrame();
		this.mJpanelAdd = new JPanel();
		
		this.mJlName = new JLabel(Constant.name);
		this.mJlAge = new JLabel(Constant.age);
		this.mJlSex = new JLabel("性别：");
		
		this.mJrbMan = new JRadioButton("男");
		this.mJrbWoman = new JRadioButton("女");
		
		this.mJtfName = new JTextField();
		this.mJtfAge = new JTextField();
		
		this.mJbConfirm = new JButton(Constant.confirm);
		this.mJbCancel = new JButton(Constant.cancel);
	}
	
	/*创建窗口*/
	public void add(){
			
		/************画组件*****************/
		this.setLayout(null);
		this.mJpanelAdd.setLayout(null);
		
		this.mJlName.setSize(100, 100);
		this.mJlName.setLocation(12, 5);
		this.mJlName.setFont(new Font(Constant.songTi, Font.BOLD, 14));
		this.mJpanelAdd.add(mJlName);
		
		this.mJtfName.setSize(80, 25);
		this.mJtfName.setLocation(this.mJlName.getX()+45, this.mJlName.getY()+38);
		this.mJtfName.setBackground(Color.WHITE);
		this.mJpanelAdd.add(mJtfName);
		
		this.mIcon = new ImageIcon(Constant.right);
		this.mJlNImageR = new JLabel(mIcon);
		this.mJlNImageR.setSize(25,25);
		this.mJlNImageR.setLocation(mJtfName.getX() + 100,mJtfName.getY());
		this.mJpanelAdd.add(mJlNImageR);
		this.mJlNImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(Constant.wrong);
		this.mJlNImageW = new JLabel(mIcon);
		this.mJlNImageW.setSize(25,25);
		this.mJlNImageW.setLocation(mJtfName.getX() + 100,mJtfName.getY());
		this.mJpanelAdd.add(mJlNImageW);
		this.mJlNImageW.setVisible(false);
		
		this.mJlAge.setSize(100,100);
		this.mJlAge.setLocation(this.mJlName.getX(), this.mJlName.getY()+35);
		this.mJlAge.setFont(new Font(Constant.songTi, Font.BOLD, 14));
		this.mJpanelAdd.add(mJlAge);
		
		this.mJtfAge.setSize(80, 25);
		this.mJtfAge.setLocation(this.mJtfName.getX(), this.mJlAge.getY()+38);
		this.mJtfAge.setBackground(Color.WHITE);
		this.mJpanelAdd.add(mJtfAge);
		
		this.mIcon = new ImageIcon(Constant.right);
		this.mJlAImageR = new JLabel(mIcon);
		this.mJlAImageR.setSize(25,25);
		this.mJlAImageR.setLocation(mJtfAge.getX() + 100,mJtfAge.getY());
		this.mJpanelAdd.add(mJlAImageR);
		this.mJlAImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(Constant.wrong);
		this.mJlAImageW = new JLabel(mIcon);
		this.mJlAImageW.setSize(25,25);
		this.mJlAImageW.setLocation(mJtfAge.getX() + 100,mJtfAge.getY());
		this.mJpanelAdd.add(mJlAImageW);
		this.mJlAImageW.setVisible(false);

		this.mJlSex.setSize(100, 100);
		this.mJlSex.setLocation(this.mJlName.getX(), this.mJlAge.getY()+35);
		this.mJlSex.setFont(new Font(Constant.songTi, Font.BOLD, 14));
		this.mJpanelAdd.add(mJlSex);
		
		this.mJrbMan.setSize(38, 38);
		this.mJrbMan.setLocation(this.mJlSex.getX()+40, this.mJlSex.getY()+30);
		this.mJrbMan.setSelected(true);//默认选中
		this.mJpanelAdd.add(mJrbMan);
		this.mJrbWoman.setSize(38,38);
		this.mJrbWoman.setLocation(this.mJrbMan.getX()+50, this.mJrbMan.getY());
		this.mJpanelAdd.add(mJrbWoman);
		ButtonGroup group = new ButtonGroup();
		group.add(this.mJrbMan);
		group.add(this.mJrbWoman);
	
		this.mJbConfirm.setSize(60, 60);
		this.mJbConfirm.setLocation(120, 250);
//		this.mJbConfirm.setFont(new Font(Constant.songTi, Font.BOLD, 10));
		this.mJpanelAdd.add(mJbConfirm);
		
		this.mJbCancel.setSize(60, 60);
		this.mJbCancel.setLocation(this.mJbConfirm.getX() + 160, this.mJbConfirm.getY());
//		this.mJbCancel.setFont(new Font(Constant.songTi, Font.BOLD, 10));
		this.mJpanelAdd.add(mJbCancel);

		this.mJframeAdd.getContentPane().add(mJpanelAdd, BorderLayout.CENTER);
		
		this.mJframeAdd.setSize(460,400);
		this.mJframeAdd.setLocation(myJFrameGetX + 185,myJFrameGetY + 100);
		this.mJframeAdd.setResizable(false);
		this.mJframeAdd.setVisible(true);
		this.mJframeAdd.setAlwaysOnTop(true);
		this.mJframeAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.mJframeAdd.setTitle(Constant.add_Info);
	
		this.mJframeAdd.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//System.exit(1);
				mJframeAdd.dispose();
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == mJbConfirm) {
					if (!(mJtfAge.getText().equals(Constant.null_Char)) && mJtfAge.getText().matches("^\\d+$")) {
						mJlAImageR.setVisible(true);
						mJlAImageW.setVisible(false);
					}
					if (!(mJtfName.getText().equals(Constant.null_Char)) && mJtfName.getText().length() < 7 ) {
						mJlNImageR.setVisible(true);
						mJlNImageW.setVisible(false);
					}
					
					if (!(mJtfAge.getText().equals(Constant.null_Char)) && mJtfAge.getText().matches("^\\d+$") 
							&& !(mJtfName.getText().equals(Constant.null_Char)) && mJtfName.getText().length() < 7) {
						
						String name = mJtfName.getText();
						int age = Integer.parseInt(mJtfAge.getText());
						String sex = mJrbMan.isSelected()?mJrbMan.getText():mJrbWoman.getText();
						if (sex.equals(Constant.nan)) {
							sex = Constant.Sex_Man;
						}else {
							sex = Constant.Sex_Woman;
						}

						Person per = new Person(name, age);
						
						DBOperate dbo = new DBOperate();
						if (dbo.add(name, age,sex)) {
							superMJtextArea.setText(Constant.add_Succeed+"\n"+per.toString());
							superMJtextArea.setEnabled(false);
							JOptionPane.showMessageDialog(mJpanelAdd, Constant.add_Succeed);
							
							mJtfAge.setText(Constant.null_Char);
							mJtfName.setText(Constant.null_Char);
							
							mJlNImageR.setVisible(false);
							mJlNImageW.setVisible(false);
							mJlAImageR.setVisible(false);
							mJlAImageW.setVisible(false);
						}else {
							superMJtextArea.setText(Constant.add_Failed+"\n");
							
							JOptionPane.showMessageDialog(mJpanelAdd, Constant.add_Failed);
							
							mJtfAge.setText(Constant.null_Char);
							mJtfName.setText(Constant.null_Char);
							
							mJlNImageR.setVisible(false);
							mJlNImageW.setVisible(false);
							mJlAImageR.setVisible(false);
							mJlAImageW.setVisible(false);	
						}

//						mJframeAdd.dispose();	
					}else if (mJtfName.getText().equals(Constant.null_Char) || mJtfName.getText().length() > 6) {
						mJlNImageW.setVisible(true);
						mJlNImageR.setVisible(false);
					}else if (mJtfAge.getText().equals(Constant.null_Char) || !(mJtfAge.getText().matches("^\\d+$"))) {
						mJlAImageW.setVisible(true);
						mJlAImageR.setVisible(false);
					}
					
				}
				
			}
		}); 
		
		this.mJbCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbCancel) {
					mJframeAdd.dispose();
				}
				
			}
		});
	
		this.mJtfName.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e) { //失去焦点执行 
//				String nameContent = mJtfName.getText();
//			  	
//			  	if (!(nameContent.equals(Constant.null_Char)) && nameContent.length()<7) {
//			  		mJlNImageR.setVisible(true);
//			  		mJlNImageW.setVisible(false);
//				}else {
//					mJlNImageW.setVisible(true);
//					mJlNImageR.setVisible(false);
//				}
				
			}
			public void focusGained(FocusEvent e) {	//获得焦点执行的代码 
				 
			}
		});
		
		this.mJtfAge.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e) { //失去焦点执行 
//				String nameContent = mJtfAge.getText();
//				
//				if (nameContent != null && nameContent.matches("^\\d+$")) {
//					mJlAImageR.setVisible(true);
//					mJlAImageW.setVisible(false);
//				}else {
//					mJlAImageW.setVisible(true);
//					mJlAImageR.setVisible(false);
//				}
			}
			public void focusGained(FocusEvent e) {//获得焦点执行的代码
				 
			}
		});
		
	}
}
