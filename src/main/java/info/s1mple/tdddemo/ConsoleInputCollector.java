package info.s1mple.tdddemo;

import info.s1mple.tdddemo.exceptions.AnswerIllegalException;

import java.util.Scanner;

public class ConsoleInputCollector implements InputCollector {
    private Scanner scan = new Scanner(System.in);

    @Override
    public Answer input() throws AnswerIllegalException {
        String inputAnswer = scan.nextLine().trim();
        return Answer.createAnswer(inputAnswer);
    }
}
