package com.kasib.stl.network.models;

import java.util.List;

/**
 * Created by Pasenchuk Victor on 24.10.15
 */
public class DocumentHistoryResponse extends BaseResponse {

    public static final int
            ERROR_DOCUMENT_NOT_REGISTERED = 4;

    public List<HistoryItem> history;

}
