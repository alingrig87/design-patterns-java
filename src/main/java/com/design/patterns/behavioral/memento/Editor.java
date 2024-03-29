package com.design.patterns.behavioral.memento;


// Originator
public class Editor {
    private String content = "";

    public String getContent() {
        return content;
    }

    public void write(String content) {
        this.content += content;
    }

    public EditorState createState() {
        return new EditorState(content);
    }

    public void restore(EditorState state) {
        content = state.getContent();
    }
}
