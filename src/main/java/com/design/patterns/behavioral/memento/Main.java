package com.design.patterns.behavioral.memento;

public class Main {
    public static void main(String[] args) {
        var editor = new Editor();
        var history =  new History();

        editor.write("a");
        history.push(editor.createState());

        editor.write("b");
        history.push(editor.createState());

        editor.write("c");
        history.push(editor.createState());

        history.getStates().forEach(System.out::println);
        System.out.println("----------------------");

        editor.restore(history.undo());
        editor.restore(history.undo());

        System.out.println(editor.getContent());
    }
}
