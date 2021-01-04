import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeMap;

public class Main {
    public static final String UNIC_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        ArrayList array = new ArrayList<>(1);
        array.add(6);
        array.add(5);
        array.add(0, 7);
        System.out.print(array.indexOf(6));
        array.remove(1);
        System.out.println(array.indexOf(6));
        Collection s = new TreeMap<String, String>();

        final Reverse service = new ReverseImpl();

        final Registry sharedObjectsReestr = LocateRegistry.createRegistry(2099);

        Remote stubForService = UnicastRemoteObject.exportObject(service, 0);

        sharedObjectsReestr.bind(UNIC_BINDING_NAME, stubForService);
        System.out.println("Server is ready, waiting for job");
        Thread.sleep(Long.MAX_VALUE);
    }
}
