package com.kasib.stl.network.models;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
public class AuthResponse extends BaseResponse {

    public static final int
            ERROR_REGISTRATION_IS_REQUIRED = 3,
            ERROR_SERVER_MALFUNCTION = 4,
            ERROR_NO_SAMPLE = 5,
            ERROR_SIGNATURE_ERROR = 6;

    public float similarity;
    public int signature_id;
    public String password_key;
}
