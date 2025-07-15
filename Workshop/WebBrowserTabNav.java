package Workshop;

import java.util.Stack;

interface TabNavigator {
    void openTab(String url); // method for opening new tab

    void back();

    void forward();

    void currentTab();
}

class BrowserHistory implements TabNavigator {
    private Stack<String> backHistory = new Stack<>();
    private Stack<String> forwardHistory = new Stack<>();
    private String activeTab = null;

    @Override
    public void openTab(String url) {
        if (activeTab != null) {
            backHistory.push(activeTab);
        }
        activeTab = url;
        forwardHistory.clear(); // Clear forward when a new tab is opened
        System.out.println("Now browsing: " + activeTab);
    }

    @Override
    public void back() {
        if (!backHistory.isEmpty()) {
            forwardHistory.push(activeTab);
            activeTab = backHistory.pop();
            System.out.println("Moved back to: " + activeTab);
        } else {
            System.out.println("No more tabs in back history.");
        }
    }

    @Override
    public void forward() {
        if (!forwardHistory.isEmpty()) {
            backHistory.push(activeTab);
            activeTab = forwardHistory.pop();
            System.out.println("Moved forward to: " + activeTab);
        } else {
            System.out.println("No tabs in forward history.");
        }
    }

    @Override
    public void currentTab() {
        if (activeTab != null) {
            System.out.println("Currently on: " + activeTab);
        } else {
            System.out.println("No tab is open currently.");
        }
    }
}

public class WebBrowserTabNav {
    public static void main(String[] args) {
        TabNavigator myBrowser = new BrowserHistory();

        myBrowser.openTab("https://news.com");
        myBrowser.openTab("https://youtube.com");
        myBrowser.openTab("https://stackoverflow.com");

        myBrowser.back();
        myBrowser.back();
        myBrowser.forward();
        myBrowser.currentTab();
    }
}

// Web Browser Tab Navigation(Back/Forward Tabs)
// Use Case: Users can navigate back and forward between opened tabs
// OOPS Concepts:
// Interface:NavigationManager
// Encapsulation: Two stacks handle navigation state
// polymorphism: Could extend for mobile vs desktop browser