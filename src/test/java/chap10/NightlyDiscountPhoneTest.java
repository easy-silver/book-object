package chap10;

import chap02.Money;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class NightlyDiscountPhoneTest {

    @Test
    void calculateFee() {
        NightlyDiscountPhone phone = new NightlyDiscountPhone(Money.wons(2), Money.wons(5), Duration.ofSeconds(10));

        //일반 통화
        phone.call(new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0),
                            LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
        Money regularFee = phone.calculateFee();
        assertThat(regularFee.toString()).isEqualTo("30.0");

        phone.call(new Call(LocalDateTime.of(2018, 1, 1, 22, 0, 0),
                            LocalDateTime.of(2018, 1, 1, 22, 1, 0)));
        Money nightlyFee = phone.calculateFee();
        assertThat(nightlyFee.toString()).isEqualTo("42.0");
    }

}