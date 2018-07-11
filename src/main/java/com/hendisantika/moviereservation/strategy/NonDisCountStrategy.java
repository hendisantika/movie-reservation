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
 * Time: 07.30
 * To change this template use File | Settings | File Templates.
 */
public class NonDisCountStrategy extends DisCountStrategy {
    public NonDisCountStrategy(List<Rule> rules) {
        super(rules);
    }

    @Override
    protected BigDecimal getDiscountFee(Screen screen) {
        return BigDecimal.ZERO;
    }
}