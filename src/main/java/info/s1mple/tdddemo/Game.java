package info.s1mple.tdddemo;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Answer actualAnswer;
    private final List<GuessResult> guessHistory;

    public Game(AnswerGenerator generator) {
        this.actualAnswer = generator.generate();
        guessHistory = new ArrayList<>(6);
    }

    public GuessResult guess(Answer answer) {
        GuessResult result = new GuessResult();
        result.analyzeResultBy(actualAnswer, answer);
        guessHistory.add(result);
        return result;
    }

    public final List<GuessResult> guessHistory() {
        return guessHistory;
    }
}
