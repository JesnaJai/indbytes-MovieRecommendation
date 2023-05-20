package com.example.indBytesTask.repo;

import com.example.indBytesTask.entity.Movie;
import com.example.indBytesTask.vo.SelectedMovieListVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    @Query(value = "Select new com.example.indBytesTask.vo.SelectedMovieListVO(m.movieId,m.movieName) from Movie m")
    List<SelectedMovieListVO> getAllMovies();
}
