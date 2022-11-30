package baseball.application.step;

import baseball.application.BaseBallGameController;

public class InitGame extends BaseBallGameStep {

    protected InitGame(BaseBallGameController controller) {
        super(controller);
    }

    @Override
    public Step execute() {
        controller.generateComputerNumber();
        return new InputNumber(controller);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
