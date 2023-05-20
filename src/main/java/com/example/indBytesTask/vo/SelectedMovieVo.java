package com.example.indBytesTask.vo;

import liquibase.pro.packaged.A;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SelectedMovieVo {
    @NotNull(message = "movieId Required")
    public int movieId;
    @NotNull(message = "userId Required")
    public int userId;
}
