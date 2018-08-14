package info.s1mple.tdddemo;

import java.util.List;

public class GameView {
    public void showCurrentResult(GuessResult guessResult) {
        System.out.println("------showCurrentResult------");
        System.out.println(guessResult.result());
    }

    public void showGuessHistory(List<GuessResult> guessResults) {
        System.out.println("------showGuessHistory------");
        for (GuessResult guessResult : guessResults) {
            System.out.println(guessResult);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
