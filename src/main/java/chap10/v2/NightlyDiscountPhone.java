package chap10.v2;

import chap02.Money;
import chap10.v1.Call;

import java.time.Duration;

/**
 * 심야 할인 요금제 계산을 담당하는 클래스
 * (일반 요금제를 계산하는 Phone 클래스를 상속받아 코드 재사용)
 */
public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone(Money amount, Duration seconds, double taxRate, Money nightlyAmount) {
        super(amount, seconds, taxRate);
        this.nightlyAmount = nightlyAmount;
    }

    @Override
    public Money calculateFee() {
        //부모 클래스의 calculateFee 호출
        Money result = super.calculateFee();

        Money nightlyFee = Money.ZERO;
        for (Call call : getCalls()) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(
                        getAmount().minus(nightlyAmount).times(
                                call.getDuration().getSeconds() / getSeconds().getSeconds()));
            }
        }

        return result.minus(nightlyFee.plus(nightlyFee.times(getTaxRate())));
    }

}
