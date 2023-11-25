package command;

public class ExitCommand extends AbstractCommand{
    public ExitCommand(String description) {
        super(description);
    }

    @Override
    public void execute() {
        System.out.println("Bye!");
    }
}
