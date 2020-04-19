package rmi;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DeployServer {

	public DeployServer() {}

	public static void main(String[] args) {
		// ��������װ��ȫ������
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			// ����Զ�̶���
			TimeServiceImpl ts = new TimeServiceImpl();
			DataServiceImpl ds = new DataServiceImpl();

			// ����ע�����,���û�������䣬��Ҫ�ֹ���������ʼ�˵�--����--rmiregistry��Ĭ�϶˿�1099
			LocateRegistry.createRegistry(1111);   //�������˿ںſ�����ָ��
			
			// Զ�̶���󶨵�����
			Naming.rebind("//localhost:1111/ts", ts);
			Naming.rebind("//localhost:1111/ds", ds);

			System.out.println("RMI�������������С�����������");
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
			System.out.println("���ݿ��������ӳɹ�");
		} catch (ClassNotFoundException e) {
			System.out.println("û���ҵ����ݿ�����");
		} catch (SQLException e) {
			System.out.println("���ݿ����ӳ����쳣���������������ݿ����δ����");
		}

	}
}
