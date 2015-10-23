package com.kasib.stl.network.models;

import java.util.List;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
public class OpenDocumentResponse extends BaseResponse {

    public static final int
            ERROR_DEVICE_NOT_REGISTERED = 3,
            ERROR_DOCUMENT_WAS_MODIFIED_OUTSIDE = 4,
            ERROR_DOCUMENT_NOT_REGISTERED = 5;

    public List<HistoryItem> history;

}
