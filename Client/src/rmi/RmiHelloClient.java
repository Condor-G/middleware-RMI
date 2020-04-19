package rmi;
import java.rmi.*;
public class RmiHelloClient {
	public static void main(String[] args) {
		// 创建并安装安全管理器
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			TimeService ts = (TimeService) Naming.lookup("//localhost:1111/ts");
			DataService ds = (DataService) Naming.lookup("//localhost:1111/ds");
			
			
			//System.out.println(ds.getData());
			System.out.println("time: " + ts.getTime());
			
			try{
				//ds.createTable();
				Student stu = new Student("2017123456","阿水",98.0f); ds.insertTable(stu);
				Student t = ds.getStu("2017123456"); System.out.println(t.toString());
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Client wrong");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
