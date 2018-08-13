package info.s1mple.tdddemo;

import info.s1mple.tdddemo.exceptions.AnswerIllegalException;

import java.util.LinkedHashSet;
import java.util.Set;

public class Answer {
    private static final int NUMBER_SIZE = 4;
    private static final String SPACE = " ";

    private final String answer;
    private final Set<Integer> answerNumbers = new LinkedHashSet<>(4);

    private Answer(String answer) throws AnswerIllegalException {
        this.answer = answer;
        parseAnswerString();
        validate();
    }

    public static Answer createAnswer(String inputAnswer) throws AnswerIllegalException {
        return new Answer(inputAnswer);
    }

    private void validate() throws AnswerIllegalException {
        if (answerNumbers.size() != NUMBER_SIZE) {
            throw new AnswerIllegalException("Invalid input.");
        }
    }

    private void parseAnswerString() throws AnswerIllegalException {
        for (String answerNumber : answer.split(SPACE)) {
            try {
                answerNumbers.add(Integer.parseInt(answerNumber));
            } catch (NumberFormatException ex) {
                throw new AnswerIllegalException("Input: " + answerNumber + " is not a number.");
            }
        }
    }
}
