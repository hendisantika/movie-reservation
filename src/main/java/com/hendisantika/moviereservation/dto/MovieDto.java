package com.hendisantika.moviereservation.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/07/18
 * Time: 06.16
 * To change this template use File | Settings | File Templates.
 */
public class MovieDto {
    @Data
    public static class Movie {
        private Long id;

        private String title;

        private Integer price;

        private List<Screen> screens = new ArrayList<>();

    }

    @Data
    public static class Screen {

        private Long id;

        private Date screenTime;

    }
}
