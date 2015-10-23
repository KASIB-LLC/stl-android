package com.kasib.stl.network.models;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
public class SaveDocumentResponse extends BaseResponse {

    public static final int
            ERROR_DEVICE_NOT_REGISTERED = 3,
            ERROR_SERVER_MALFUNCTION = 4,
            ERROR_NO_SIGN_SAMPLE = 5,
            ERROR_SIGNATURE_ERROR = 6,
            ERROR_DOCUMENT_WAS_MODIFIED_OUTSIDE = 7,
            ERROR_DOCUMENT_ALREADY_REGISTERED = 8;

    public String documentid;
}
