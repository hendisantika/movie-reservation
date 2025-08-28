package com.hendisantika.moviereservation.entity;

import com.hendisantika.moviereservation.rule.Rule;
import com.hendisantika.moviereservation.rule.SequenceRule;
import com.hendisantika.moviereservation.strategy.AmountDisCountStrategy;
import com.hendisantika.moviereservation.strategy.NonDisCountStrategy;
import com.hendisantika.moviereservation.strategy.PercentDiscountStrategy;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
@ToString(exclude = {"reservations", "movie"})
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date screenTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "screen")
    private List<Reservation> reservations = new ArrayList<>();

    private Integer seq;

    public Reservation reservation(Customer customer) {
        return new Reservation(customer, this);
    }

    public BigDecimal fee() {
        DisCount disCount = movie.getDisCount();
        DisCountType disCountType = disCount.getDisCountType();

        List<Rule> rules = new ArrayList<>();
        rules.add(new SequenceRule(disCount.getDisCountRules()
                .stream()
                .map(i -> i.getSeq())
                .collect(toList()))
        );
        if (disCountType == DisCountType.AMOUNT) {
            movie.setDisCountStrategy(new AmountDisCountStrategy(rules));
        } else if (disCountType == DisCountType.PERCENT) {
            movie.setDisCountStrategy(new PercentDiscountStrategy(rules));
        } else {
            movie.setDisCountStrategy(new NonDisCountStrategy(rules));
        }

        return movie.calculateFee(this);
    }

    public BigDecimal dcAmount() {
        return movie.getDisCount().getPrice();
    }


    public BigDecimal dcPercent() {
        BigDecimal percent = dcAmount().divide(new BigDecimal(100));
        return movie.getPrice().multiply(percent);
    }

    public boolean isSequence(List<Integer> sequences) {
        for (Integer sequence : sequences) {
            if (sequence.equals(seq)) {
                return true;
            }
        }
        return false;
    }
}