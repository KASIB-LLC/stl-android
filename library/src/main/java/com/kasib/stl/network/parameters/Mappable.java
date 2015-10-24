package com.kasib.stl.network.parameters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
abstract class Mappable {

    public Map<String, String> toFieldMap() {
        final Gson gson = new Gson();
        final String json = gson.toJson(this);
        final Type type = new TypeToken<Map<String, String>>() {
        }.getType();

        return gson.fromJson(json, type);
    }
}
