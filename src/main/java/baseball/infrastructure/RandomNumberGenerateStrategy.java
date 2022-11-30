package baseball.infrastructure;

import baseball.domain.generate.NumberGenerateStrategy;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {

    @Override
    public List<Integer> generate(int maxValue, int minValue, int size) {
        Set<Integer> result = new LinkedHashSet<>();
        while (result.size() < size) {
            result.add(Randoms.pickNumberInRange(minValue, maxValue));
        }
        return List.copyOf(result);
    }
}
