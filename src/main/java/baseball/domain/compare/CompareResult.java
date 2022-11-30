package baseball.domain.compare;

public class CompareResult {

    private static final int ANSWER_STRIKE_COUNT = 3;

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

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike + ball == 0;
    }

    public boolean isAnswer() {
        return ANSWER_STRIKE_COUNT == this.strike;
    }
}
