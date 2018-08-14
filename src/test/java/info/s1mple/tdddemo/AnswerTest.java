package info.s1mple.tdddemo;

import info.s1mple.tdddemo.exceptions.AnswerIllegalException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {
    private String inputAnswer;

    @Test
    public void should_throw_AnswerIllegalException_and_message_contains_number_cannot_be_repeated() {
        inputAnswer = "1 1 2 3";
        assertExceptionMessageContains("number cannot be repeated");
    }

    @Test
    public void should_throw_AnswerIllegalException_and_message_contains_is_not_a_number() {
        inputAnswer = "a 1 2 3";
        assertExceptionMessageContains("is not a number");
    }

    @Test
    public void should_throw_AnswerIllegalException_and_message_contains_is_out_of_range() {
        inputAnswer = "10 1 2 3";
        assertExceptionMessageContains("is out of range");
    }

    private void assertExceptionMessageContains(String message) {
        try {
            Answer.createAnswer(inputAnswer);
        } catch (AnswerIllegalException ex) {
            assertThat(ex.getMessage()).contains(message);
        }
    }
}