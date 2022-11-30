package baseball.application.step;

import baseball.application.BaseBallGameController;
import baseball.domain.command.GameCommand;

public class InputRestart extends BaseBallGameStep {

    protected InputRestart(BaseBallGameController controller) {
        super(controller);
    }

    @Override
    public Step execute() {
        GameCommand gameCommand = controller.inputRestart();
        return judgeNext(gameCommand);
    }

    private Step judgeNext(GameCommand gameCommand) {
        if (gameCommand == GameCommand.RESTART) {
            return new InitGame(controller);
        }
        return Exit(controller);
    }

    @Override
    public boolean executable() {
        return true;
    }
}
