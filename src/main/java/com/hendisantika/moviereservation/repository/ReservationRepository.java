package com.hendisantika.moviereservation.repository;

import com.hendisantika.moviereservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : movie-reservation
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/07/18
 * Time: 05.13
 * To change this template use File | Settings | File Templates.
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
