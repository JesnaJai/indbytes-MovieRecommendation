package com.example.indBytesTask.service;

import com.example.indBytesTask.Response.ResponseVO;
import com.example.indBytesTask.vo.SelectedMovieListVO;
import com.example.indBytesTask.vo.SelectedMovieVo;
import com.example.indBytesTask.vo.ViewedMovieRequest;
import com.example.indBytesTask.vo.ViewedMovieResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IndBytesService {

    void selectMovie(SelectedMovieVo selectedMovieVo);

    ViewedMovieResponse viewedMovie(ViewedMovieRequest request);

    List<SelectedMovieListVO> movieList(ViewedMovieRequest request);

    List<SelectedMovieListVO> getAllMovies();
}
