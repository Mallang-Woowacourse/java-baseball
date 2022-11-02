package baseball.application.context;

import baseball.application.config.BaseBallGameConfig;
import baseball.application.io.Reader;
import baseball.application.io.Writer;
import baseball.application.random.RandomNumberGenerator;
import baseball.application.random.Range;
import baseball.domain.comparator.Comparator;
import baseball.domain.computer.Computer;
import baseball.domain.number.BaseBallGameNumbers;
import baseball.domain.player.Player;

import java.util.List;

public class BaseBallGameContext {

    private static final Range RANGE = new Range(1, 9);
    private static final int COUNT = 3;

    private final Writer writer;
    private final Reader reader;
    private final RandomNumberGenerator randomNumberGenerator;

    private Player player;
    private Computer computer;
    private final Comparator comparator = new Comparator();

    public BaseBallGameContext(BaseBallGameConfig config) {
        this.writer = config.writer();
        this.reader = config.reader();
        this.randomNumberGenerator = config.randomNumberGenerator();
    }

    public Writer writer() {
        return writer;
    }

    public Reader reader() {
        return reader;
    }

    public Player player() {
        return player;
    }

    public Computer computer() {
        return computer;
    }

    public Comparator comparator() {
        return comparator;
    }

    public void init() {
        this.player = new Player();

        List<Integer> numbers = randomNumberGenerator.generateUniqueNumberInRange(RANGE, COUNT);
        BaseBallGameNumbers result = new BaseBallGameNumbers(numbers);
        this.computer = new Computer(result);
    }

    public void changePlayerNumbers(BaseBallGameNumbers baseBallGameNumbers) {
        player.changeNumbers(baseBallGameNumbers);
    }
}
