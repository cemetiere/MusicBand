package managers;

import command.*;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class CommandManager {
    private static volatile CommandManager INSTANCE;
    private final HashMap<String, AbstractCommand> commands = new HashMap<>();

    public CommandManager() {
        commands.put("help", new HelpCommand("Output help for available commands"));
        commands.put("info", new InfoCommand("Show information about the collection"));
        commands.put("show", new ShowCommand("Show all music bands"));
        commands.put("exit", new ExitCommand("Exit the app"));
    }
    public static CommandManager getInstance(){
        if (INSTANCE==null){
            synchronized (DataManager.class){
                if(INSTANCE==null){
                    INSTANCE = new CommandManager();
                }
            }
        }
        return INSTANCE;
    }
    public void execute(String[] args){
        AbstractCommand command = commands.get(args[0]);
        if(command!=null){
            command.execute();
        } else {
            System.out.println("Unknown command!");
        }
    }
}
