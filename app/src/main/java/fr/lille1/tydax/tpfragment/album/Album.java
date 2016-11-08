package fr.lille1.tydax.tpfragment.album;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.lille1.tydax.tpfragment.R;

/**
 * Created by tydax on 04/11/16.
 */

public class Album {

    private static int INDEX = 0;
    public static final Map<Integer, Album> TEMPLATE;

    static {
        TEMPLATE = new HashMap<>();
        generateAlbumList();
    }

    private static void generateAlbumList() {
        final List<Album> albums = new ArrayList<>();
        albums.add(new Album("UNDERTALE Soundtrack", "Tobyfox", 2015, R.drawable.undertale,
                "Once Upon a Time", "Fallen Down (Reprise)", "Heartache", "Bonetrousle", "ASGORE",
                "Battle Against a True Hero"));
        albums.add(new Album("Hourvari", "Hourvari", 2013, R.drawable.hourvari, "I", "II"));
        albums.add(new Album("NEOTOKYO° Soundtrack", "Ed Harrison", 2009, R.drawable.neotokyo,
                "Annul", "Tin Soldiers", "Beacon", "Imbrium", "Automata", "Hiroden 651", "Tachi",
                "Sprawl", "Mechanism", "Paperhouse", "Footprint", "Out", "00", "Welcome", "Scrap I/O",
                "Departure", "Prabhava", "Distance", "Impetus", "Carapace", "Stopgap", "Radius", "Rebuild",
                "Reboot", "Haka", "Surface", "Nimbus"));
        albums.add(new Album("Les Voyages de l’Âme", "Alcest", 2012, R.drawable.lesvoyagesdelame,
                "Autre Temps", "Là où naissent les couleurs nouvelles", "Les Voyages de l'âme",
                "Nous sommes l'émeraude", "Beings of Light", "Faiseurs de mondes", "Havens",
                "Summer's Glory"));
        albums.add(new Album("Poundcake", "Alaska Thunderfuck", 2016, R.drawable.poundcake,
                "The T (feat. Adore Delano)", "Let's Do Drag (feat. Lady Red Couture)", "Slaytina"));

        for (final Album album : albums) {
            TEMPLATE.put(album.getId(), album);
        }
    }

    protected final int id;
    protected final String title;
    protected final String artist;
    protected final int year;
    protected final int cover;
    protected final String[] tracks;

    public Album(final String title, final String artist, final int year, final int cover, final
                 String ... tracks) {
        this.id = INDEX++;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.cover = cover;
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public int getCover() {
        return cover;
    }

    public String[] getTracks() {
        return tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (id != album.id) return false;
        if (year != album.year) return false;
        if (cover != album.cover) return false;
        if (title != null ? !title.equals(album.title) : album.title != null) return false;
        if (artist != null ? !artist.equals(album.artist) : album.artist != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(tracks, album.tracks);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + cover;
        result = 31 * result + Arrays.hashCode(tracks);
        return result;
    }

    public int getId() {
        return id;
    }
}
