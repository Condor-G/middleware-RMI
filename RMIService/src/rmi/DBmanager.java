package rmi;
import java.io.Serializable;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBmanager {
	private static final String userName = "root";
	private static final String password = "root";
	private static final String dburl = "jdbc:mysql://localhost:3306/midware";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static Statement stmt = null;
	
	public static Connection getConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,userName,password);
			System.out.println("数据库驱动连接成功");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到数据库驱动");
		} catch (SQLException e) {
			System.out.println("数据库连接出现异常，可能是由于数据库服务未启动");
		}
		return conn;
	}
	public static void createTable() {
		String sql = "create table stu(stuNo varchar(20) PRIMARY KEY,stuName varchar(20),grade float);";
		conn = getConn();
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insert(Student stu) {
		String sql = "insert into stu values('"+stu.getStuNo()+"','"+stu.getStuName()+"',"+stu.getGrade()+");";
		System.out.println(sql);
		conn = getConn();
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static Student getStu(String stuNo) {
		String sql = "select * from stu where stuNo ='"+stuNo+"'";
		conn = getConn();
		Student stu = new Student();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				stu.setStuNo(rs.getString(1));
				stu.setStuName(rs.getString(2));
				stu.setGrade(rs.getFloat(3));
			}
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}

}
