import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.rmi.Remote;
import java.rmi.RemoteException;

// Определение интерфейса удаленного объекта
public interface AlphabetService extends Remote {
    String getAlphabetType(char letter) throws RemoteException;
}
