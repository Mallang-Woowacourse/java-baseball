package baseball.view;

import baseball.domain.compare.CompareResult;

import static java.lang.String.format;

public class OutputView {

    private static final String START ="숫자 야구 게임을 시작합니다.";
    private static final String STRIKE_FORMAT ="%d스트라이크";
    private static final String BALL_FORMAT ="%d볼";
    private static final String NOTHING ="낫싱";
    private static final String RESULT_FORMAT = BALL_FORMAT + " " + STRIKE_FORMAT;
    private static final String ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStart() {
        System.out.println(START);
    }

    public void printCorrectAnswer() {
        System.out.println(ANSWER);
    }

    public void printCompareResult(CompareResult result) {
        System.out.println(parseResultMessage(result));
    }

    private String parseResultMessage(CompareResult result) {
        if (result.isNothing()) {
            return NOTHING;
        }
        if (result.getBall() == 0) {
           return format(STRIKE_FORMAT, result.getStrike());
        }
        if (result.getStrike() == 0) {
          return format(BALL_FORMAT, result.getBall());
        }
        return format(RESULT_FORMAT, result.getBall(), result.getStrike());
    }
}
