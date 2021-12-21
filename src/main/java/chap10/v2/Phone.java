package chap10.v2;

import chap02.Money;
import chap10.v1.Call;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 일반 요금 계산을 담당하는 클래스
 */
public class Phone {
    //단위 요금
    private Money amount;
    //단위 시간
    private Duration seconds;
    //전체 통화 목록
    private List<Call> calls = new ArrayList<>();
    //세율
    private double taxRate;

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result.plus(result.times(taxRate));
    }
}
