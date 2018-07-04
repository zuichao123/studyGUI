package com.sunjian.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sunjian.constant.Constant;

/**
 * ���ݿ����
 * 
 * �������ݿ⣺
 * 			create DATABASE sjApp;
 * 		������
 *	 		create table person(
 *				id int AUTO_INCREMENT PRIMARY KEY,
 *				name varchar(30) not null,
 *				age int not null,
 *				sex varchar(5) default "man",
 *				birthday DATE
 *			);
 * 
 * @author sunjian
 *
 */
public class DBOperate {
	
	Connection conn = null;//���ݿ����Ӷ���
	DatabaseMetaData meta = null;
	PreparedStatement pste = null;//�������ݿ�Ķ���
	ResultSet rs = null;//�����ѯ����Ķ���
	
	java.sql.Date birthday = riQi(Constant.birthday);
	
	public DBOperate(){
		try {
			//Class.forName(Constant.DBDRIVER);//������������
			Class.forName(Constant.DBDRIVER_SQLITE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �������ݿ�(���ڴ�����ʱ����)(�ж����ݿ��ļ��Ƿ����)
	 * ������ݿⲻ���ھʹ�����������ݿ���ھͲ�������
	 * 		
	 * @return flag
	 */
	public boolean createDB(){
		boolean flag = false;
		
			File file = new File(Constant.person_Manager_Path);
			if (!file.exists()) {
				try {
					if (file.createNewFile()) {
						flag = true;
					}else {
						flag = false;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				flag = true;
			}	
		return flag;
	}

	/**
	 * �������ݿ��е�person��
	 * 		������֮ǰ��Ҫ���������ݿ⣨����loadDBDrives()������
	 * @return �����ɹ�����true
	 */
	public boolean createTable() {
		boolean flag = false;
		
		try {
			conn = DriverManager.getConnection(Constant.DBURL_SQLITE);
			if (conn != null) {
				//�жϱ��Ƿ���ڣ�������ھͲ���������������ھ�ִ�д���
				meta = conn.getMetaData();
				rs = meta.getTables(null, null, Constant.table_Name, null);
				if (rs.next()) {
					flag = true;
					rs.close();//�رղ�ѯ�����
				}else {					
					pste = conn.prepareStatement(Constant.createDB_SQL);//ʵ����PreparedStatement����
					
					int line = -1; 
					line = pste.executeUpdate();//ִ�и���***********
					if (line != -1) {
						flag = true;
					}else {
						flag = false;
					}
					pste.close();//�ر����ݿ����
				}
			}else {
				flag = false;
			}
			conn.close();//�ر����ݿ�����
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * �������
	 * @param name ���ս������������
	 * @param age ���ս������������
	 */
	public boolean add(String name,int age,String sex) {
		boolean flag = false;
	
		try {
			//����mySql���ݿ�
			//conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSERNAME, Constant.DBPASSWORD);
			//����sqlite���ݿ�
			conn = DriverManager.getConnection(Constant.DBURL_SQLITE);
			if (conn != null) {
				pste = conn.prepareStatement(Constant.insert_SQL);//ʵ����PreparedStatement����
				//��������
				pste.setString(1, name);//�滻SQL����еĵ�һ���ʺ�
				pste.setInt(2, age);
				pste.setString(3, sex);
				pste.setDate(4, birthday);
				
				int line = pste.executeUpdate();//ִ�и���***********
				if (line > 0) {
					flag = true;
				}else {
					flag = false;
				}				
				flag = true;
			}else {
				flag = false;
			}
			pste.close();//�ر����ݿ����
			conn.close();//�ر����ݿ�����
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * ɾ����Ϣ
	 * @param name ���ݽ��ս������������������ɾ����ģ����
	 * @return ɾ���ɹ�����true
	 */
	public boolean delete(String name){
		boolean flag = false;
		
		if (find(name) != null) {
			try {
				//����mySql���ݿ�
				//conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSERNAME, Constant.DBPASSWORD);
				//����sqlite���ݿ�
				conn = DriverManager.getConnection(Constant.DBURL_SQLITE);
				if (conn != null) {
				
					pste = conn.prepareStatement(Constant.delete_SQL);
					
					//ɾ�����ݣ���ѯ����������������Ϣ��
					pste.setString(1, "%"+name+"%");//�滻SQL����еĵ�һ���ʺ�
					
					int line = pste.executeUpdate();
					if (line > 0) {								
						flag = true;
					}else {
						flag = false;
					}
				}else {
					flag = false;
				}
				pste.close();//�ر����ݿ����
				conn.close();//�ر����ݿ�����
			}catch (Exception e){
				e.printStackTrace();
				flag = false;
			}
		}else {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * ������Ϣ
	 * @param oldName ���ս��������ԭ����
	 * @param newName ���ս��������������
	 * @param newAge ���ս��������������
	 * @return
	 */
	public boolean update(String oldName,String newName,int newAge){
		boolean flag = false;
		
		if (find(oldName) != null) {
			try {
				//����mySql���ݿ�
				//conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSERNAME, Constant.DBPASSWORD);
				//����sqlite���ݿ�
				conn = DriverManager.getConnection(Constant.DBURL_SQLITE);
				if (conn != null) {
				
					pste = conn.prepareStatement(Constant.update_SQL);
					
					//ɾ�����ݣ���ѯ����������������Ϣ��
					pste.setString(1, newName);//�滻SQL����еĵ�һ���ʺ�
					pste.setInt(2, newAge);
					pste.setString(3, "%"+oldName+"%");
					
					int line = pste.executeUpdate();
					if (line > 0) {								
						flag = true;
					}else {
						flag = false;
					}
				}else {
					flag = false;
				}
				pste.close();//�ر����ݿ����
				conn.close();//�ر����ݿ�����
			}catch (Exception e){
				e.printStackTrace();
				flag = false;
			}
		}else {
			flag = false;
		}
		return flag;
	}
	
	
	/**
	 * ������Ϣ
	 * @param name ���ս��������������ģ����
	 * @return ���ذ����������������������Ա��������Ϣ
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String find(String name){
		
		String result = Constant.null_Char;
		List list = new ArrayList();
		
		int age = 0;
		String sex = Constant.null_Char;
		java.util.Date date = null;
		
		try {
			//����mySql���ݿ�
			//conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSERNAME, Constant.DBPASSWORD);
			//����sqlite���ݿ�
			conn = DriverManager.getConnection(Constant.DBURL_SQLITE);
			if (conn != null) {
			
				if (name.equals(Constant.all)) {
					//��ѯ���ݣ���ѯȫ����
					pste = conn.prepareStatement(Constant.select_All);
				}else {
					//��ѯ���ݣ�ģ����ѯ��
					pste = conn.prepareStatement(Constant.select_Dim);
					//�滻SQL����еĵ�һ���ʺ�
					pste.setString(1, "%"+name+"%");
				}
				
				rs = pste.executeQuery();//ִ�в�ѯ*************
				
				if (rs != null && !(rs.equals(""))) {
					while(rs.next()){
						name = rs.getString(1);
						list.add(Constant.name+name);
						age = rs.getInt(2);
						list.add(Constant.age+age);
						sex = rs.getString(3);
						list.add(Constant.sex+sex);
						date = rs.getDate(4);	
						list.add(Constant.shengri+date+"\n");
					}
					for(int i=0;i<list.size();i++){
						result += list.get(i)+"\n";
					}
				}else {
					result = null;
				}
			}else {
				result = null;
			}
			rs.close();//�رղ�ѯ�����
			pste.close();//�ر����ݿ����
			conn.close();//�ر����ݿ�����
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *  ��
	 * java.util.Date��ʽ��ʱ��
	 * ת����
	 * java.sql.Date��ʽ��ʱ��
	 */
	private static java.sql.Date riQi(String shengRi){
		java.util.Date temp = null;
		java.sql.Date birthday = null;
		
		try {
			temp = new SimpleDateFormat(Constant.date_Trans_Format).parse(shengRi);
			birthday = new java.sql.Date(temp.getTime());
		} catch (ParseException e1) {	
			e1.printStackTrace();
		}
		
		return birthday;
	}
	
	
	public static void main(String[] args) {
	}
	
}
