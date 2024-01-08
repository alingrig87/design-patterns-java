package com.design.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Iterator Interface
interface HistoryIterator {
    boolean hasNext();
    boolean hasPrevious();
    String next();
    String previous();
}

// Concrete Iterator Class for Browser History
class BrowserHistoryIterator implements HistoryIterator {
    private List<String> history;
    private int currentIndex;

    public BrowserHistoryIterator(List<String> history) {
        this.history = history;
        this.currentIndex = history.size() - 1; // Start from the most recent page
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex < history.size() - 1;
    }

    @Override
    public String next() {
        if (hasNext()) {
            String page = history.get(currentIndex);
            currentIndex--;
            return page;
        } else {
            return null;
        }
    }

    @Override
    public String previous() {
        if (hasPrevious()) {
            currentIndex++;
            return history.get(currentIndex);
        } else {
            return null;
        }
    }
}

// Concrete Aggregate Class for Browser History
class BrowserHistory {
    private List<String> history;

    public BrowserHistory() {
        this.history = new ArrayList<>();
    }

    // Add a page to the history
    public void addPage(String page) {
        history.add(page);
    }

    // Get an Iterator for the history
    public HistoryIterator getIterator() {
        return new BrowserHistoryIterator(history);
    }
}

// Example of Usage
class BrowserExample {
    public static void main(String[] args) {
        // Creating an object for browser history
        BrowserHistory browserHistory = new BrowserHistory();

        // Adding pages to the history
        browserHistory.addPage("www.google.com");
        browserHistory.addPage("www.example.com");
        browserHistory.addPage("www.openai.com");

        // Getting an Iterator for the history
        HistoryIterator iterator = browserHistory.getIterator();

        // Iterating through the history using the Iterator
        while (iterator.hasNext()) {
            String page = iterator.next();
            System.out.println("Visited page: " + page);
        }

        System.out.println("\nGoing back in history:\n");

        // Iterating backward through the history using the Iterator
        while (iterator.hasPrevious()) {
            String page = iterator.previous();
            System.out.println("Visited page: " + page);
        }
    }
}
