package com.hendisantika.moviereservation.dto;

import lombok.Data;

import java.math.BigDecimal;

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
public class ReservationDto {

    @Data
    public static class ReservationRequest {

        private Long customerId;
        private Long screenId;
    }

    @Data
    public static class ReservationResponse {

        private Long customerId;
        private Long screenId;
        private BigDecimal price;
    }
}
