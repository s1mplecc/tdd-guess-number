package info.s1mple.tdddemo.exceptions;

public class AnswerIllegalException extends Exception {
    public AnswerIllegalException(String message) {
        super(message);
    }

    public AnswerIllegalException(String message, Throwable cause) {
        super(message, cause);
    }
}
