package stack.sprints.one;

import java.util.Stack;

public class Browser {

    private Stack<String> history;
    private Stack<String> forward;

    public Browser() {
        history = new Stack<>();
        forward = new Stack<>();
    }

    public String visit(String url) {
        history.push(url);
        forward.clear();
        return url;
    }

    public String back() {
        if (history.size() < 2) {
            System.out.println("Cannot go back further.");
            return history.peek(); // Stay on current page
        }

        String currentTab = history.pop();
        forward.push(currentTab);

        return history.peek(); // Return the previous page
    }

    public String forward() {
        if (forward.isEmpty()) {
            System.out.println("Cannot go forward.");
            return history.peek();
        }

        String targetTab = forward.pop();
        history.push(targetTab);

        return targetTab;
    }

    // Helper to see state
    public void printStatus() {
        System.out.println("Current Page: " + (history.isEmpty() ? "None" : history.peek()));
        System.out.println("Back Stack: " + history);
        System.out.println("Fwd Stack:  " + forward);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");
        browser.printStatus();

        System.out.println("Go Back: " + browser.back()); // Expect facebook
        System.out.println("Go Back: " + browser.back()); // Expect google
        browser.printStatus();

        System.out.println("Go Fwd:  " + browser.forward()); // Expect facebook
        browser.printStatus();

        System.out.println("Visit New: " + browser.visit("linkedin.com")); // Clears youtube from forward
        browser.printStatus();
    }
}