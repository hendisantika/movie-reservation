package com.hendisantika.moviereservation.entity;

import com.hendisantika.moviereservation.strategy.DisCountStrategy;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
    @GeneratedValue
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
