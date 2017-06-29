package com.ihc.lixoeletronico.com.ihc.lixoeletronico.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by I852842 on 06/06/2017.
 */

public class DiscardPlace {

    private String name;
    private String address;
    private double lat;
    private double longg;

    public DiscardPlace(String name, String address, LatLng coords) {
        this.name = name;
        this.address = address;
        this.lat = coords.latitude;
        this.longg = coords.longitude;
    }

    public String getName() { return this.name; }
    public String getAddress() { return this.address; }
    public double getLatitude() { return this.lat; }
    public double getLongitude() { return this.longg; }
}
