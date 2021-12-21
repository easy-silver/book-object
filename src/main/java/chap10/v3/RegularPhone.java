package chap10.v3;

import chap02.Money;
import chap10.v1.Call;

import java.time.Duration;

/**
 * 통화 목록을 관리하는 클래스
 * 통화 요금을 계산
 */
public class RegularPhone extends Phone {
    //단위 요금
    private final Money amount;
    //단위 시간
    private final Duration seconds;

    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
