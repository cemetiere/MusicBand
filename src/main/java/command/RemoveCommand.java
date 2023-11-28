package command;

import managers.DataManager;

public class RemoveCommand extends AbstractCommand{
    public RemoveCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String[] args) {
        if(args.length!=1){
            System.out.println("One argument needed - element id that you want to remove");
            return;
        }
        DataManager dm = DataManager.getInstance();
        Long id;
        try{
            id = Long.parseLong(args[0]);
        }catch (Exception e){
            System.out.println("You must enter a long number argument");
            return;
        }
        dm.removeElement(id);
    }
}
