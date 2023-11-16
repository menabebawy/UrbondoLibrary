package com.urbondo.lib;

import java.util.Date;

public class ErrorResponse {
    private final Date timestamp;
    private final int code;
    private final String status;
    private final String message;

    public ErrorResponse(int code, String status, String message) {
        this.timestamp = new Date();
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
