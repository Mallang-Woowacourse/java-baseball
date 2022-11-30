package baseball.domain.baseballnumber;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class ManualBaseBallNumber extends BaseBallNumber {

    public ManualBaseBallNumber(final String input) {
        super(stream(input.split(""))
                .map(Integer::parseInt)
                .collect(toList()));
    }
}
