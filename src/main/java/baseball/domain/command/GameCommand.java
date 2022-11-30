package baseball.domain.command;

import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableMap;

public enum GameCommand {

    RESTART("1"),
    QUIT("2"),
    ;

    private final String shortcut;
    private static final Map<String, GameCommand> BY_SHORTCUT = stream(values())
                    .collect(toUnmodifiableMap(GameCommand::shortcut, command -> command));

    GameCommand(String shortcut) {
        this.shortcut = shortcut;
    }

    public static GameCommand of(final String shortcut) {
        return Optional.ofNullable(BY_SHORTCUT.get(shortcut))
                .orElseThrow(IllegalArgumentException::new);
    }

    public String shortcut() {
        return shortcut;
    }

}
