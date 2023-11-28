package managers;

import command.*;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;

@Getter
public class CommandManager {
    private static volatile CommandManager INSTANCE;
    private final HashMap<String, AbstractCommand> commands = new HashMap<>();

    private CommandManager() {
        commands.put("help", new HelpCommand("Output help for available commands"));
        commands.put("info", new InfoCommand("Show information about the collection"));
        commands.put("show", new ShowCommand("Show all music bands"));
        commands.put("exit", new ExitCommand("Exit the app"));
        commands.put("save", new SaveCommand("Save your data to file"));
        commands.put("insert", new InsertCommand("insert [id] - Create and insert the element to collection"));
        commands.put("execute_script", new ExecuteScriptCommand("Execute script lol"));
        commands.put("remove", new RemoveCommand("remove [id] - Remove element by id"));
    }
    public static CommandManager getInstance(){
        if (INSTANCE==null){
            synchronized (CommandManager.class){
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
            command.execute(Arrays.copyOfRange(args, 1, args.length));
        } else {
            System.out.println("Unknown command!");
        }
    }
}
