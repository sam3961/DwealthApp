package com.android.dwealthapp.model.register;

public class RegistrationError {

    /**
     * id : 0fad9d83-122d-4717-b255-df804614fdbe
     * status : BAD_REQUEST
     * message : There are duplicate records: username
     */

    private String id;
    private String status;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
