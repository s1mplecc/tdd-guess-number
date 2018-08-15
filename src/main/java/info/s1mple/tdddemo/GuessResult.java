package info.s1mple.tdddemo;

import com.google.common.collect.Lists;

import java.util.List;

public class GuessResult {
    private boolean correct = false;
    private String result;
    private Answer inputAnswer;

    public GuessResult() {
    }

    public Answer inputAnswer() {
        return inputAnswer;
    }

    public String result() {
        return result;
    }

    public boolean isCorrect() {
        return this.correct;
    }

    public void analyzeBy(final Answer actualAnswer, final Answer inputAnswer) {
        this.inputAnswer = inputAnswer;
        this.result = computeAndComposeResultBy(actualAnswer, inputAnswer);
        // todo: change correct status -> true if 4A
    }

    private String computeAndComposeResultBy(final Answer actualAnswer, final Answer inputAnswer) {
        List<Integer> inputAnswerNumbers = Lists.newArrayList(inputAnswer.answerNumbers());
        List<Integer> actualAnswerNumbers = Lists.newArrayList(actualAnswer.answerNumbers());

        int aCount = (int) actualAnswerNumbers.stream()
                .filter(x -> x.equals(inputAnswerNumbers.get(actualAnswerNumbers.indexOf(x))))
                .count();
        int bCount = (int) actualAnswerNumbers.stream()
                .filter(inputAnswerNumbers::contains)
                .count() - aCount;
        return aCount + "A" + bCount + "B";
    }
}
