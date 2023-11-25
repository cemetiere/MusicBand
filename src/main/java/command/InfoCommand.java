package command;

import utils.MusicBand;
import managers.DataManager;

import java.util.LinkedHashMap;

public class InfoCommand extends AbstractCommand {
    public InfoCommand(String description) {
        super(description);
    }

    @Override
    public void execute() {
        DataManager dm = DataManager.getInstance();
        LinkedHashMap<Long, MusicBand> bands = dm.getMusicBands();
        System.out.println("Length: "+ bands.size() + "\n" +
                            "Collection type: LinkedHashMap \n");
    }
}
