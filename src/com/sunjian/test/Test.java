package com.sunjian.test;

import javax.swing.JOptionPane;

import com.sunjian.constant.Constant;
import com.sunjian.dao.DBOperate;
import com.sunjian.window.MyWindow;

public class Test {

	public static void main(String[] args) {
		DBOperate dbo = new DBOperate();
		MyWindow my = new MyWindow();
		
		if (dbo.createDB()) {			
			if (dbo.createTable()) {	
				my.run();
			}else {
				JOptionPane.showMessageDialog(null,Constant.table_Create_Failed,Constant.error,JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(null,Constant.db_Create_Failed,Constant.error,JOptionPane.ERROR_MESSAGE);
		}
	}
}
