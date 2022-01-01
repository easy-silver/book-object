package chap11.phone.v1.regular;

import chap02.Money;
import chap11.phone.v1.Call;
import chap11.phone.v1.Phone;

import java.time.Duration;

public class RegularPhone extends Phone {

    private Money amount;
    private Duration seconds;

    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }

}
