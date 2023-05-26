package com.example.indBytesTask.vo;

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
public class MoviesVo {
    @NotEmpty(message = "Movie name should not be empty")
    public String movieName;
    @NotNull(message = "Movie id should not be empty")
    public int movieId;

}
