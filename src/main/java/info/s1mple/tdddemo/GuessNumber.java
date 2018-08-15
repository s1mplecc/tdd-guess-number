package info.s1mple.tdddemo;

import com.google.inject.Injector;
import info.s1mple.tdddemo.config.GuessNumberModule;

import static com.google.inject.Guice.createInjector;

public class GuessNumber {
    public static void main(String[] args) {
        Injector injector = createInjector(new GuessNumberModule());
        GameController gameController = injector.getInstance(GameController.class);
        InputCollector command = new ConsoleInputCollector();

        System.out.println("Please input four numbers following by X X X X(0--9)");
        gameController.play(command);
    }
}