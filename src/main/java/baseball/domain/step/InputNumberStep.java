package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import baseball.application.io.Writer;
import baseball.domain.number.BaseBallGameNumbers;

public class InputNumberStep implements Step{

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    private static final Step next = new GameProgressStep();

    @Override
    public void execute(BaseBallGameContext context) {
        Writer writer = context.writer();
        writer.println(INPUT_NUMBER_MESSAGE);

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
