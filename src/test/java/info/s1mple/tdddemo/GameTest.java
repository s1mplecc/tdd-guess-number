package info.s1mple.tdddemo;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    private final Answer actualAnswer = Answer.createAnswer("1 2 3 4");
    private Game game;

    @Before
    public void setUp() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
    }

    @Test
    public void should_record_every_guess_result() {
        game.guess(Answer.createAnswer("2 1 6 7"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("1 2 6 7"));
        game.guess(Answer.createAnswer("0 3 2 4"));

        List<GuessResult> guessHistory = game.guessHistory();

        assertThat(guessHistory.size()).isEqualTo(4);
        assertThat(guessHistory.get(0).result()).isEqualTo("0A2B");
        assertThat(guessHistory.get(1).result()).isEqualTo("4A0B");
        assertThat(guessHistory.get(2).result()).isEqualTo("2A0B");
        assertThat(guessHistory.get(3).result()).isEqualTo("1A2B");
    }
}