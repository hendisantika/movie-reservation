package com.hendisantika.moviereservation.service;

import com.hendisantika.moviereservation.entity.*;
import com.hendisantika.moviereservation.exception.IdNotFoundException;
import com.hendisantika.moviereservation.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/07/18
 * Time: 06.28
 * To change this template use File | Settings | File Templates.
 */

@Service
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;

    @Transactional(readOnly = true)
    public Screen findOne(Long id) {
        Optional<Screen> screenOpt = screenRepository.findById(id);
        Screen screen = screenOpt.get();
        if (!screenOpt.isPresent()) {
            throw new IdNotFoundException(id);
        }
        Movie movie = screen.getMovie();

        List<DisCountRule> disCountRules = movie.getDisCount().getDisCountRules();
        Optional<DisCount> disCountOptional = findDisCount(screen, disCountRules);

        if (disCountOptional.isPresent()) {
            DisCount dc = disCountOptional.get();
            if (dc.getDisCountType() == DisCountType.AMOUNT) {
//                screen.setDisCount(movie.getPrice().subtract(dc.getPrice()));
            } else {
                BigDecimal divide = dc.getPrice().divide(new BigDecimal(100));
                BigDecimal multiply = movie.getPrice().multiply(divide);
//                screen.setDisCount(movie.getPrice().subtract(multiply));
            }
        } else {
//            screen.setDisCount(movie.getPrice());
        }

        return screen;
    }

    private Optional<DisCount> findDisCount(Screen screen, List<DisCountRule> disCountRules) {
        return disCountRules.stream()
                .filter(role -> role.getSeq() == screen.getSeq())
                .map(i -> i.getDisCount()).findFirst();
    }
}
