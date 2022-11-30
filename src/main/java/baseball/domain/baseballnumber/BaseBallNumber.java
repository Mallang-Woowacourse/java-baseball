package baseball.domain.baseballnumber;

import baseball.domain.compare.CompareResult;

import java.util.LinkedHashSet;
import java.util.List;

public abstract class BaseBallNumber {

    protected static final int MAX_VALUE = 9;
    protected static final int MIN_VALUE = 1;
    protected static final int SIZE = 3;

    protected final List<Integer> numbers;

    protected BaseBallNumber(final List<Integer> integers) {
        validate(integers);
        this.numbers = integers;
    }

    private void validate(final List<Integer> integers) {
        validateSize(integers);
        validateRange(integers);
    }

    private void validateSize(final List<Integer> integers) {
        if (new LinkedHashSet<>(integers).size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(final List<Integer> integers) {
        for (Integer integer : integers) {
            if (integer > MAX_VALUE || integer < MIN_VALUE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public CompareResult compare(final BaseBallNumber baseBallNumber) {
        CompareResult result = CompareResult.nothing();
        for (int i = 0; i < baseBallNumber.numbers.size(); i++) {
            result = result.add(compare(i, baseBallNumber.numbers.get(i)));
        }
        return result;
    }

    public CompareResult compare(final int index, final Integer number) {
        if (isStrike(index, number)) {
            return CompareResult.strike();
        }
        if (isBall(number)) {
            return CompareResult.ball();
        }
        return CompareResult.nothing();
    }

    private boolean isStrike(final int index, final Integer number) {
        return this.numbers.get(index).equals(number);
    }

    private boolean isBall(final Integer number) {
        return this.numbers.contains(number);
    }
}
