package command;

public abstract class AbstractCommand {
    private final String DESCRIPTION;

    protected AbstractCommand(String description) {
        DESCRIPTION = description;
    }
    protected String getDescription(){
        return DESCRIPTION;
    };
    public abstract void execute();
}
