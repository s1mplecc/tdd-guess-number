package info.s1mple.tdddemo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
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
        ArrayList<Integer> actualAnswerNumbers = Lists.newArrayList(actualAnswer.answerNumbers());
        ArrayList<Integer> inputAnswerNumbers = Lists.newArrayList(inputAnswer.answerNumbers());

        this.inputAnswer = inputAnswer;
        this.result = computeACountBy(actualAnswerNumbers, inputAnswerNumbers) + "A"
                + computeBCountBy(actualAnswerNumbers, inputAnswerNumbers) + "B";
    }

    private int computeACountBy(List<Integer> actualAnswerNumbers, List<Integer> inputAnswerNumbers) {
        int aCount = 0;
        for (int i = actualAnswerNumbers.size() - 1; i >= 0; i--) {
            if (actualAnswerNumbers.get(i).equals(inputAnswerNumbers.get(i))) {
                aCount++;
                actualAnswerNumbers.remove(i);
                inputAnswerNumbers.remove(i);
            }
        }
        if (aCount == 4) {
            this.correct = true;
        }
//        actualAnswerNumbers.stream().filter(x -> x.equals(inputAnswerNumbers.get(actualAnswerNumbers.indexOf(x)))).count();
        return aCount;
    }

    private int computeBCountBy(List<Integer> actualAnswerNumbers, List<Integer> inputAnswerNumbers) {
        return (int) actualAnswerNumbers.stream().filter(inputAnswerNumbers::contains).count();
    }
}
