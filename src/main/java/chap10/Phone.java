package chap10;

import chap02.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 통화 목록을 관리하는 클래스
 * 통화 요금을 계산
 */
public class Phone {
    //단위 요금
    private Money amount;
    //단위 시간
    private Duration seconds;
    //전체 통화 목록
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
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

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result;
    }
}
