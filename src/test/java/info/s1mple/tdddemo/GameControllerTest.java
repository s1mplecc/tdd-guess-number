package info.s1mple.tdddemo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class GameControllerTest {
    @Mock
    private InputCollector mockCollector;
    @Mock
    private GameView mockGameView;
    @Mock
    private AnswerGenerator mockGenerator;

    private GameController gameController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Answer actualAnswer = Answer.createAnswer("1 2 3 4");

        when(mockGenerator.generate()).thenReturn(actualAnswer);
        Game game = new Game(mockGenerator);
        gameController = new GameController(game, mockGameView);
    }

    @Test
    public void should_display_guess_message_when_guess_number_sixth() {
        Answer errorAnswer = Answer.createAnswer("1 2 5 6");
        when(mockCollector.input()).thenReturn(errorAnswer);

        gameController.play(mockCollector);

        verify(mockGameView, times(6)).showCurrentResult(
                argThat(guessResult -> !guessResult.isCorrect() && guessResult.result().equals("2A0B")));
        verify(mockGameView, atLeastOnce()).showGuessHistory(argThat(results -> results.size() == 6));
    }

    @Test
    public void should_display_guess_message_when_guess_number_twice_and_second_answer_is_correct() {
        Answer errorAnswer = Answer.createAnswer("1 2 5 6");
        Answer correctAnswer = Answer.createAnswer("1 2 3 4");
        when(mockCollector.input()).thenReturn(errorAnswer, correctAnswer);

        gameController.play(mockCollector);

        verify(mockGameView).showCurrentResult(
                argThat(guessResult -> !guessResult.isCorrect() && guessResult.result().equals("2A0B")));
        verify(mockGameView).showCurrentResult(
                argThat(guessResult -> guessResult.isCorrect() && guessResult.result().equals("4A0B")));
        verify(mockGameView, times(2)).showGuessHistory(argThat(results -> results.size() == 2));
    }
}