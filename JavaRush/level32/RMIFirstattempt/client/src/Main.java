import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static final String UNIC_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws RemoteException, NotBoundException {
       final Registry sharedObjectsReestr = LocateRegistry.getRegistry(2099);

       Reverse myReverseObject = (Reverse) sharedObjectsReestr.lookup(UNIC_BINDING_NAME);

       String result = myReverseObject.reverse("Ough, My GOOD!!!");

        System.out.println(result);
    }
}
