package com.hendisantika.moviereservation.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.function.Consumer;

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
@ToString(exclude = {"disCount"})
public class DisCountRule {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISCOUNT_ID")
    private DisCount disCount;

    private Integer seq;

    public DisCountRule setIfTrue(boolean ifTrue, Consumer<DisCountRule> consumer) {
        if (ifTrue) {
            consumer.accept(this);
        }
        return this;
    }
}