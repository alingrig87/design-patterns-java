package com.design.patterns.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

//Caretaker
public class History {
    private final List<EditorState> states = new ArrayList<>();

    public List<EditorState> getStates() {
        return this.states;
    }

    public void push(EditorState state) {
        states.add(state);
    }

    public EditorState undo() {
        var lastIndex = states.size() - 1;
        var lastState = states.get(lastIndex);

        states.remove(lastState);

        return states.get(lastIndex - 1);
    }
}
