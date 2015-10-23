package com.kasib.stl.network.parameters;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */

public class Location extends Jsonable {

    public final double latitude;
    public final double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

}