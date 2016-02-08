package com.naimyag.ornek.mineline;

/**
 * Created by Naim on 3.02.2016.
 */
public class Konum {


    private double lat;
    private double lng;

    public Konum() {
    }


    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }



    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }



    @Override
    public String toString() {
        return "Konum{"+
                "lat="+lat+
                ", lng="+lng+
                '}';
    }


}
