package info.s1mple.tdddemo;

import info.s1mple.tdddemo.exceptions.AnswerIllegalException;

import java.util.HashSet;
import java.util.Set;

public class Answer {
    private static final int NUMBER_SIZE = 4;
    private static final String SPACE = " ";

    private final String answer;

    private Answer(String answer) throws AnswerIllegalException {
        this.answer = answer;
        validate();
    }

    public static Answer createAnswer(String inputAnswer) throws AnswerIllegalException {
        return new Answer(inputAnswer);
    }

    public void validate() throws AnswerIllegalException {
        Set<Integer> numbers = parseInputAnswer();

        if (numbers.size() != NUMBER_SIZE) {
            throw new AnswerIllegalException("Invalid input.");
        }
    }

    private Set<Integer> parseInputAnswer() throws AnswerIllegalException {
        Set<Integer> results = new HashSet<>(4);
        for (String answerItem : answer.split(SPACE)) {
            try {
                results.add(Integer.parseInt(answerItem));
            } catch (NumberFormatException ex) {
                throw new AnswerIllegalException("Input: " + answerItem + " is not a number.");
            }
        }
        return results;
    }
}
