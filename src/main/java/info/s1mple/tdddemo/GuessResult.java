package info.s1mple.tdddemo;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class GuessResult {
    private final String result;

    private GuessResult(String result) {
        this.result = result;
    }

    public static GuessResult analyze(Answer actualAnswer, Answer inputAnswer) {
        ArrayList<Integer> actualAnswerNumbers = Lists.newArrayList(actualAnswer.answerNumbers());
        ArrayList<Integer> inputAnswerNumbers = Lists.newArrayList(inputAnswer.answerNumbers());
        return new GuessResult(getACount(actualAnswerNumbers, inputAnswerNumbers) + "A"
                + getBCount(actualAnswerNumbers, inputAnswerNumbers) + "B");
    }

    private static int getBCount(ArrayList<Integer> actualAnswerNumbers, ArrayList<Integer> inputAnswerNumbers) {
        return (int) actualAnswerNumbers.stream().filter(inputAnswerNumbers::contains).count();
    }

    private static int getACount(ArrayList<Integer> actualAnswerNumbers, ArrayList<Integer> inputAnswerNumbers) {
        int aCount = 0;
        for (int i = actualAnswerNumbers.size() - 1; i >= 0; i--) {
            if (actualAnswerNumbers.get(i).equals(inputAnswerNumbers.get(i))) {
                aCount++;
                actualAnswerNumbers.remove(i);
                inputAnswerNumbers.remove(i);
            }
        }
        return aCount;
    }

    public final String result() {
        return result;
    }
}
