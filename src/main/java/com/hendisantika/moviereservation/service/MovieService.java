package com.hendisantika.moviereservation.service;

import com.hendisantika.moviereservation.entity.Movie;
import com.hendisantika.moviereservation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/07/18
 * Time: 05.34
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Optional<Movie> findOne(Long id) {
        return movieRepository.findById(id);
    }
}