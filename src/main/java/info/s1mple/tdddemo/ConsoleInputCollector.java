package info.s1mple.tdddemo;

import java.util.Scanner;

public class ConsoleInputCollector implements InputCollector {
    private Scanner scan = new Scanner(System.in);

    @Override
    public Answer input() {
        String inputAnswer = scan.next();
        return Answer.createAnswer(inputAnswer);
    }
}
