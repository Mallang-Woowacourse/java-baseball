package baseball.application.step;

import baseball.application.BaseBallGameController;
import baseball.domain.compare.CompareResult;

public class Comparing extends BaseBallGameStep {

    protected Comparing(BaseBallGameController controller) {
        super(controller);
    }

    @Override
    public Step execute() {
        CompareResult result = controller.compareNumber();
        return judgeNext(result);
    }

    private Step judgeNext(CompareResult result) {
        if (result.isAnswer()) {
            return new CorrectAnswer(controller);
        }
        return new InputNumber(controller);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
