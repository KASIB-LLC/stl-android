package com.kasib.stl.network.models;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
public class RegisterResponse extends BaseResponse {

    public static final int
            ERROR_SOME_SIGNATURES_ARE_INVALID = 3,
            ERROR_SERVER_MALFUNCTION = 4;

    public String password_key;
}
