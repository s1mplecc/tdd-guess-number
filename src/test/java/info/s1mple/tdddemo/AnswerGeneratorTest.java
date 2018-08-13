package info.s1mple.tdddemo;

import info.s1mple.tdddemo.exceptions.AnswerIllegalException;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerGeneratorTest {

    @Test(expected = AnswerIllegalException.class)
    public void should_throw_AnswerIllegalException_when_is_not_between_0_and_9() throws AnswerIllegalException {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.nextInt()).thenReturn(1, 2, 3, 10);
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        answerGenerator.generate();
    }
}