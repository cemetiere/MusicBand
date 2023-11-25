package managers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import lombok.Getter;
import model.MusicBand;
import java.io.*;
import java.util.LinkedHashMap;

public class FileManager {
    private static volatile FileManager INSTANCE;
    private final Gson gson = new Gson();
    @Getter private File file;
    private FileManager(){}
    public static FileManager getInstance(){
        if (INSTANCE==null){
            synchronized (FileManager.class){
                if(INSTANCE==null){
                    INSTANCE = new FileManager();
                }
            }
        }
        return INSTANCE;
    }
    public File openOrCreateFile(String path){
        file = new File(path);
        if(file.exists()){
            System.out.println("Opening an existing file...");
        } else {
            System.out.println("File was not found, creating a new file "+ path);
            try{
                boolean created = file.createNewFile();
                if(created){
                    System.out.println("New file was created!");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Success!");
        return file;
    }
    public void writeCollectionToJsonFile(File file, LinkedHashMap<Long, MusicBand> collection) {
        try(PrintWriter out = new PrintWriter(new FileWriter(file))){
            out.write(gson.toJson(collection));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public LinkedHashMap<Long, MusicBand> readCollectionFromJsonFile(File file) throws FileNotFoundException {
        try{
            JsonReader reader = new JsonReader(new FileReader(file));

            return gson.fromJson(reader, new TypeToken<LinkedHashMap<Long, MusicBand>>(){}.getType());
        } catch (Exception e){
            System.out.println("Can't read this file... Check that it's not broken:)");
            System.exit(1);
        }
        return null;
    }
    public void printFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
