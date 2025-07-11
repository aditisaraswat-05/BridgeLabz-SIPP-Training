package LinkedList_DSA;

import java.util.*;

class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add new state to history
    public void addState(String newText) {
        TextState newState = new TextState(newText);

        // If we’re in the middle (after undo), cut the redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        if (head == null) {
            head = newState;
        } else {
            current.next = newState;
            newState.prev = current;
        }

        current = newState;
        size++;

        // Maintain max history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo: move to previous state
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // Redo: move to next state
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    // Display current state
    public void showCurrentState() {
        if (current != null) {
            System.out.println("Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("No content.");
        }
    }

    // For debugging
    public void printHistory() {
        TextState temp = head;
        System.out.println("\nText History (oldest to newest):");
        while (temp != null) {
            System.out.println("-> " + temp.content);
            temp = temp.next;
        }
    }
}

public class Editor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n1. Type Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current State");
            System.out.println("5. Show Full History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.showCurrentState();
                    break;
                case 5:
                    editor.printHistory();
                    break;
                case 6:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

// 8. Doubly Linked List: Undo/Redo Functionality for Text Editor
// Problem Statement: Design an undo/redo functionality for a text editor using
// a doubly linked list. Each node represents a state of the text content (e.g.,
// after typing a word or performing a command). Implement the following:
// Add a new text state at the end of the list every time the user types or
// performs an action.
// Implement the undo functionality (revert to the previous state).
// Implement the redo functionality (revert back to the next state after undo).
// Display the current state of the text.
// Limit the undo/redo history to a fixed size (e.g., last 10 states).
// Hint:
// Use a doubly linked list where each node represents a state of the text.
// The next pointer will represent the forward history (redo), and the prev
// pointer will represent the backward history (undo).
// Keep track of the current state and adjust the next and prev pointers for
// undo/redo operations.
