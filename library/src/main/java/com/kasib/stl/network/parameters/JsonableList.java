package com.kasib.stl.network.parameters;

import com.google.gson.Gson;

import java.util.LinkedList;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
abstract class JsonableList<T> extends LinkedList<T> {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
