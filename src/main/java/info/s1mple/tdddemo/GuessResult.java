package info.s1mple.tdddemo;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class GuessResult {
    private boolean correct = false;
    private String result;

    public GuessResult() {
    }

    public void analyzeResultBy(Answer actualAnswer, Answer inputAnswer) {
        ArrayList<Integer> actualAnswerNumbers = Lists.newArrayList(actualAnswer.answerNumbers());
        ArrayList<Integer> inputAnswerNumbers = Lists.newArrayList(inputAnswer.answerNumbers());

        this.result = getACount(actualAnswerNumbers, inputAnswerNumbers) + "A"
                + getBCount(actualAnswerNumbers, inputAnswerNumbers) + "B";
    }

    private int getACount(ArrayList<Integer> actualAnswerNumbers, ArrayList<Integer> inputAnswerNumbers) {
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
        return aCount;
    }

    private int getBCount(ArrayList<Integer> actualAnswerNumbers, ArrayList<Integer> inputAnswerNumbers) {
        return (int) actualAnswerNumbers.stream().filter(inputAnswerNumbers::contains).count();
    }

    public boolean isCorrect() {
        return this.correct;
    }

    public final String result() {
        return result;
    }
}
