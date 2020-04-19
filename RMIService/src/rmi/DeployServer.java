package rmi;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DeployServer {

	public DeployServer() {}

	public static void main(String[] args) {
		// 创建并安装安全管理器
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			// 创建远程对象
			TimeServiceImpl ts = new TimeServiceImpl();
			DataServiceImpl ds = new DataServiceImpl();

			// 启动注册服务,如果没有这个语句，需要手工启动：开始菜单--运行--rmiregistry，默认端口1099
			LocateRegistry.createRegistry(1111);   //这里，服务端口号可任意指定
			
			// 远程对象绑定到服务
			Naming.rebind("//localhost:1111/ts", ts);
			Naming.rebind("//localhost:1111/ds", ds);

			System.out.println("RMI服务器正在运行。。。。。。");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final String userName = "root";
		final String password = "root";
		final String dburl = "jdbc:mysql://localhost:3306/midware";
		final String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		    DriverManager.getConnection(dburl,userName,password);
			System.out.println("数据库驱动连接成功");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到数据库驱动");
		} catch (SQLException e) {
			System.out.println("数据库连接出现异常，可能是由于数据库服务未启动");
		}

	}
}
