package baseball.application.step;

import baseball.application.BaseBallGameController;

public class GameStart extends BaseBallGameStep {

    public GameStart(BaseBallGameController controller) {
        super(controller);
    }

    @Override
    public Step execute() {
        controller.startGame();
        return new InitGame(controller);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
