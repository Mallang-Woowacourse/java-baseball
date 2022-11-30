package baseball.domain.compare;

public class CompareResult {

    private final int strike;
    private final int ball;

    private CompareResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static CompareResult nothing() {
        return new CompareResult(0, 0);
    }

    public static CompareResult strike() {
        return new CompareResult(1, 0);
    }

    public static CompareResult ball() {
        return new CompareResult(0, 1);
    }

    public CompareResult add(CompareResult result) {
        return new CompareResult(this.strike + result.strike, this.ball + result.ball);
    }
}
