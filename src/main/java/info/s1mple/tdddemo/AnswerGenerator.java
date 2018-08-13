package info.s1mple.tdddemo;

import java.util.LinkedHashSet;
import java.util.Set;

public class AnswerGenerator {
    private static final int ANSWER_NUMBERS_SIZE = 4;

    private final Set<Integer> answerNumbers = new LinkedHashSet<>(ANSWER_NUMBERS_SIZE);
    private RandomIntGenerator randomIntGenerator;

    public AnswerGenerator(RandomIntGenerator randomIntGenerator) {
        this.randomIntGenerator = randomIntGenerator;
    }

    public Answer generate() {
        while (answerNumbers.size() < ANSWER_NUMBERS_SIZE) {
            answerNumbers.add(randomIntGenerator.nextInt());
        }
        return new Answer(answerNumbers);
    }
}
