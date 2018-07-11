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
 * Time: 07.19
 * To change this template use File | Settings | File Templates.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdNotFoundException extends RuntimeException {
    private Long id;

    public IdNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return id + " not found";
    }
}