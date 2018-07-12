package com.hendisantika.moviereservation.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/07/18
 * Time: 06.17
 * To change this template use File | Settings | File Templates.
 */
public class ScreenDto {
    @Data
    public static class Screen {

        private Long id;

        private Date screenTime;

        private BigDecimal disCount;

        private Movie movie;

    }

    @Data
    public static class Movie {
        private Long id;

        private String title;

        private Integer price;
    }
}
