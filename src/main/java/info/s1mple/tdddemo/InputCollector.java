package info.s1mple.tdddemo;

import info.s1mple.tdddemo.exceptions.AnswerIllegalException;

public interface InputCollector {
    Answer input() throws AnswerIllegalException;
}
