package info.s1mple.tdddemo;


import com.google.inject.Inject;

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
        GuessResult guessResult;
        do {
            Answer inputAnswer = inputCollector.input();
            guessResult = game.guess(inputAnswer);
            gameView.showCurrentResult(guessResult);
            gameView.showGuessHistory(game.guessHistory());
        } while (notGameOver(guessResult));

        gameView.showMessage(guessResult.isCorrect() ? "successful" : "failed");
        gameView.showMessage("The correct number is: " + game.actualAnswer());
    }

    private boolean notGameOver(GuessResult guessResult) {
        return !guessResult.isCorrect() && game.guessHistory().size() < MAX_TIMES;
    }
}
