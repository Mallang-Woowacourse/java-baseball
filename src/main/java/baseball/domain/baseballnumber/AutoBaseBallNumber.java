package baseball.domain.baseballnumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AutoBaseBallNumber extends BaseBallNumber {

    private AutoBaseBallNumber(final List<Integer> integers) {
        super(integers);
    }

    public static AutoBaseBallNumber generate() {
        Set<Integer> result = new LinkedHashSet<>();
        while (result.size() < SIZE) {
            result.add(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE));
        }
        return new AutoBaseBallNumber(new ArrayList<>(result));
    }
}
