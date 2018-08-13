package info.s1mple.tdddemo;

public class GuessResult {
    private final String result;

    private GuessResult(String result) {
        this.result = result;
    }

    public static GuessResult analyze(Answer actualAnswer, Answer inputAnswer) {
        // todo: analyze inputAnswer with actualAnswer, return xAxB result
//        actualAnswer.answerNumbers();
        return new GuessResult("");
    }

    public final String result() {
        return result;
    }
}
