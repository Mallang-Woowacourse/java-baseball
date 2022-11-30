package baseball;

import baseball.application.BaseBallGameApplication;
import baseball.application.BaseBallGameController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BaseBallGameController controller = new BaseBallGameController(inputView, outputView);
        new BaseBallGameApplication(controller).start();
    }
}
