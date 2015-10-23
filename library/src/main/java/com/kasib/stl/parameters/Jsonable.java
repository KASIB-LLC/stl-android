package com.kasib.stl.parameters;

import com.google.gson.Gson;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
abstract class Jsonable {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
