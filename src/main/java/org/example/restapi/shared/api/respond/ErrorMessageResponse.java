package org.example.restapi.shared.api.respond;

public class ErrorMessageResponse {

    private final String message;

    public ErrorMessageResponse(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
