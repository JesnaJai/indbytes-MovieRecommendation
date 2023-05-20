package com.example.indBytesTask.Response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Builder
@Data
public class ResponseVO {
    private boolean success;
    private String message;
    private HttpStatus statusCode;
    private Object data;

}
