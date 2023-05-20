package com.example.indBytesTask.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ApiExceptionVo {
    private final String code;
    private final String message;
}
