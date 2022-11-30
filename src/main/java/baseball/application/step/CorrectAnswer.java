package baseball.application.step;

import baseball.application.BaseBallGameController;

public class CorrectAnswer extends BaseBallGameStep {

    protected CorrectAnswer(BaseBallGameController controller) {
        super(controller);
    }

    @Override
    public Step execute() {
        controller.printCorrectAnswer();
        return new InputRestart(controller);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
