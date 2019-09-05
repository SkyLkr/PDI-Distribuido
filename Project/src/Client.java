import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        try {
            AppInterface app = (AppInterface) Naming.lookup("rmi://localhost/AppServer");

            System.out.println(app.test("Testando cliente"));
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}