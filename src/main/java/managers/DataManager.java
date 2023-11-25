package managers;

import utils.MusicBand;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;

@Getter
@Setter
public class DataManager {
    private static volatile DataManager INSTANCE;
    private LinkedHashMap<Long, MusicBand> musicBands = new LinkedHashMap<>();
    private final FileManager fm = new FileManager();

    public DataManager(){
    }
    public static DataManager getInstance(){
        if (INSTANCE==null){
            synchronized (DataManager.class){
                if(INSTANCE==null){
                    INSTANCE = new DataManager();
                }
            }
        }
        return INSTANCE;
    }
    public void initDataFromFile(File file) throws FileNotFoundException {
        musicBands = fm.readCollectionFromJsonFile(file);
    }
    public void saveDataToFile(File file){
        fm.writeCollectionToJsonFile(file, musicBands);
    }
}
