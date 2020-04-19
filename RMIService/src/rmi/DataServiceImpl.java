package rmi;
import java.rmi.server.*;
import java.rmi.*;

public class DataServiceImpl extends UnicastRemoteObject implements DataService {
	private static final long serialVersionUID = -7777277221L;
	public DataServiceImpl() throws RemoteException
	{
		super();
	}
	@Override
	public void createTable() throws RemoteException {
		DBmanager.createTable();
	}
	@Override
	public void insertTable(Student stu) throws RemoteException {
		DBmanager.insert(stu);
	}
	@Override
	public Student getStu(String stuNo) throws RemoteException {
		return DBmanager.getStu(stuNo);
	}
	@Override
	public String getData() throws RemoteException {
		return "hello world";
	}
	

}
