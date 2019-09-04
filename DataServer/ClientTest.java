import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientTest {
    public static void main(String[] args) {
        try {
            DataInterface data = (DataInterface) Naming.lookup("rmi://localhost/DataServer");

            System.out.println(data.teste("Testando conexão"));
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}