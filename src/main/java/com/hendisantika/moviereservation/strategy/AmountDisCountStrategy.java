package com.hendisantika.moviereservation.strategy;

import com.hendisantika.moviereservation.entity.Screen;
import com.hendisantika.moviereservation.rule.Rule;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/07/18
 * Time: 07.22
 * To change this template use File | Settings | File Templates.
 */
public abstract class DisCountStrategy {

    private final List<Rule> rules;

    protected DisCountStrategy(List<Rule> rules) {
        this.rules = rules;
    }

    public BigDecimal calculateDisCountFee(Screen screen) {
        for (Rule rule : rules) {
            if (rule.isStatisfiedBy(screen)) {
                return getDiscountFee(screen);
            }
        }
        return BigDecimal.ZERO;
    }

    protected abstract BigDecimal getDiscountFee(Screen screen);
}