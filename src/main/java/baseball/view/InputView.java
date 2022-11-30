package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputNumber() {
        System.out.print(INPUT_NUMBER);
        String input = Console.readLine();
        validateNumber(input);
        return input;
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public String inputRestart() {
        System.out.println(INPUT_RESTART);
        return Console.readLine();
    }
}
