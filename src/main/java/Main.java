import managers.CommandManager;
import managers.DataManager;
import managers.FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        CommandManager cm = CommandManager.getInstance();
        FileManager fm = new FileManager();
        File file = fm.openOrCreateFile(args[0]);
        DataManager.getInstance().initDataFromFile(file);
        String[] str;
        do{
            System.out.print(">>");
            String input = scanner.nextLine();
            str = input.split(" ");
            cm.execute(str);

        } while (!str[0].equals("exit"));
        scanner.close();
    }
}