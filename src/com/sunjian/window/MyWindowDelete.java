package com.sunjian.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sunjian.constant.Constant;
import com.sunjian.dao.DBOperate;


public class MyWindowDelete extends MyWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int myJFrameGetX = 0;
	private int myJFrameGetY = 0;
	
	JFrame mJframeDel;
	JPanel mJpanelDel;
	
	JLabel mJlName;
	
	JTextField mJtfName;
	
	JButton mJbConfirm;
	JButton mJbCancel;
	
	ImageIcon mIcon;
	JLabel mJlNImageR;
	JLabel mJlNImageW;
	
	public MyWindowDelete(JFrame mJFrame){
		this.myJFrameGetX = mJFrame.getX();
		this.myJFrameGetY = mJFrame.getY();
		
		this.mJframeDel = new JFrame();
		this.mJpanelDel = new JPanel();
		
		this.mJlName = new JLabel(Constant.del_Name);
		this.mJtfName = new JTextField();
		
		
		this.mJbConfirm = new JButton(Constant.confirm);
		this.mJbCancel = new JButton(Constant.cancel);
		
		this.mIcon = new ImageIcon(Constant.right);
		this.mJlNImageR = new JLabel(this.mIcon);
		
		this.mIcon = new ImageIcon(Constant.wrong);
		this.mJlNImageW = new JLabel(this.mIcon);
	}

	public void delete(){
		
		this.setLayout(null);
		this.mJpanelDel.setLayout(null);
		
		this.mJlName.setSize(150, 100);
		this.mJlName.setLocation(70, 0);
		this.mJlName.setFont(new Font(Constant.songTi, Font.BOLD, 14));
		this.mJpanelDel.add(mJlName);
		
		this.mJtfName.setSize(150, 25);
		this.mJtfName.setLocation(this.mJlName.getX()+150, this.mJlName.getY()+35);
		this.mJtfName.setBackground(Color.WHITE);
		this.mJpanelDel.add(mJtfName);
		
		this.mJlNImageR.setSize(25,25);
		this.mJlNImageR.setLocation(mJtfName.getX() + 160,mJlName.getY() + 30);
		this.mJpanelDel.add(mJlNImageR);
		this.mJlNImageR.setVisible(false);
		
		this.mJlNImageW.setSize(25,25);
		this.mJlNImageW.setLocation(mJtfName.getX() + 160,mJtfName.getY());
		this.mJpanelDel.add(mJlNImageW);
		this.mJlNImageW.setVisible(false);
	
		this.mJbConfirm.setSize(60, 60);
		this.mJbConfirm.setLocation(110, 280);
//		this.mJbConfirm.setFont(new Font(Constant.songTi, Font.BOLD, 10));
		this.mJpanelDel.add(mJbConfirm);
		
		this.mJbCancel.setSize(60, 60);
		this.mJbCancel.setLocation(this.mJbConfirm.getX() + 160, this.mJbConfirm.getY());
//		this.mJbCancel.setFont(new Font(Constant.songTi, Font.BOLD, 10));
		this.mJpanelDel.add(mJbCancel);
			
		this.mJframeDel.getContentPane().add(mJpanelDel,BorderLayout.CENTER);
		
		this.mJframeDel.setSize(460, 400);
		this.mJframeDel.setLocation(myJFrameGetX + 185,myJFrameGetY + 100);
		this.mJframeDel.setResizable(false);
		this.mJframeDel.setVisible(true);
		this.mJframeDel.setAlwaysOnTop(true);
		this.mJframeDel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.mJframeDel.setTitle(Constant.del_Info);
		
		
		this.mJframeDel.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//System.exit(1);
				mJframeDel.dispose();
			}
		});
		
		this.mJbCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbCancel) {
					mJframeDel.dispose();
				}
				
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbConfirm) {
					
					if (!(mJtfName.getText().equals(Constant.null_Char)) && mJtfName.getText().length() < 7) {
						
						mJlNImageR.setVisible(true);
						mJlNImageW.setVisible(false);
						
						String name = mJtfName.getText();
						boolean flag = false;
						
						DBOperate dbo = new DBOperate();
						String content = dbo.find(name);
						flag = dbo.delete(name);
						
						if (content != null && flag == true) {
							JOptionPane.showMessageDialog(mJpanelDel, Constant.del_Succeed);
							mJtfName.setText(Constant.null_Char);
							mJlNImageR.setVisible(false);
							mJlNImageW.setVisible(false);
						}else {
							JOptionPane.showMessageDialog(mJpanelDel, Constant.input_Error);
							mJtfName.setText(Constant.null_Char);
							mJlNImageR.setVisible(false);
							mJlNImageW.setVisible(false);
						}	
						
					}else if(mJtfName.getText().equals(Constant.null_Char) || mJtfName.getText().length() > 6){
						mJlNImageW.setVisible(true);
						mJlNImageR.setVisible(false);
					}
				}
			}
		});
	}
	
}
