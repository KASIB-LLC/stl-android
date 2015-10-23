package com.kasib.stl.network.parameters;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */

public class Resolution extends Jsonable {

    public final int width;
    public final int height;

    public Resolution(int width, int height) {
        this.width = width;
        this.height = height;
    }
}