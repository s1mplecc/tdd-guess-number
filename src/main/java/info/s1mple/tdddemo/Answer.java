package info.s1mple.tdddemo;

import info.s1mple.tdddemo.exceptions.AnswerIllegalException;

import java.util.LinkedHashSet;
import java.util.Set;

public class Answer {
    private static final int ANSWER_NUMBERS_SIZE = 4;
    private static final String SPACE = " ";
    private Set<Integer> answerNumbers = new LinkedHashSet<>(ANSWER_NUMBERS_SIZE);

    private Answer(String answer) {
        parseAnswerString(answer);
        validate();
    }

    public Answer(Set<Integer> answerNumbers) throws AnswerIllegalException {
        this.answerNumbers = answerNumbers;
        validate();
    }

    public static Answer createAnswer(String inputAnswer) throws AnswerIllegalException {
        return new Answer(inputAnswer);
    }

    @Override
    public String toString() {
        return answerNumbers.stream().map(x -> x.toString()).reduce((x, y) -> x + " " + y).orElse("");
    }

    public Set<Integer> answerNumbers() {
        return answerNumbers;
    }

    private void validate() throws AnswerIllegalException {
        if (answerNumbers.size() != ANSWER_NUMBERS_SIZE) {
            throw new AnswerIllegalException("number cannot be repeated");
        }
        for (Integer answerNumber : answerNumbers) {
            if (answerNumber > 9 || answerNumber < 0) {
                throw new AnswerIllegalException(answerNumber + " is out of range");
            }
        }
    }

    private void parseAnswerString(String answer) throws AnswerIllegalException {
        for (String answerNumber : answer.split(SPACE)) {
            try {
                answerNumbers.add(Integer.parseInt(answerNumber));
            } catch (NumberFormatException ex) {
                throw new AnswerIllegalException(answerNumber + " is not a number");
            }
        }
    }
}
