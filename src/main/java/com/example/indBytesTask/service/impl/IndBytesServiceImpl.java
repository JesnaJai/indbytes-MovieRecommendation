package com.example.indBytesTask.service.impl;

import com.example.indBytesTask.configuration.ApiExceptionHandler;
import com.example.indBytesTask.mapper.SelectedMovieMapper;
import com.example.indBytesTask.repo.MovieRepo;
import com.example.indBytesTask.repo.SelectedMovieRepo;
import com.example.indBytesTask.repo.UserRepo;
import com.example.indBytesTask.service.IndBytesService;
import com.example.indBytesTask.vo.SelectedMovieListVO;
import com.example.indBytesTask.vo.SelectedMovieVo;
import com.example.indBytesTask.vo.ViewedMovieRequest;
import com.example.indBytesTask.vo.ViewedMovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class IndBytesServiceImpl implements IndBytesService {

    private final SelectedMovieRepo selectedMovieRepo;
    private final MovieRepo movieRepo;
    private final UserRepo userRepo;

    @Override
    public void selectMovie(SelectedMovieVo selectedMovieVo) {
        if (!userRepo.existsById(selectedMovieVo.userId)) {
            throw new ApiExceptionHandler("id.invalid", "User Id invalid");
        }
        if (!movieRepo.existsById(selectedMovieVo.movieId)) {
            throw new ApiExceptionHandler("id.invalid", "Movie Id invalid");
        }
        validateRequest(selectedMovieVo);
        selectedMovieRepo.save(SelectedMovieMapper.toSelectedMovies(selectedMovieVo));
    }

    @Override
    public ViewedMovieResponse viewedMovie(ViewedMovieRequest request) {
        if (!userRepo.existsById(request.getUserId())) {
            throw new ApiExceptionHandler("id.invalid", "User Id invalid");
        }

       return SelectedMovieMapper.viewedMovie(selectedMovieRepo.viewedMovie(request.getUserId(),
                LocalDate.now()), request.getUserId());
    }

    @Override
    public List<SelectedMovieListVO> movieList(ViewedMovieRequest request) {
        return selectedMovieRepo.movieList(request.getUserId());
    }
    @Override
    public List<SelectedMovieListVO>getAllMovies(){
        return movieRepo.getAllMovies();

    }
    private void validateRequest(SelectedMovieVo selectedMovieVo) {
        if (!userRepo.existsById(selectedMovieVo.userId)) {
            throw new ApiExceptionHandler("id.invalid", "User Id invalid");
        }
        if (!movieRepo.existsById(selectedMovieVo.movieId)) {
            throw new ApiExceptionHandler("id.invalid", "Movie Id invalid");
        }
        if (Objects.nonNull(selectedMovieRepo.isWatched(selectedMovieVo.userId, selectedMovieVo.movieId))) {
            throw new ApiExceptionHandler("WATCHED", "THIS MOVIE IS ALREADY WATCHED");
        }
    }


}
