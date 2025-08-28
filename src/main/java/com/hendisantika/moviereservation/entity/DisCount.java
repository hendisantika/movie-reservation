package com.hendisantika.moviereservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/07/18
 * Time: 06.45
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@ToString(exclude = {"movie", "disCountRules"})
public class DisCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disCount")
    private List<DisCountRule> disCountRules = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private DisCountType disCountType;

    private BigDecimal price;

}