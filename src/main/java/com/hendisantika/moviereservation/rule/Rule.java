package com.hendisantika.moviereservation.rule;

import com.hendisantika.moviereservation.entity.Screen;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/07/18
 * Time: 07.14
 * To change this template use File | Settings | File Templates.
 */
public interface Rule {

    boolean isStatisfiedBy(Screen screen);
}
