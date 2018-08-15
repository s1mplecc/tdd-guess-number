package info.s1mple.tdddemo;

import com.google.common.collect.Lists;

import java.util.List;

public class GuessResult {
    private boolean correct;
    private Result result;
    private Answer inputAnswer;

    public GuessResult() {
        this.correct = false;
    }

    public Answer inputAnswer() {
        return inputAnswer;
    }

    public String result() {
        return result.value();
    }

    public boolean isCorrect() {
        return this.correct;
    }

    public void analyzeBy(final Answer actualAnswer, final Answer inputAnswer) {
        this.inputAnswer = inputAnswer;
        this.result = computeResultBy(actualAnswer, inputAnswer);
        changeCorrectBy(result.aCount());
    }

    private Result computeResultBy(final Answer actualAnswer, final Answer inputAnswer) {
        List<Integer> inputAnswerNumbers = Lists.newArrayList(inputAnswer.answerNumbers());
        List<Integer> actualAnswerNumbers = Lists.newArrayList(actualAnswer.answerNumbers());

        int aCount = (int) actualAnswerNumbers.stream()
                .filter(x -> x.equals(inputAnswerNumbers.get(actualAnswerNumbers.indexOf(x))))
                .count();
        int bCount = (int) actualAnswerNumbers.stream()
                .filter(inputAnswerNumbers::contains)
                .count() - aCount;
        return new Result(aCount, bCount);
    }

    private void changeCorrectBy(int aCount) {
        if (aCount == 4) {
            correct = true;
        }
    }

    private static final class Result {
        private final String value;
        private final int aCount;

        private Result(int aCount, int bCount) {
            this.aCount = aCount;
            this.value = aCount + "A" + bCount + "B";
        }

        private String value() {
            return value;
        }

        private int aCount() {
            return aCount;
        }
    }
}
