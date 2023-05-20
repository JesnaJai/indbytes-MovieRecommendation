package com.example.indBytesTask.controller;

import com.example.indBytesTask.Response.ResponseVO;
import com.example.indBytesTask.service.IndBytesService;
import com.example.indBytesTask.vo.SelectedMovieListVO;
import com.example.indBytesTask.vo.SelectedMovieVo;
import com.example.indBytesTask.vo.ViewedMovieRequest;
import com.example.indBytesTask.vo.ViewedMovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SelectedMovieController {
    private final IndBytesService indBytesService;

    @PostMapping(path = "/selectMovie")
    public ResponseEntity<ResponseVO> SelectMovie(@Valid @RequestBody SelectedMovieVo selectedMovieVo) {
        indBytesService.selectMovie(selectedMovieVo);
        return ResponseEntity.ok().body(ResponseVO.builder()
                .message("SAVED")
                .success(true)
                .statusCode(HttpStatus.OK)
                .build());
    }

    @PostMapping("/list-todays")
    public ResponseEntity<ViewedMovieResponse> viewedMovie(@RequestBody ViewedMovieRequest request){
        return ResponseEntity.ok().body(indBytesService.viewedMovie(request));
    }

    @PostMapping("/movie-list")
    public ResponseEntity<List<SelectedMovieListVO>> movieList(@RequestBody ViewedMovieRequest request){
        return ResponseEntity.ok().body(indBytesService.movieList(request));
    }
    @GetMapping("/get-all-movie")
    public ResponseEntity<List<SelectedMovieListVO>>getAllMovieS(){
        return ResponseEntity.ok().body(indBytesService.getAllMovies());
    }
}
