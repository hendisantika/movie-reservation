package com.hendisantika.moviereservation.entity;

import com.hendisantika.moviereservation.strategy.DisCountStrategy;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Transient;
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
 * Time: 06.44
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@ToString(exclude = {"screens", "disCount"})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Screen> screens = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private DisCount disCount;

    private String runningTime;

    @Transient
    private DisCountStrategy disCountStrategy;

    void setDisCountStrategy(DisCountStrategy disCountStrategy) {
        this.disCountStrategy = disCountStrategy;
    }

    public BigDecimal calculateFee(Screen screen) {
        return price.subtract(disCountStrategy.calculateDisCountFee(screen));
    }
}
