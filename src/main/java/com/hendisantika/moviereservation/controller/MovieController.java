package com.hendisantika.moviereservation.controller;

import com.hendisantika.moviereservation.dto.MovieDto;
import com.hendisantika.moviereservation.entity.Movie;
import com.hendisantika.moviereservation.entity.Screen;
import com.hendisantika.moviereservation.repository.MovieRepository;
import com.hendisantika.moviereservation.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/07/18
 * Time: 06.34
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/all")
    public List<MovieDto.Movie> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(i -> modelMapper.map(i, MovieDto.Movie.class))
                .collect(toList());
    }

    @GetMapping
    public List<MovieDto.Movie> getReservationMovices() {
        List<Movie> movies = movieRepository.findAll();


//        for (Movie mo :movies) {
//            List<Screen> collect = mo.getScreens().stream().filter(i -> {
//                Instant instant = Instant.ofEpochMilli(i.getScreenTime().getTime());
//                LocalDateTime screenLocalTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//                LocalDateTime now = LocalDateTime.now().plusMinutes(30);
//                return screenLocalTime.isAfter(now);
//            }).collect(Collectors.toList());
//            mo.setScreens(collect);
//        }
        //흠!
        movies.stream().forEach(i -> {
            List<Screen> screens = i.getScreens().stream().filter(j -> {
                Instant instant = Instant.ofEpochMilli(j.getScreenTime().getTime());
                LocalDateTime screenLocalTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                LocalDateTime now = LocalDateTime.now().plusMinutes(30);
                return screenLocalTime.isAfter(now);
            }).collect(toList());
            i.setScreens(screens);
        });
        return movies.stream()
                .map(i -> modelMapper.map(i, MovieDto.Movie.class))
                .collect(toList());
    }

    @GetMapping("/{id}")
    public MovieDto.Movie getMovie(@PathVariable Long id) {
        Movie movie = movieService.findOne(id);
        return modelMapper.map(movie, MovieDto.Movie.class);
    }
}