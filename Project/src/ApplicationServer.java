import java.rmi.Naming;
import java.rmi.Remote;

public class ApplicationServer {
    public ApplicationServer() {
        try {
            AppInterface app = new AppImplementation();
            Naming.rebind("//192.168.43.125/AppServer", (Remote) app);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ApplicationServer();
    }
}