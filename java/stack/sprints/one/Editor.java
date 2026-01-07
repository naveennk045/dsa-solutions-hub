package stack.sprints.one;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Collectors;

public class Editor {

    private Stack<String> undo;
    private Stack<String> redo;

    public Editor() {
        undo = new Stack<>();
        redo = new Stack<>();
    }

    public void write(String text) {
        undo.push(text);
        redo.clear();
    }

    public void undo() {
        if (undo.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        String lastAction = undo.pop();
        redo.push(lastAction);
    }

    public void redo() {
        if (redo.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }
        String lastUndone = redo.pop();
        undo.push(lastUndone);
    }

    // NEW: Method to see the actual text!
    public String read() {
        // Efficiently joins all strings in the stack
        return String.join("", undo);
    }

    public static void main(String[] args) {
        Editor editor = new Editor();

        editor.write("Hello");
        editor.write(" World");
        editor.write(" from Java");
        System.out.println("Current: " + editor.read());

        editor.undo();
        System.out.println("Undone:  " + editor.read());

        editor.undo();
        System.out.println("Undone:  " + editor.read());

        editor.redo();
        System.out.println("Redone:  " + editor.read());

        editor.write(" Python");
        System.out.println("New Write: " + editor.read()); // Hello World Python

        // This should do nothing because we wrote new text
        editor.redo();
    }
}