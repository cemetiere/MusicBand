package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MusicBand {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private Long albumsCount;
    private MusicGenre genre;
    private Album bestAlbum;

    @Override
    public String toString(){
        return  "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Coordinates: " + coordinates.getX()+" "+ coordinates.getY() + "\n" +
                "Genre: " + genre + "\n" +
                "Best album: " + bestAlbum.getName() + "\n";
    }
}