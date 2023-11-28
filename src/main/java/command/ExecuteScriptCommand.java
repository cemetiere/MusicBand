package command;

import utils.UserIO;

import java.io.FileInputStream;
import java.io.IOException;

public class ExecuteScriptCommand extends AbstractCommand{
    private static String path = "";
    public ExecuteScriptCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String[] args) {
        if(args.length!=1){
            System.out.println("Need one argument - file path");
            return;
        }
        UserIO io = UserIO.getInstance();
        if(!io.isFileStreamNow()){
            path = "";
        } else {
            if(path.equals(args[0])){
                System.out.println("Recursion is not accessed");
                return;
            }
            path = args[0];
        }

        try{
            io.pushInputStream(new FileInputStream(args[0]));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
