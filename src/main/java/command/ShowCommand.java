package command;

import managers.DataManager;

public class ShowCommand extends AbstractCommand {
    public ShowCommand(String description) {
        super(description);
    }

    @Override
    public void execute() {
        DataManager dm = DataManager.getInstance();
        System.out.println(dm.getMusicBands());
    }
}
