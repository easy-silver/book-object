package chap10;

import chap02.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneTest {

    @DisplayName("통화 요금 계산")
    @Test
    void calculateFee() {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0),
                            LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
        phone.call(new Call(LocalDateTime.of(2018, 1, 2, 12, 10, 0),
                            LocalDateTime.of(2018, 1, 2, 12, 11, 0)));
        Money money = phone.calculateFee();
        assertThat(money.toString()).isEqualTo("60.0");
    }

}