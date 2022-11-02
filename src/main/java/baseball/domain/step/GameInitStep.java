package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;

public class GameInitStep implements Step{

    private static final Step next = new InputNumberStep();

    @Override
    public void execute(BaseBallGameContext context) {

    }

    @Override
    public Step next() {
        return next;
    }

    @Override
    public boolean executable() {
        return true;
    }
}
