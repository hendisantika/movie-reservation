package com.hendisantika.moviereservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/07/18
 * Time: 07.21
 * To change this template use File | Settings | File Templates.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReservationException extends RuntimeException {

    private String message;

    public ReservationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
