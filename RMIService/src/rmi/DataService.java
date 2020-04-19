package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataService extends Remote
{
	public String getData() throws RemoteException;
	public void createTable() throws RemoteException;
	public void insertTable(Student stu) throws RemoteException;
	public Student getStu(String stuNo) throws RemoteException;
}
