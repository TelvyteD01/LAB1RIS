import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import static java.rmi.registry.LocateRegistry.*;

public class AlphabetClient {
    public static void main(String[] args) {
        try {
            // Получение ссылки на удаленный объект из RMI Registry
            Registry registry = getRegistry("localhost", 1099);
            AlphabetService alphabetService = (AlphabetService) registry.lookup("AlphabetService");

            // Ввод буквы с клавиатуры
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a letter: ");
            char letter = scanner.next().charAt(0);

            // Вызов удаленного метода и получение результата
            String alphabetType = alphabetService.getAlphabetType(letter);
            System.out.println("Alphabet type: " + alphabetType);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
