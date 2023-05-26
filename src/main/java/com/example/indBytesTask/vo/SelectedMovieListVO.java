package com.example.indBytesTask.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SelectedMovieListVO {
    @NotNull(message = "movieId Required")
    private Integer movieId;
    @NotNull(message = "movie name Required")
    private String movieName;
}
