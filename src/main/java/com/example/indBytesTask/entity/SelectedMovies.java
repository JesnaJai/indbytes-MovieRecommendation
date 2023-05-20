package com.example.indBytesTask.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "selected_movie")
public class SelectedMovies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;
    @Column(name = "movie_id")
    public int movieId;
    @Column(name = "user_id")
    public int userId;
    @Column(name = "date")
    public LocalDate date;}
