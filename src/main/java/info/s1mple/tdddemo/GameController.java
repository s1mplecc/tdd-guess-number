package info.s1mple.tdddemo;


import com.google.inject.Inject;
import info.s1mple.tdddemo.exceptions.AnswerIllegalException;

public class GameController {
    private static final int MAX_TIMES = 6;

    private Game game;
    private GameView gameView;

    @Inject
    public GameController(Game game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

    public void play(InputCollector inputCollector) {
        GuessResult guessResult = new GuessResult();

        while (notGameOver(guessResult)) {
            Answer inputAnswer;
            try {
                inputAnswer = inputCollector.input();
            } catch (AnswerIllegalException ex) {
                gameView.showMessage("Illegal input: " + ex.getMessage() + ", please re-enter.");
                continue;
            }
            guessResult = game.guess(inputAnswer);
            gameView.showCurrentResult(guessResult);
            gameView.showGuessHistory(game.guessHistory());
        }

        gameView.showMessage(guessResult.isCorrect() ? "successful" : "failed");
        gameView.showMessage("The correct number is: " + game.actualAnswer());
    }

    private boolean notGameOver(GuessResult guessResult) {
        return !guessResult.isCorrect() && game.guessHistory().size() < MAX_TIMES;
    }
}
