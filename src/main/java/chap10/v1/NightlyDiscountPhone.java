package chap10.v1;

import chap02.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 심야 할인 요금제를 계산
 */
public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    //심야 할인 요금
    private final Money nightlyAmount;
    //일반 요금
    private final Money regularAmount;
    //단위 시간(초)
    private final Duration seconds;
    //세율
    private final double taxRate;
    //통화 목록
    private final List<Call> calls = new ArrayList<>();

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    //심야 요금을 고려한 통화 요금 계산
    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(
                        nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }else {
                result = result.plus(
                        regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }

        return result.plus(result.times(taxRate));
    }
}
