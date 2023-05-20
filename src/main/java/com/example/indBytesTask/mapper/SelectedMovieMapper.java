package com.example.indBytesTask.mapper;

import com.example.indBytesTask.entity.SelectedMovies;
import com.example.indBytesTask.vo.MovieList;
import com.example.indBytesTask.vo.SelectedMovieListVO;
import com.example.indBytesTask.vo.SelectedMovieVo;
import com.example.indBytesTask.vo.ViewedMovieResponse;
import liquibase.pro.packaged.V;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SelectedMovieMapper {
public static SelectedMovies toSelectedMovies(SelectedMovieVo selectedMovieVo){
    return SelectedMovies.builder()
            .movieId(selectedMovieVo.getMovieId())
            .userId(selectedMovieVo.getUserId())
            .date(LocalDate.now())
    .build();
}

public static ViewedMovieResponse viewedMovie(List<SelectedMovieListVO> selectedMovies,
                                              Integer userId){
    List<MovieList> movieVoList=selectedMovies.stream().map(x-> MovieList.builder()
            .movieId(x.getMovieId())
            .movieName(x.getMovieName())
            .date(LocalDate.now())
            .build()).collect(Collectors.toList());
    return ViewedMovieResponse.builder()
            .userId(userId)
            .movieLists(movieVoList)
            .build();
}

}
