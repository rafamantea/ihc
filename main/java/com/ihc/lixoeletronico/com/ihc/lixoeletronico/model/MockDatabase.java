package com.ihc.lixoeletronico.com.ihc.lixoeletronico.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by I852842 on 06/06/2017.
 */

public class MockDatabase {

    private static MockDatabase INSTANCE;
    private static List<DiscardPlace> PLACES = new ArrayList<>();

    public static void init() {
        MockDatabase.getInstance();
    }

    public static MockDatabase getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MockDatabase();
        }

        return INSTANCE;
    }

    public MockDatabase() {
        DiscardPlace a = new DiscardPlace("CPD - UFRGS", "Av. Joao Pessoa, 151", new LatLng(-30.02d, -51.19d));
        DiscardPlace b = new DiscardPlace("Alberto Pilhas", "Av. Carlos Gomes, 4531", new LatLng(-30.00d, -51.20d));
        DiscardPlace c = new DiscardPlace("GNU - Ilha do Pavao", "Ilha do Pavao, Navegantes", new LatLng(-30.01d, -51.22d));
        DiscardPlace d = new DiscardPlace("UFRGS - Campus do Vale", "Av. Bento Gonçalves, 1450", new LatLng(-30.06d, -51.12d));
        DiscardPlace e = new DiscardPlace("PUCRS - Predio 40", "Av. Ipiranga, 5000", new LatLng(-30.05d, -51.17d));

        this.addPlace(a);
        this.addPlace(b);
        this.addPlace(c);
        this.addPlace(d);
        this.addPlace(e);
    }


    public void addPlace(DiscardPlace place) {
        PLACES.add(place);
    }

    public List<DiscardPlace> getAllPlaces() {
        return PLACES;
    }
}
