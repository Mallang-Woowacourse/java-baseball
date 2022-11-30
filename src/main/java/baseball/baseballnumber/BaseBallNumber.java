package baseball.baseballnumber;

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
}
