import managers.CommandManager;
import managers.DataManager;
import managers.FileManager;
import utils.UserIO;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        UserIO io = UserIO.getInstance();
        CommandManager cm = CommandManager.getInstance();
        FileManager fm = FileManager.getInstance();
        File file = fm.openOrCreateFile(args[0]);
        DataManager.getInstance().initDataFromFile(file);
        String[] str = new String[0];
        do{
            String input = io.readLine();
            if(input==null){
                System.out.println("End of stream");
                continue;
            }
            str = input.split(" ");
            cm.execute(str);

        } while (!str[0].equals("exit"));
    }
}