import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppInterface extends Remote {
    public byte[] applyFilter(byte[] img) throws RemoteException;
    public String test(String msg) throws RemoteException;
}