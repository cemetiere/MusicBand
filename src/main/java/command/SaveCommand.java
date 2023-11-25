package command;

import managers.DataManager;

public class SaveCommand extends  AbstractCommand{
    public SaveCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String[] args) {
        if(args.length!=0){
            System.out.println("Unknown argument. Enter \"help\" for help. ");
            return;
        }
        DataManager dm = DataManager.getInstance();
        dm.saveDataToFile(dm.getFm().getFile());
    }
}
