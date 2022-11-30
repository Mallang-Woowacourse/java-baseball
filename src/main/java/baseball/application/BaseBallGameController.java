package baseball.application;

import baseball.domain.baseballnumber.AutoBaseBallNumber;
import baseball.domain.baseballnumber.BaseBallNumber;
import baseball.domain.baseballnumber.ManualBaseBallNumber;
import baseball.domain.command.GameCommand;
import baseball.domain.compare.CompareResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameController {

    private final InputView inputView;
    private final OutputView outputView;

    private BaseBallNumber computer;
    private BaseBallNumber player;

    public BaseBallGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.printStart();
    }

    public void generateComputerNumber() {
        computer = AutoBaseBallNumber.generate();
    }

    public void inputNumber() {
        player = new ManualBaseBallNumber(inputView.inputNumber());
    }

    public CompareResult compareNumber() {
        CompareResult result = computer.compare(player);
        outputView.printCompareResult(result);
        return result;
    }

    public void printCorrectAnswer() {
        outputView.printCorrectAnswer();
    }

    public GameCommand inputRestart() {
        return GameCommand.of(inputView.inputRestart());
    }
}
