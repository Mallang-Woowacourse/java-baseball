package baseball.application.step;

import baseball.application.BaseBallGameController;

public abstract class BaseBallGameStep implements Step {

    protected final BaseBallGameController controller;

    protected BaseBallGameStep(BaseBallGameController controller) {
        this.controller = controller;
    }
}
