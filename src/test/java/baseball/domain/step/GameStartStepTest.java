package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("GameStartStep 은 ")
class GameStartStepTest {

    @Test
    @DisplayName("실행 가능하다")
    public void isExecutable() {
        // given
        GameStartStep gameStartStep = new GameStartStep();

        // when
        boolean executable = gameStartStep.executable();

        // then
        assertThat(executable).isTrue();
    }

    @Test
    @DisplayName("다음 단계로 [게임 초기화 단계]를 갖는다")
    public void nextIsGameInitStep() {
        // given
        GameStartStep gameStartStep = new GameStartStep();

        // when
        Step next = gameStartStep.next();

        // then
        assertThat(next).isExactlyInstanceOf(GameInitStep.class);
    }

    @Test
    @DisplayName("실행 시 게임 실행 문구를 출력한다.")
    public void printStartMessageWhenExecuted() throws Exception {
        // given
        final String startMessage = "숫자 야구 게임을 시작합니다.";
        BaseBallGameContext context = mock(BaseBallGameContext.class);
        GameStartStep gameStartStep = new GameStartStep();

        // when
        gameStartStep.execute(context);

        // then
        verify(context, times(1)).println(startMessage);
    }
}