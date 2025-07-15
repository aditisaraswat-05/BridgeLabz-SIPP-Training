package Workshop;

import java.util.LinkedList;
import java.util.Scanner;

// Notification base class
abstract class Notification {
    String content;
    long time;

    Notification(String content) {
        this.content = content;
        this.time = System.currentTimeMillis();
    }

    abstract void show(); // every child class override this accordingly
}

// class for Like Notification
class LikeNotif extends Notification {
    String user;

    LikeNotif(String user) {
        super(user + " ne aapki post ko like kiya");
        this.user = user;
    }

    @Override
    void show() {
        System.out.println(user + " ne aapki post ko like kiya");
    }
}

// class for comment notification
class CommentNotif extends Notification {
    String user;
    String comment;

    CommentNotif(String user, String comment) {
        super(user + " ne comment kiya: " + comment);
        this.user = user;
        this.comment = comment;
    }

    @Override
    void show() {
        System.out.println(user + " ne comment kiya: " + comment);
    }
}

// User ka notification feed, yahan sab notification store honge
class Feed {
    private LinkedList<Notification> notifList;

    Feed() {
        notifList = new LinkedList<>();
    }

    // for adding neww notification
    void add(Notification n) {
        notifList.addFirst(n); // sabse nayi upar rahe
    }

    // Show all notifiacation
    void showAll() {
        if (notifList.isEmpty()) {
            System.out.println("Koi notification nahi hai.");
        } else {
            System.out.println("Aapki Notifications:");
            for (Notification n : notifList) {
                n.show();
            }
        }
    }
}

public class SocialMediaNotificationFeed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Feed myFeed = new Feed();

        System.out.println("Kitni notifications daalni hai?");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("1. Like Notification\n2. Comment Notification");
            System.out.print("Kya add karna chahte ho (1 ya 2)? ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("User ka naam jisne like kiya: ");
                String user = sc.nextLine();
                myFeed.add(new LikeNotif(user));
            } else if (choice == 2) {
                System.out.print("User ka naam jisne comment kiya: ");
                String user = sc.nextLine();
                System.out.print("Comment kya tha? ");
                String comment = sc.nextLine();
                myFeed.add(new CommentNotif(user, comment));
            } else {
                System.out.println("Galat choice!");
            }
        }

        System.out.println();
        myFeed.showAll();
        sc.close();
    }
}

// Social Media Notification Feed
// UseCase: Store the display recent notification for a user in reverse
// chronological order (most recent first)

// Why LinkedList? Fast insert at the beginning and sequential travaseral
// OPPS Concepts:
// Encapsulation: User feed is managed privately
// Abstraction-API style access to addNotification() and DisplayFeed().
// Inheritance/Polymorphism- Different type of notifications (likeNotification,
// CommentNotification) can be handled generically