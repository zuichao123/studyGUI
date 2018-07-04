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
 * 数据库操作
 * 
 * 创建数据库：
 * 			create DATABASE sjApp;
 * 		创建表：
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
	
	Connection conn = null;//数据库连接对象
	DatabaseMetaData meta = null;
	PreparedStatement pste = null;//操作数据库的对象
	ResultSet rs = null;//保存查询结果的对象
	
	java.sql.Date birthday = riQi(Constant.birthday);
	
	public DBOperate(){
		try {
			//Class.forName(Constant.DBDRIVER);//加载驱动程序
			Class.forName(Constant.DBDRIVER_SQLITE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建数据库(仅在创建表时调用)(判断数据库文件是否存在)
	 * 如果数据库不存在就创建，如果数据库存在就不创建；
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
	 * 创建数据库中的person表
	 * 		创建表之前需要先连接数据库（调用loadDBDrives()方法）
	 * @return 创建成功返回true
	 */
	public boolean createTable() {
		boolean flag = false;
		
		try {
			conn = DriverManager.getConnection(Constant.DBURL_SQLITE);
			if (conn != null) {
				//判断表是否存在，如果存在就不创建；如果不存在就执行创建
				meta = conn.getMetaData();
				rs = meta.getTables(null, null, Constant.table_Name, null);
				if (rs.next()) {
					flag = true;
					rs.close();//关闭查询结果集
				}else {					
					pste = conn.prepareStatement(Constant.createDB_SQL);//实例化PreparedStatement对象
					
					int line = -1; 
					line = pste.executeUpdate();//执行更新***********
					if (line != -1) {
						flag = true;
					}else {
						flag = false;
					}
					pste.close();//关闭数据库操作
				}
			}else {
				flag = false;
			}
			conn.close();//关闭数据库连接
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 添加内容
	 * @param name 接收界面输入的姓名
	 * @param age 接收界面输入的年龄
	 */
	public boolean add(String name,int age,String sex) {
		boolean flag = false;
	
		try {
			//连接mySql数据库
			//conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSERNAME, Constant.DBPASSWORD);
			//连接sqlite数据库
			conn = DriverManager.getConnection(Constant.DBURL_SQLITE);
			if (conn != null) {
				pste = conn.prepareStatement(Constant.insert_SQL);//实例化PreparedStatement对象
				//插入内容
				pste.setString(1, name);//替换SQL语句中的第一个问号
				pste.setInt(2, age);
				pste.setString(3, sex);
				pste.setDate(4, birthday);
				
				int line = pste.executeUpdate();//执行更新***********
				if (line > 0) {
					flag = true;
				}else {
					flag = false;
				}				
				flag = true;
			}else {
				flag = false;
			}
			pste.close();//关闭数据库操作
			conn.close();//关闭数据库连接
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * 删除信息
	 * @param name 根据接收界面输入的姓名，进行删除（模糊）
	 * @return 删除成功返回true
	 */
	public boolean delete(String name){
		boolean flag = false;
		
		if (find(name) != null) {
			try {
				//连接mySql数据库
				//conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSERNAME, Constant.DBPASSWORD);
				//连接sqlite数据库
				conn = DriverManager.getConnection(Constant.DBURL_SQLITE);
				if (conn != null) {
				
					pste = conn.prepareStatement(Constant.delete_SQL);
					
					//删除内容（查询到的姓名的所有信息）
					pste.setString(1, "%"+name+"%");//替换SQL语句中的第一个问号
					
					int line = pste.executeUpdate();
					if (line > 0) {								
						flag = true;
					}else {
						flag = false;
					}
				}else {
					flag = false;
				}
				pste.close();//关闭数据库操作
				conn.close();//关闭数据库连接
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
	 * 更新信息
	 * @param oldName 接收界面输入的原姓名
	 * @param newName 接收界面输入的新姓名
	 * @param newAge 接收界面输入的新年龄
	 * @return
	 */
	public boolean update(String oldName,String newName,int newAge){
		boolean flag = false;
		
		if (find(oldName) != null) {
			try {
				//连接mySql数据库
				//conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSERNAME, Constant.DBPASSWORD);
				//连接sqlite数据库
				conn = DriverManager.getConnection(Constant.DBURL_SQLITE);
				if (conn != null) {
				
					pste = conn.prepareStatement(Constant.update_SQL);
					
					//删除内容（查询到的姓名的所有信息）
					pste.setString(1, newName);//替换SQL语句中的第一个问号
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
				pste.close();//关闭数据库操作
				conn.close();//关闭数据库连接
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
	 * 查找信息
	 * @param name 接收界面输入的姓名（模糊）
	 * @return 返回包含所输入的姓名的所有人员的所有信息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String find(String name){
		
		String result = Constant.null_Char;
		List list = new ArrayList();
		
		int age = 0;
		String sex = Constant.null_Char;
		java.util.Date date = null;
		
		try {
			//连接mySql数据库
			//conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSERNAME, Constant.DBPASSWORD);
			//连接sqlite数据库
			conn = DriverManager.getConnection(Constant.DBURL_SQLITE);
			if (conn != null) {
			
				if (name.equals(Constant.all)) {
					//查询内容（查询全部）
					pste = conn.prepareStatement(Constant.select_All);
				}else {
					//查询内容（模糊查询）
					pste = conn.prepareStatement(Constant.select_Dim);
					//替换SQL语句中的第一个问号
					pste.setString(1, "%"+name+"%");
				}
				
				rs = pste.executeQuery();//执行查询*************
				
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
			rs.close();//关闭查询结果集
			pste.close();//关闭数据库操作
			conn.close();//关闭数据库连接
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *  将
	 * java.util.Date格式的时间
	 * 转换成
	 * java.sql.Date格式的时间
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
