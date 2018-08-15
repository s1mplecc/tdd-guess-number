package info.s1mple.tdddemo;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Answer actualAnswer;
    private final List<GuessResult> guessHistory;

    @Inject
    public Game(AnswerGenerator generator) {
        this.actualAnswer = generator.generate();
        guessHistory = new ArrayList<>(6);
    }

    public final Answer actualAnswer() {
        return actualAnswer;
    }

    public GuessResult guess(Answer inputAnswer) {
        GuessResult result = new GuessResult();
        result.analyzeBy(actualAnswer, inputAnswer);
        guessHistory.add(result);
        return result;
    }

    public final List<GuessResult> guessHistory() {
        return guessHistory;
    }
}
