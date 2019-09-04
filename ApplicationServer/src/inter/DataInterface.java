package inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataInterface extends Remote {
    public void saveImage(byte[] image, String filename) throws RemoteException;
    public byte[] openImage(String filename) throws RemoteException;
    public String teste(String msg) throws RemoteException;
}