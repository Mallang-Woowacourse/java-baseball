package baseball.application;

import baseball.application.step.GameStart;
import baseball.application.step.Step;

public class BaseBallGameApplication {

    private final BaseBallGameController controller;

    private Step step;

    public BaseBallGameApplication(BaseBallGameController controller) {
        this.controller = controller;
        this.step = new GameStart(controller);
    }

    public void start() {
        while (step.executable()) {
            step = step.execute();
        }
    }
}
