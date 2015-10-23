package com.kasib.stl.network.models;

import android.support.annotation.Nullable;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
abstract class BaseResponse {

    public static final int
            ERROR_OK = 0,
            ERROR_INCORRECT_API_KEY = 1,
            ERROR_USER = 2;

    public int res;

    @Nullable
    public String error;

}
