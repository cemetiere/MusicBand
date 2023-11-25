package command;

import managers.CommandManager;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand extends AbstractCommand {
    public HelpCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String[] args) {
        if(args.length!=0){
            System.out.println("Unknown argument. Enter \"help\" for help. ");
            return;
        }
        CommandManager cm = CommandManager.getInstance();
        HashMap<String, AbstractCommand> commands = cm.getCommands();
        for (Map.Entry<String, AbstractCommand> command : commands.entrySet()) {
            System.out.println(command.getKey() + ": " + command.getValue().getDescription());
        }
    }
}
