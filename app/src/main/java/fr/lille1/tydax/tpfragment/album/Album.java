package fr.lille1.tydax.tpfragment.album;

import java.util.ArrayList;
import java.util.List;

import fr.lille1.tydax.tpfragment.R;

/**
 * Created by tydax on 04/11/16.
 */

public class Album {

    public static final List<Album> TEMPLATE;

    static {
        TEMPLATE = new ArrayList<>();
        TEMPLATE.add(new Album("UNDERTALE Soundtrack", "Tobyfox", 2015, R.drawable.undertale,
                "Once Upon a Time", "Fallen Down (Reprise)", "Heartache", "Bonetrousle", "ASGORE",
                "Battle Against a True Hero"));
        TEMPLATE.add(new Album("Hourvari", "Hourvari", 2013, R.drawable.hourvari, "I", "II"));
        TEMPLATE.add(new Album("NEOTOKYO° Soundtrack", "Ed Harrison", 2009, R.drawable.neotokyo,
                "Annul", "Tin Soldiers", "Beacon", "Imbrium", "Automata", "Hiroden 651", "Tachi",
                "Sprawl", "Mechanism", "Paperhouse", "Footprint", "Out", "00", "Welcome", "Scrap I/O",
                "Departure", "Prabhava", "Distance", "Impetus", "Carapace", "Stopgap", "Radius", "Rebuild",
                "Reboot", "Haka", "Surface", "Nimbus"));
        TEMPLATE.add(new Album("Les Voyages de l’Âme", "Alcest", 2012, R.drawable.lesvoyagesdelame,
                "Autre Temps", "Là où naissent les couleurs nouvelles", "Les Voyages de l'âme",
                "Nous sommes l'émeraude", "Beings of Light", "Faiseurs de mondes", "Havens",
                "Summer's Glory"));
        TEMPLATE.add(new Album("Poundcake", "Alaska Thunderfuck", 2016, R.drawable.poundcake,
                "The T (feat. Adore Delano)", "Let's Do Drag (feat. Lady Red Couture)", "Slaytina"));
    }

    protected final String title;
    protected final String artist;
    protected final int year;
    protected final int cover;
    protected final String[] tracks;

    public Album(final String title, final String artist, final int year, final int cover, final
                 String ... tracks) {
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
}
