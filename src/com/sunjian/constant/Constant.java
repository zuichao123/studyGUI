package com.sunjian.constant;

public interface Constant {
	/*指定目录下*/
	public static String mIcom_Path = System.getProperty("user.dir")+"/files/sunjian/image/abao.jpg";
	public static String right = System.getProperty("user.dir")+"/files/sunjian/image/right.png" ;
	public static String wrong = System.getProperty("user.dir")+"/files/sunjian/image/wrong.gif" ;
	public static String person_Manager_Path = System.getProperty("user.dir")+"/files/sunjian/file/sjApp.sqlite";

	/*项目根目录下*/
//	public static String mIcom_Path = System.getProperty("user.dir")+"/abao.jpg";
//	public static String right = System.getProperty("user.dir")+"/right.png" ;
//	public static String wrong = System.getProperty("user.dir")+"/wrong.gif" ;
//	public static String person_Manager_Path = System.getProperty("user.dir")+"/sjApp.sqlite";
	
	public static String system_Name = "*==*==*人员管理系统*==*==*";
	public static String option_One = "【1】、增加数据";
	public static String option_Two = "【2】、删除数据";
	public static String option_Three = "【3】、修改数据";
	public static String option_Four = "【4】、查看数据";
	public static String option_Zero = "【0】、退出系统";
	
	public static int WIDTH_WINDOW = 1368;
	public static int HEIGHT_WINDOW = 768;
	public static String[] font_Size = {"","1","2","3","4","0"};
	
	public static String cancel = "取消";
	public static String confirm = "确定";
	public static String age = "年龄：";
	public static String name = "姓名：";
	public static String sex = "性别：";
	public static String shengri = "生日：";
	
	public static String input_Error = "sorry！\n您输入的姓名不存在，请重新输入！";
	public static String songTi = "宋体";
	public static String null_Char = "";
	
	/*MyWindowUpdate*/
	public static String update_Info = "修改信息";
	public static String update_Succeed = "修改成功！";
	public static String update_Failed = "修改失败！";
	public static String input_Error_Update = "sorry！\n您输入的原姓名不存在，请重新输入！";
	public static String old_Age = "原年龄：";
	public static String old_Name = "原姓名：";
	
	/*MyWindowSelect*/
	public static String find_Info = "查找信息";
	public static String find_Name = "请输入要查询的姓名：";
	public static String find_Result = "查询结果：";
	public static String tips = "友情提示：\n输入“all”关键字可以查询所有人员信息！";
	
	/*MyWindowDelete*/
	public static String del_Info = "删除信息";
	public static String del_Name = "请输入要删除的姓名：";
	public static String del_Succeed = "删除成功！";
	public static String del_Failed = "删除失败！";
 	
	/*MyWindowAdd*/
	public static String add_Info = "添加信息";
	public static String nan = "男";
	public static String nv = "女";
	public static String add_Succeed = "添加成功！";
	public static String add_Failed = "添加失败！";
	
	/*MyWindow*/
	public static String main_Title = "人员管理系统";
	public static String please_Input = "请输入";
	public static String please_Select = "请选择：";
	public static String result = "结  果：";
	public static String bye = "拜拜";
	public static String please_Choose = "请选择...";
	
	public static String zero = "0";
	public static String one = "1";
	public static String two = "2";
	public static String three = "3";
	public static String four = "4";
	
	/*Main*/
	public static String error = "错误";
	public static String table_Create_Failed = "person表创建失败！";
	public static String db_Create_Failed = "数据库创建失败！";
	
	/*******************DBOperate********************/
	//定义MySql的数据库驱动程序
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	//定义Sqlite的数据库驱动程序
	public static final String DBDRIVER_SQLITE = "org.sqlite.JDBC";
	
	//定义Mysql的数据库连接地址
	public static final String DBURL = "jdbc:mysql://localhost:3306/sjApp";
	//定义Sqlite的数据库连接地址
	public static final String DBURL_SQLITE =  "jdbc:sqlite:"+person_Manager_Path;

	//定义Mysql的数据库用户名
	public static final String DBUSERNAME = "ikdb";
	
	//定义Mysql的数据库密码
	public static final String DBPASSWORD = "123456";
	
	//表名字
	public static String table_Name = "person";
	
	//字段名
	public static String Sex_Man = "man";
	public static String Sex_Woman = "woman";
	public static String birthday = "1987-12-05";
	public static String all = "all";
	
	//定义SQL语句==创建表
	public static String createDB_SQL = "create table person( id int AUTO_INCREMENT PRIMARY KEY, name varchar(30) not null, age int not null,sex varchar(5) default "+"\"man\""+", birthday DATE);";

	//定义SQL语句==插入
	public static String insert_SQL = "insert into person(name,age,sex,birthday) values(?,?,?,?)";
	//定义SQL语句==模糊查询（根据姓名）
	public static String select_Dim = "select name,age,sex,birthday from person where name like ?";
	//定义SQL语句==查询全部（根据姓名）
	public static String select_All = "select name,age,sex,birthday from person";
	//SQL语句==删除（根据姓名）
	public static String delete_SQL = "delete from person where name like ?";
	//SQL语句==更新（根据姓名）
	public static String update_SQL = "update person set name = ? ,age = ? where name like ?";
			
	//DBOperate数据库操作类中的日期转换格式
	public static String date_Trans_Format = "yyyy-MM-dd";
}
