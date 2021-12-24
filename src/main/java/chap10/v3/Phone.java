package chap10.v3;

import chap02.Money;
import chap10.v1.Call;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    //요금에 부과하는 세금 세율
    private double taxRate;
    //전체 통화 목록
    private final List<Call> calls = new ArrayList<>();

    public Phone(double taxRate) {
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result.plus(result.times(taxRate));
    }

    abstract protected Money calculateCallFee(Call call);
}
