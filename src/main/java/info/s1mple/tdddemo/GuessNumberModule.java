package info.s1mple.tdddemo;

import com.google.inject.AbstractModule;

public class GuessNumberModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(GameView.class).to(ConsoleGameView.class);
        bind(InputCollector.class).to(ConsoleInputCollector.class);
    }
}