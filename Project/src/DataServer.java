import java.rmi.Naming;
import java.rmi.Remote;

public class DataServer {
    public DataServer() {
        try {
            DataInterface data = new DataImplementation();
            Naming.rebind("//localhost/DataServer", (Remote) data);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new DataServer();
    }
}