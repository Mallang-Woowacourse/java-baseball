package baseball.application.step;

import baseball.application.BaseBallGameController;

public class InputNumber extends BaseBallGameStep {

    protected InputNumber(BaseBallGameController controller) {
        super(controller);
    }

    @Override
    public Step execute() {
        controller.inputNumber();
        return new Comparing(controller);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
