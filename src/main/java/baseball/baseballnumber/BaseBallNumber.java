package baseball.baseballnumber;

import baseball.compare.CompareResult;

import java.util.LinkedHashSet;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class BaseBallNumber {

    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private static final int SIZE = 3;

    private final List<Integer> numbers;

    public BaseBallNumber(final List<Integer> integers) {
        validate(integers);
        this.numbers = integers;
    }

    public BaseBallNumber(final String input) {
        this(stream(input.split(""))
                .map(Integer::parseInt)
                .collect(toList()));
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

    private CompareResult compare(final int index, final Integer number) {
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
