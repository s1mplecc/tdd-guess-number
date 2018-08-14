package info.s1mple.tdddemo;

import java.util.List;

public class ConsoleGameView implements GameView {
    @Override
    public void showCurrentResult(GuessResult guessResult) {
        System.out.println("---------Current Result---------");
        System.out.println(guessResult.result());
    }

    @Override
    public void showGuessHistory(List<GuessResult> guessResults) {
        System.out.println("---------Guess History----------");
        for (GuessResult guessResult : guessResults) {
            System.out.println(guessResult.inputAnswer() + "       |  " + guessResult.result());
        }
        System.out.println();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
