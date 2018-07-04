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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sunjian.constant.Constant;
import com.sunjian.dao.DBOperate;

public class MyWindowSelect extends MyWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int myJFrameGetX = 0;
	private int myJFrameGetY = 0;
	
	JFrame mJframeFind;
	JPanel mJpanelFind;
	
	JLabel mJlName;
	JLabel mJlFindResult;
	
	JTextField mJtfName;
	JTextArea mJtaFindResult;
	JScrollPane mJScrollPane;
	
	JButton mJbConfirm;
	JButton mJbCancel;
	
	ImageIcon mIcon;
	JLabel mJlNImageR;
	JLabel mJlNImageW;
	
	public MyWindowSelect(JFrame mJFrame){
		this.myJFrameGetX = mJFrame.getX();
		this.myJFrameGetY = mJFrame.getY();
		
		this.mJframeFind = new JFrame();
		this.mJpanelFind = new JPanel();
		
		this.mJlName = new JLabel(Constant.find_Name);
		this.mJtfName = new JTextField();
		
		this.mJlFindResult = new JLabel(Constant.find_Result);
		this.mJtaFindResult = new JTextArea(Constant.tips);
		
		this.mJbConfirm = new JButton(Constant.confirm);
		this.mJbCancel = new JButton(Constant.cancel);
		
		this.mIcon = new ImageIcon(Constant.right);
		this.mJlNImageR = new JLabel(this.mIcon);
		
		this.mIcon = new ImageIcon(Constant.wrong);
		this.mJlNImageW = new JLabel(this.mIcon);
	}

	public void look(){
		
		this.setLayout(null);
		this.mJpanelFind.setLayout(null);
		
		this.mJlName.setSize(150, 100);
		this.mJlName.setLocation(70, 0);
		this.mJlName.setFont(new Font(Constant.songTi, Font.BOLD, 14));
		this.mJpanelFind.add(mJlName);
		
		this.mJtfName.setSize(150, 25);
		this.mJtfName.setLocation(this.mJlName.getX()+150, this.mJlName.getY()+35);
		this.mJtfName.setBackground(Color.WHITE);
		this.mJpanelFind.add(mJtfName);
		
		this.mJlNImageR.setSize(25,25);
		this.mJlNImageR.setLocation(mJtfName.getX() + 160,mJlName.getY() + 30);
		this.mJpanelFind.add(mJlNImageR);
		this.mJlNImageR.setVisible(false);
		
		this.mJlNImageW.setSize(25,25);
		this.mJlNImageW.setLocation(mJtfName.getX() + 160,mJtfName.getY());
		this.mJpanelFind.add(mJlNImageW);
		this.mJlNImageW.setVisible(false);
		
		this.mJtaFindResult.setSize(300, 180);
		this.mJtaFindResult.setLocation(this.mJlName.getX(), this.mJlName.getY()+70);
		this.mJtaFindResult.setBackground(Color.WHITE);
		this.mJtaFindResult.setForeground(Color.lightGray);
		this.mJtaFindResult.setEnabled(false);//可编辑
		this.mJtaFindResult.setLineWrap(true);//自动换行
		this.mJpanelFind.add(mJtaFindResult);
		
		this.mJScrollPane = new JScrollPane(mJtaFindResult);
		this.mJScrollPane.setSize(this.mJtaFindResult.getWidth(), this.mJtaFindResult.getHeight());
		this.mJScrollPane.setLocation(this.mJtaFindResult.getX(), this.mJtaFindResult.getY());
		this.mJpanelFind.add(mJScrollPane);
	
		this.mJbConfirm.setSize(60, 60);
		this.mJbConfirm.setLocation(110, 280);
//		this.mJbConfirm.setFont(new Font(Constant.songTi, Font.BOLD, 10));
		this.mJpanelFind.add(mJbConfirm);
		
		this.mJbCancel.setSize(60, 60);
		this.mJbCancel.setLocation(this.mJbConfirm.getX() + 160, this.mJbConfirm.getY());
//		this.mJbCancel.setFont(new Font(Constant.songTi, Font.BOLD, 10));
		this.mJpanelFind.add(mJbCancel);
			
		this.mJframeFind.getContentPane().add(mJpanelFind,BorderLayout.CENTER);
		
		this.mJframeFind.setSize(460, 400);
		this.mJframeFind.setLocation(myJFrameGetX + 185,myJFrameGetY + 100);
		this.mJframeFind.setResizable(false);
		this.mJframeFind.setVisible(true);
		this.mJframeFind.setAlwaysOnTop(true);
		this.mJframeFind.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.mJframeFind.setTitle(Constant.find_Info);
		
		
		this.mJframeFind.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//System.exit(1);
				mJframeFind.dispose();
			}
		});
		
		this.mJbCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbCancel) {
					mJframeFind.dispose();
				}
				
			}
		});
		
		this.mJbConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mJbConfirm) {
					mJtaFindResult.setText(Constant.null_Char);
					
					if (!(mJtfName.getText().equals(Constant.null_Char)) && mJtfName.getText().length() < 7) {
						
						mJlNImageR.setVisible(true);
						mJlNImageW.setVisible(false);
						
						String name = mJtfName.getText();
						
						DBOperate dbo = new DBOperate();
						String content = dbo.find(name);
						
						if (content != null) {
							if (name.equals("all") || content.contains(name)) {
								mJtaFindResult.setText(content);
								mJtaFindResult.setForeground(Color.BLACK);
							}else {	
								JOptionPane.showMessageDialog(mJpanelFind, Constant.input_Error);
							}
						}else {
							mJtfName.setText(Constant.null_Char);
							mJlNImageR.setVisible(false);
							mJlNImageW.setVisible(false);
							
							JOptionPane.showMessageDialog(mJpanelFind, Constant.input_Error);
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
