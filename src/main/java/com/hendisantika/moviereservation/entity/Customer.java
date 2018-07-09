package com.hendisantika.moviereservation.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/07/18
 * Time: 06.42
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@ToString(exclude = {"reservations"})
public class Customer {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    List<Reservation> reservations = new ArrayList<>();
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}