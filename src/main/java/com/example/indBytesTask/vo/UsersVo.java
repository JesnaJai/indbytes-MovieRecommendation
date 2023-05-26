package com.example.indBytesTask.vo;

import liquibase.pro.packaged.B;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersVo {
    @NotNull(message = "User id must not be empty")
    public int userId;
    @NotEmpty(message = "User name must not be empty")
    public String userName;

}
