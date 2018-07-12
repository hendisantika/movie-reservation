package com.hendisantika.moviereservation.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/07/18
 * Time: 06.15
 * To change this template use File | Settings | File Templates.
 */
public class CustomerDto {
    @Data
    public static class Customer {
        private Long id;
        private List<Reservation> reservations;
    }

    @Data
    public static class Reservation {
        private Long id;
        private Screen screen;
        private BigDecimal price;
    }

    @Data
    public static class Screen {
        private Movie movie;
        private Date screenTime;

    }

    @Data
    public static class Movie {
        private Long id;
        private String title;
    }
}
