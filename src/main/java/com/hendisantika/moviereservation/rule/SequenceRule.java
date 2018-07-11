package com.hendisantika.moviereservation.rule;

import com.hendisantika.moviereservation.entity.Screen;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/07/18
 * Time: 07.15
 * To change this template use File | Settings | File Templates.
 */
public class SequenceRule implements Rule {

    private final List<Integer> sequences;

    public SequenceRule(List<Integer> sequences) {
        this.sequences = sequences;
    }

    @Override
    public boolean isStatisfiedBy(Screen screen) {
        return screen.isSequence(sequences);
    }
}