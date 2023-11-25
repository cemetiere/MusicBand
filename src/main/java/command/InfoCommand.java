package command;

import model.MusicBand;
import managers.DataManager;

import java.util.LinkedHashMap;

public class InfoCommand extends AbstractCommand {
    public InfoCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String[] args) {
        if(args.length!=0){
            System.out.println("Unknown argument. Enter \"help\" for help. ");
            return;
        }
        DataManager dm = DataManager.getInstance();
        LinkedHashMap<Long, MusicBand> bands = dm.getMusicBands();
        System.out.println("Length: "+ bands.size() + "\n" +
                            "Collection type: LinkedHashMap \n");
    }
}
