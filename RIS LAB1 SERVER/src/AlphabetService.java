import java.rmi.Remote;
import java.rmi.RemoteException;

// Определение интерфейса удаленного объекта
public interface AlphabetService extends Remote {
    String getAlphabetType(char letter) throws RemoteException;
}
