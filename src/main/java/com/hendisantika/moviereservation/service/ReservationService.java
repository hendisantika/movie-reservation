package com.hendisantika.moviereservation.service;

import com.hendisantika.moviereservation.dto.ReservationDto;
import com.hendisantika.moviereservation.entity.Customer;
import com.hendisantika.moviereservation.entity.Reservation;
import com.hendisantika.moviereservation.entity.Screen;
import com.hendisantika.moviereservation.exception.ReservationException;
import com.hendisantika.moviereservation.repository.CustomerRepository;
import com.hendisantika.moviereservation.repository.ReservationRepository;
import com.hendisantika.moviereservation.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 13/07/18
 * Time: 06.24
 * To change this template use File | Settings | File Templates.
 */

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Reservation save(Long customerId, Screen screen) {

        Date screenTime = screen.getScreenTime();
        Instant instant = Instant.ofEpochMilli(screenTime.getTime());
        LocalDateTime screenLocalTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDateTime now = LocalDateTime.now().plusMinutes(30);
        if (screenLocalTime.isBefore(now)) {
            throw new ReservationException("screen time before now time");
        }

        Reservation reservation = new Reservation();
        Customer customer = new Customer();
        customer.setId(customerId);
        reservation.setCustomer(customer);
//        reservation.setPrice(screen.getDisCount());
        reservation.setScreen(screen);
        return reservationRepository.save(reservation);
    }

    @Transactional
    public Reservation reservation(ReservationDto.ReservationRequest reservationRequest) {
        Optional<Customer> customerOpt = customerRepository.findById(reservationRequest.getCustomerId());
        Customer customer = customerOpt.get();
        Optional<Screen> screenOpt = screenRepository.findById(reservationRequest.getScreenId());
        Screen screen = screenOpt.get();
        Reservation reservation = screen.reservation(customer);
        return reservationRepository.save(reservation);
    }
}
