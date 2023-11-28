package command;

import managers.CommandManager;

import java.util.Scanner;

public class ExitCommand extends AbstractCommand{

    public ExitCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String[] args) {
        if(args.length!=0){
            System.out.println("Unknown argument. Enter \"help\" for help. ");
            return;
        }
        CommandManager cm = CommandManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to save data to file before exit? (Yes/No)");
        String input;
        boolean hlt = false;
        do {
            System.out.print(">> ");
            input = scanner.nextLine();
            switch (input.trim().toLowerCase()){
                case "yes":
                    cm.getCommands().get("save").execute(new String[0]);
                    hlt = true;
                    break;
                case "no":
                    hlt = true;
                    break;
                default:
                    System.out.println("Please, enter Yes or No!!!");
            }
        } while (!hlt);
        System.out.println("Bye!");
    }
}
