package command;

import managers.DataManager;
import model.Album;
import model.Coordinates;
import model.MusicBand;
import model.MusicGenre;
import utils.UserIO;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class InsertCommand extends AbstractCommand{
    public InsertCommand(String description) {
        super(description);
    }

    @Override
    public void execute(String[] args) {
        UserIO io = UserIO.getInstance();
        Long id;
        if(args.length!=1){
            System.out.println("Need one argument - music band's ID type Long");
            return;
        } else {
            try{
                id = Long.parseLong(args[0]);
            }catch (Exception e){
                System.out.println("Need one argument - music band's ID type Long");
                return;
            }
        }
        String name = null;
        Coordinates coordinates = null;
        Long albumsCount = null;
        MusicGenre genre = null;
        Album bestAlbum = null;
        boolean ok = false;
        while (!ok){
            System.out.println("Enter music band name: ");
            try{
                name = io.readLine().trim();
            } catch(IOException e){
                System.out.println(e.getMessage());
            }

            if (name!=null &&!name.isEmpty()){
                ok = true;
            } else {
                System.out.println("Name must be more than 0 symbols)");
            }
        }
        ok = false;

        while (!ok){
            System.out.println("Enter x and y coordinate: ");
            int x;
            int y;
            String[] line = new String[0];
            try{
                line = io.readLine().trim().split(" ");
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            if(line.length !=2 ){
                System.out.println("You must enter two int numbers - x and y");
                continue;
            }
            try{
                x = Integer.parseInt(line[0]);
                y = Integer.parseInt(line[1]);
            } catch (Exception e){
                System.out.println("You must enter two int numbers - x and y");
                continue;
            }
            coordinates = new Coordinates(x,y);
            ok = true;
        }
        ok = false;
        while(!ok){
            System.out.println("Enter albums count: ");
            try{
                albumsCount = Long.parseLong(io.readLine().trim());
            } catch (Exception e){
                System.out.println("You must enter one number type long!");
                continue;
            }
            ok = true;
        }
        ok = false;
        while (!ok){
            System.out.println("Choose one music genre ("+ Arrays.toString(MusicGenre.values())+"): ");
            String line = "";
            try{
                line = io.readLine().trim();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
            try{
                genre = MusicGenre.valueOf(line);
            }catch (Exception e){
                System.out.println("This genre was not found...");
                continue;
            }
            ok = true;
        }
        ok = false;
        while (!ok){
            System.out.println("Enter best albums name and length: ");
            String albumName;
            int albumLength;
            String[] line = new String[0];
            try{
                line = io.readLine().trim().split(" ");
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
            if(line.length !=2 ){
                System.out.println("You must enter name and length (2 values)!");
                continue;
            }
            try{
                albumName = line[0];
                albumLength = Integer.parseInt(line[1]);
            } catch (Exception e){
                System.out.println("You must enter two values - String name and int length!");
                continue;
            }
            bestAlbum = new Album(albumName,albumLength);
            ok = true;
        }
        MusicBand band = new MusicBand(id, name, coordinates, albumsCount, genre, bestAlbum);
        DataManager dm = DataManager.getInstance();
        dm.addElement(id, band);
        System.out.println("New element has been successfully inserted!");
    }
}
