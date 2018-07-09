package com.hendisantika.moviereservation.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/07/18
 * Time: 06.43
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@ToString(exclude = {"customer", "screen"})
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCREEN_ID")
    private Screen screen;

    private BigDecimal price;

    public Reservation() {

    }

    public Reservation(Customer customer, Screen screen) {
        this.customer = customer;
        this.screen = screen;
        this.price = screen.fee();
    }
}