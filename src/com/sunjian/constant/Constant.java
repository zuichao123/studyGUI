package com.sunjian.constant;

public interface Constant {
	/*ָ��Ŀ¼��*/
	public static String mIcom_Path = System.getProperty("user.dir")+"/files/sunjian/image/abao.jpg";
	public static String right = System.getProperty("user.dir")+"/files/sunjian/image/right.png" ;
	public static String wrong = System.getProperty("user.dir")+"/files/sunjian/image/wrong.gif" ;
	public static String person_Manager_Path = System.getProperty("user.dir")+"/files/sunjian/file/sjApp.sqlite";

	/*��Ŀ��Ŀ¼��*/
//	public static String mIcom_Path = System.getProperty("user.dir")+"/abao.jpg";
//	public static String right = System.getProperty("user.dir")+"/right.png" ;
//	public static String wrong = System.getProperty("user.dir")+"/wrong.gif" ;
//	public static String person_Manager_Path = System.getProperty("user.dir")+"/sjApp.sqlite";
	
	public static String system_Name = "*==*==*��Ա����ϵͳ*==*==*";
	public static String option_One = "��1������������";
	public static String option_Two = "��2����ɾ������";
	public static String option_Three = "��3�����޸�����";
	public static String option_Four = "��4�����鿴����";
	public static String option_Zero = "��0�����˳�ϵͳ";
	
	public static int WIDTH_WINDOW = 1368;
	public static int HEIGHT_WINDOW = 768;
	public static String[] font_Size = {"","1","2","3","4","0"};
	
	public static String cancel = "ȡ��";
	public static String confirm = "ȷ��";
	public static String age = "���䣺";
	public static String name = "������";
	public static String sex = "�Ա�";
	public static String shengri = "���գ�";
	
	public static String input_Error = "sorry��\n����������������ڣ����������룡";
	public static String songTi = "����";
	public static String null_Char = "";
	
	/*MyWindowUpdate*/
	public static String update_Info = "�޸���Ϣ";
	public static String update_Succeed = "�޸ĳɹ���";
	public static String update_Failed = "�޸�ʧ�ܣ�";
	public static String input_Error_Update = "sorry��\n�������ԭ���������ڣ����������룡";
	public static String old_Age = "ԭ���䣺";
	public static String old_Name = "ԭ������";
	
	/*MyWindowSelect*/
	public static String find_Info = "������Ϣ";
	public static String find_Name = "������Ҫ��ѯ��������";
	public static String find_Result = "��ѯ�����";
	public static String tips = "������ʾ��\n���롰all���ؼ��ֿ��Բ�ѯ������Ա��Ϣ��";
	
	/*MyWindowDelete*/
	public static String del_Info = "ɾ����Ϣ";
	public static String del_Name = "������Ҫɾ����������";
	public static String del_Succeed = "ɾ���ɹ���";
	public static String del_Failed = "ɾ��ʧ�ܣ�";
 	
	/*MyWindowAdd*/
	public static String add_Info = "�����Ϣ";
	public static String nan = "��";
	public static String nv = "Ů";
	public static String add_Succeed = "��ӳɹ���";
	public static String add_Failed = "���ʧ�ܣ�";
	
	/*MyWindow*/
	public static String main_Title = "��Ա����ϵͳ";
	public static String please_Input = "������";
	public static String please_Select = "��ѡ��";
	public static String result = "��  ����";
	public static String bye = "�ݰ�";
	public static String please_Choose = "��ѡ��...";
	
	public static String zero = "0";
	public static String one = "1";
	public static String two = "2";
	public static String three = "3";
	public static String four = "4";
	
	/*Main*/
	public static String error = "����";
	public static String table_Create_Failed = "person����ʧ�ܣ�";
	public static String db_Create_Failed = "���ݿⴴ��ʧ�ܣ�";
	
	/*******************DBOperate********************/
	//����MySql�����ݿ���������
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	//����Sqlite�����ݿ���������
	public static final String DBDRIVER_SQLITE = "org.sqlite.JDBC";
	
	//����Mysql�����ݿ����ӵ�ַ
	public static final String DBURL = "jdbc:mysql://localhost:3306/sjApp";
	//����Sqlite�����ݿ����ӵ�ַ
	public static final String DBURL_SQLITE =  "jdbc:sqlite:"+person_Manager_Path;

	//����Mysql�����ݿ��û���
	public static final String DBUSERNAME = "ikdb";
	
	//����Mysql�����ݿ�����
	public static final String DBPASSWORD = "123456";
	
	//������
	public static String table_Name = "person";
	
	//�ֶ���
	public static String Sex_Man = "man";
	public static String Sex_Woman = "woman";
	public static String birthday = "1987-12-05";
	public static String all = "all";
	
	//����SQL���==������
	public static String createDB_SQL = "create table person( id int AUTO_INCREMENT PRIMARY KEY, name varchar(30) not null, age int not null,sex varchar(5) default "+"\"man\""+", birthday DATE);";

	//����SQL���==����
	public static String insert_SQL = "insert into person(name,age,sex,birthday) values(?,?,?,?)";
	//����SQL���==ģ����ѯ������������
	public static String select_Dim = "select name,age,sex,birthday from person where name like ?";
	//����SQL���==��ѯȫ��������������
	public static String select_All = "select name,age,sex,birthday from person";
	//SQL���==ɾ��������������
	public static String delete_SQL = "delete from person where name like ?";
	//SQL���==���£�����������
	public static String update_SQL = "update person set name = ? ,age = ? where name like ?";
			
	//DBOperate���ݿ�������е�����ת����ʽ
	public static String date_Trans_Format = "yyyy-MM-dd";
}
