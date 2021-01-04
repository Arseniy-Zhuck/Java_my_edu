import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Reverse extends Remote {
    String reverse(String s) throws RemoteException;
}
