package baseball.application.step;

import baseball.application.BaseBallGameController;

public class Exit extends BaseBallGameStep {

    protected Exit(BaseBallGameController controller) {
        super(controller);
    }

    @Override
    public Step execute() {
        throw new IllegalStateException();
    }

    @Override
    public boolean executable() {
        return false;
    }
}
