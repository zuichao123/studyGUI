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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sunjian.constant.Constant;
import com.sunjian.dao.DBOperate;


public class MyWindowUpdate extends MyWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int myJFrameGetX = 0;
	private int myJFrameGetY = 0;
	
	/**************init*******************/
	JFrame mJframeUpdate;
	JPanel mJpanelUpdate;
	
	JLabel mJlName;
	JLabel mJlAge;
	
	JTextField mJtfName;
	JTextField mJtfAge;
	
	JLabel mJlOldName;
	JLabel mJlOldAge;
	
	JTextField mJtfOldName;
	JTextField mJtfOldAge;
	
	JButton mJbConfirm;
	JButton mJbCancel;
	
	ImageIcon mIcon;
	JLabel mJlNImageR;
	JLabel mJlNImageW;
	JLabel mJlAImageR;
	JLabel mJlAImageW;

	JLabel mJlOldNImageR;
	JLabel mJlOldNImageW;
	JLabel mJlOldAImageR;
	JLabel mJlOldAImageW;
	
	JTextArea superMJtextArea;
	
	public MyWindowUpdate(JFrame mJFrame,JTextArea mJTextArea){
		this.myJFrameGetX = mJFrame.getX();
		this.myJFrameGetY = mJFrame.getY();
		this.superMJtextArea = mJTextArea;
		
		/*********定义组件***************/
		this.mJframeUpdate = new JFrame();
		this.mJpanelUpdate = new JPanel();
		
		this.mJlName = new JLabel(Constant.name);
		this.mJlAge = new JLabel(Constant.age);
		
		this.mJlOldName = new JLabel(Constant.old_Name);
		this.mJlOldAge = new JLabel(Constant.old_Age);
		
		this.mJtfName = new JTextField();
		this.mJtfAge = new JTextField();
		
		this.mJtfOldName = new JTextField();
		this.mJtfOldAge = new JTextField();
		
		this.mJbConfirm = new JButton(Constant.confirm);
		this.mJbCancel = new JButton(Constant.cancel);	
	}
	
	
	/*创建窗口*/
	public void update(){
		
		/*********************画组件**************************/
		this.mJlOldName.setSize(100, 100);
		this.mJlOldName.setLocation(58, 5);
		this.mJlOldName.setFont(new Font(Constant.songTi, Font.BOLD, 14));
		this.mJpanelUpdate.add(mJlOldName);
		
		this.mJtfOldName.setSize(80, 25);
		this.mJtfOldName.setLocation(this.mJlOldName.getX()+60, this.mJlOldName.getY()+38);
		this.mJtfOldName.setBackground(Color.WHITE);
		this.mJpanelUpdate.add(mJtfOldName);
		
		this.mIcon = new ImageIcon(Constant.right);
		this.mJlOldNImageR = new JLabel(mIcon);
		this.mJlOldNImageR.setSize(25,25);
		this.mJlOldNImageR.setLocation(this.mJtfOldName.getX() + 100,mJtfOldName.getY());
		this.mJpanelUpdate.add(mJlOldNImageR);
		this.mJlOldNImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(Constant.wrong);
		this.mJlOldNImageW = new JLabel(mIcon);
		this.mJlOldNImageW.setSize(25,25);
		this.mJlOldNImageW.setLocation(mJtfOldName.getX() + 100,mJtfOldName.getY());
		this.mJpanelUpdate.add(mJlOldNImageW);
		this.mJlOldNImageW.setVisible(false);
		
		this.mJlName.setSize(100, 100);
		this.mJlName.setLocation(this.mJlOldName.getX()+200,this.mJlOldName.getY());
		this.mJlName.setFont(new Font(Constant.songTi, Font.BOLD, 14));
		this.mJpanelUpdate.add(mJlName);
		
		this.mJtfName.setSize(80, 25);
		this.mJtfName.setLocation(this.mJlName.getX()+45, this.mJlName.getY()+38);
		this.mJtfName.setBackground(Color.WHITE);
		this.mJpanelUpdate.add(mJtfName);
		
		this.mIcon = new ImageIcon(Constant.right);
		this.mJlNImageR = new JLabel(mIcon);
		this.mJlNImageR.setSize(25,25);
		this.mJlNImageR.setLocation(mJtfName.getX() + 100,mJtfName.getY());
		this.mJpanelUpdate.add(mJlNImageR);
		this.mJlNImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(Constant.wrong);
		this.mJlNImageW = new JLabel(mIcon);
		this.mJlNImageW.setSize(25,25);
		this.mJlNImageW.setLocation(mJtfName.getX() + 100,mJtfName.getY());
		this.mJpanelUpdate.add(mJlNImageW);
		this.mJlNImageW.setVisible(false);
		
		this.mJlOldAge.setSize(100,100);
		this.mJlOldAge.setLocation(58, 40);
		this.mJlOldAge.setFont(new Font(Constant.songTi, Font.BOLD, 14));
		this.mJpanelUpdate.add(mJlOldAge);
		
		this.mJtfOldAge.setSize(80, 25);
		this.mJtfOldAge.setLocation(this.mJlOldAge.getX()+60, this.mJlOldAge.getY()+38);
		this.mJtfOldAge.setBackground(Color.WHITE);
		this.mJpanelUpdate.add(mJtfOldAge);
		
		this.mIcon = new ImageIcon(Constant.right);
		this.mJlOldAImageR = new JLabel(mIcon);
		this.mJlOldAImageR.setSize(25,25);
		this.mJlOldAImageR.setLocation(mJtfOldAge.getX() + 100,mJtfOldAge.getY());
		this.mJpanelUpdate.add(mJlOldAImageR);
		this.mJlOldAImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(Constant.wrong);
		this.mJlOldAImageW = new JLabel(mIcon);
		this.mJlOldAImageW.setSize(25,25);
		this.mJlOldAImageW.setLocation(mJtfOldAge.getX() + 100,mJtfOldAge.getY());
		this.mJpanelUpdate.add(mJlOldAImageW);
		this.mJlOldAImageW.setVisible(false);	
		
		this.mJlAge.setSize(100,100);
		this.mJlAge.setLocation(this.mJlOldAge.getX()+200, this.mJlOldAge.getY());
		this.mJlAge.setFont(new Font(Constant.songTi, Font.BOLD, 14));
		this.mJpanelUpdate.add(mJlAge);
		
		this.mJtfAge.setSize(80, 25);
		this.mJtfAge.setLocation(this.mJtfName.getX(), this.mJlAge.getY()+38);
		this.mJtfAge.setBackground(Color.WHITE);
		this.mJpanelUpdate.add(mJtfAge);
		
		this.mIcon = new ImageIcon(Constant.right);
		this.mJlAImageR = new JLabel(mIcon);
		this.mJlAImageR.setSize(25,25);
		this.mJlAImageR.setLocation(mJtfAge.getX() + 100,mJtfAge.getY());
		this.mJpanelUpdate.add(mJlAImageR);
		this.mJlAImageR.setVisible(false);
		
		this.mIcon = new ImageIcon(Constant.wrong);
		this.mJlAImageW = new JLabel(mIcon);
		this.mJlAImageW.setSize(25,25);
		this.mJlAImageW.setLocation(mJtfAge.getX() + 100,mJtfAge.getY());
		this.mJpanelUpdate.add(mJlAImageW);
		this.mJlAImageW.setVisible(false);
		
		this.mJbConfirm.setSize(60, 60);
		this.mJbConfirm.setLocation(120, 250);
		this.mJpanelUpdate.add(mJbConfirm);
		
		this.mJbCancel.setSize(60, 60);
		this.mJbCancel.setLocation(this.mJbConfirm.getX() + 160, this.mJbConfirm.getY());
		this.mJpanelUpdate.add(mJbCancel);
		
		this.setLayout(null);
		this.mJpanelUpdate.setLayout(null);
		
		this.mJframeUpdate.getContentPane().add(mJpanelUpdate, BorderLayout.CENTER);
		
		this.mJframeUpdate.setSize(460,400);
		this.mJframeUpdate.setLocation(myJFrameGetX + 185,myJFrameGetY + 100);
		this.mJframeUpdate.setResizable(false);
		this.mJframeUpdate.setVisible(true);
		this.mJframeUpdate.setAlwaysOnTop(true);
		this.mJframeUpdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.mJframeUpdate.setTitle(Constant.update_Info);
		
		
		this.mJframeUpdate.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//System.exit(1);
				mJframeUpdate.dispose();
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == mJbConfirm) {
					//原
					if (!(mJtfOldName.getText().equals(Constant.null_Char)) && mJtfOldName.getText().length() < 7) {
						mJlOldNImageR.setVisible(true);
						mJlOldNImageW.setVisible(false);
					}else {
						mJlOldNImageW.setVisible(true);
						mJlOldNImageR.setVisible(false);
					}
					if (!(mJtfOldAge.getText().equals(Constant.null_Char)) && mJtfOldAge.getText().matches("^\\d+$")) {
						mJlOldAImageR.setVisible(true);
						mJlOldAImageW.setVisible(false);
					}else {
						mJlOldAImageW.setVisible(true);
						mJlOldAImageR.setVisible(false);
					}
					
					//新
					if (!(mJtfAge.getText().equals(Constant.null_Char)) && mJtfAge.getText().matches("^\\d+$")) {
						mJlAImageR.setVisible(true);
						mJlAImageW.setVisible(false);
					}else if (mJtfAge.getText().equals(Constant.null_Char) || !(mJtfAge.getText().matches("^\\d+$"))) {
						mJlAImageW.setVisible(true);
						mJlAImageR.setVisible(false);
					}
					
					if (!(mJtfName.getText().equals(Constant.null_Char)) && mJtfName.getText().length() < 7) {
						mJlNImageR.setVisible(true);
						mJlNImageW.setVisible(false);
					}else if (mJtfName.getText().equals(Constant.null_Char) || mJtfName.getText().length() > 6) {
						mJlNImageW.setVisible(true);
						mJlNImageR.setVisible(false);
					}
	
					if (!(mJtfAge.getText().equals(Constant.null_Char)) && mJtfAge.getText().matches("^\\d+$") 
							&& !(mJtfName.getText().equals(Constant.null_Char)) && mJtfName.getText().length() < 7
							&& !(mJtfOldAge.getText().equals(Constant.null_Char)) && mJtfOldAge.getText().matches("^\\d+$") 
							&& !(mJtfOldName.getText().equals(Constant.null_Char)) && mJtfOldName.getText().length() < 7) {
						
						String newName = mJtfName.getText();
						int newAge = Integer.parseInt(mJtfAge.getText());
						String oldName = mJtfOldName.getText();
//						int oldAge = Integer.parseInt(mJtfOldAge.getText());
						
						DBOperate dbo = new DBOperate();
						boolean flag = dbo.update(oldName, newName, newAge);
						
						if (dbo.find(oldName) != null && flag == true) {
							superMJtextArea.setText(Constant.update_Succeed + "\n"+dbo.find(newName));
							
							JOptionPane.showMessageDialog(mJpanelUpdate, Constant.update_Succeed);
							
							mJtfOldName.setText(Constant.null_Char);
							mJtfOldAge.setText(Constant.null_Char);
							mJtfName.setText(Constant.null_Char);
							mJtfAge.setText(Constant.null_Char);
							
							mJlOldNImageR.setVisible(false);
							mJlOldNImageW.setVisible(false);
							mJlOldAImageR.setVisible(false);
							mJlOldAImageW.setVisible(false);
							
							mJlNImageR.setVisible(false);
							mJlNImageW.setVisible(false);
							mJlAImageR.setVisible(false);
							mJlAImageW.setVisible(false);
						}else {
							mJtfOldName.setText(Constant.null_Char);
							mJtfOldAge.setText(Constant.null_Char);
							mJlOldNImageR.setVisible(false);
							mJlOldNImageW.setVisible(false);
							mJlOldAImageR.setVisible(false);
							mJlOldAImageW.setVisible(false);
							JOptionPane.showMessageDialog(mJpanelUpdate, Constant.input_Error_Update);
						}
												
					}
				}
	
			}
		});
		
		this.mJbCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbCancel) {
					mJframeUpdate.dispose();
				}
				
			}
		});
	
		this.mJtfName.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e) {  
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
			 public void focusGained(FocusEvent e) {
			//获得焦点执行的代码 
			}
		});
		
		this.mJtfAge.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent e) {  
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
			public void focusGained(FocusEvent e) {
				//获得焦点执行的代码 
			}
		});
		
	}
	
}
