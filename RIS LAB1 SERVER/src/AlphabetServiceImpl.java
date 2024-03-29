import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Реализация удаленного объекта
public class AlphabetServiceImpl extends UnicastRemoteObject implements AlphabetService {
    protected AlphabetServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String getAlphabetType(char letter) throws RemoteException {
        if (Character.UnicodeBlock.of(letter) == Character.UnicodeBlock.CYRILLIC) {
            return "Cyrillic";
        } else {
            return "Latin";
        }
    }

    public static void main(String[] args) {
        try {
            // Создание удаленного объекта
            AlphabetService alphabetService = new AlphabetServiceImpl();

            // Регистрация удаленного объекта в RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("AlphabetService", alphabetService);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
