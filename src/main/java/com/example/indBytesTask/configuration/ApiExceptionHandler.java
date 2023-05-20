package com.example.indBytesTask.configuration;

public class ApiExceptionHandler extends RuntimeException {
    private final String code;
    private  final String message;

    public ApiExceptionHandler(String code, String message){
        super();
        this.code=code;
        this.message=message;

    }
    public String getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
}
