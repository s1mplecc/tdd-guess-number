package info.s1mple.tdddemo.config;

import com.google.inject.AbstractModule;
import info.s1mple.tdddemo.ConsoleGameView;
import info.s1mple.tdddemo.ConsoleInputCollector;
import info.s1mple.tdddemo.GameView;
import info.s1mple.tdddemo.InputCollector;

public class GuessNumberModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(GameView.class).to(ConsoleGameView.class);
        bind(InputCollector.class).to(ConsoleInputCollector.class);
    }
}