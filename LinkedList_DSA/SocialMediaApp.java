package LinkedList_DSA;

import java.util.*;

class User {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class UserList {
    private User head;

    // Add new user to the list
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newUser;
        }
    }

    // Find user by ID
    public User findUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by Name or ID
    public void searchUser(String key) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(key) || String.valueOf(temp.userID).equals(key)) {
                System.out.println("User Found: " + temp.name + " (ID: " + temp.userID + ", Age: " + temp.age + ")");
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("User not found!");
    }

    // Add a friend connection between two users
    public void addFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 != null && user2 != null) {
            if (!user1.friendIDs.contains(userID2))
                user1.friendIDs.add(userID2);
            if (!user2.friendIDs.contains(userID1))
                user2.friendIDs.add(userID1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove a friend connection
    public void removeFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 != null && user2 != null) {
            user1.friendIDs.remove(Integer.valueOf(userID2));
            user2.friendIDs.remove(Integer.valueOf(userID1));
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        User user = findUserByID(userID);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        System.out.println("Friends of " + user.name + ":");
        for (int friendID : user.friendIDs) {
            User friend = findUserByID(friendID);
            if (friend != null) {
                System.out.println("- " + friend.name + " (ID: " + friend.userID + ")");
            }
        }
    }

    // Find mutual friends between two users
    public void mutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        for (int id : user1.friendIDs) {
            if (user2.friendIDs.contains(id)) {
                User mutual = findUserByID(id);
                System.out.println("- " + mutual.name + " (ID: " + mutual.userID + ")");
            }
        }
    }

    // Count number of friends of each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIDs.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        UserList network = new UserList();

        // Adding sample users
        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 22);
        network.addUser(3, "Charlie", 27);
        network.addUser(4, "David", 24);

        // Connecting friends
        network.addFriend(1, 2);
        network.addFriend(1, 3);
        network.addFriend(2, 3);
        network.addFriend(2, 4);

        System.out.println();
        network.displayFriends(2); // Show Bob's friends

        System.out.println();
        network.mutualFriends(1, 2); // Alice & Bob mutual friends

        System.out.println();
        network.countFriends();

        System.out.println();
        network.searchUser("Charlie");

        System.out.println();
        network.removeFriend(1, 3); // Alice unfriend Charlie
        network.displayFriends(1);
    }
}

// 7. Singly Linked List: Social Media Friend Connections
// Problem Statement: Create a system to manage social media friend connections
// using a singly linked list. Each node represents a user with User ID, Name,
// Age, and List of Friend IDs. Implement the following operations:
// Add a friend connection between two users.
// Remove a friend connection.
// Find mutual friends between two users.
// Display all friends of a specific user.
// Search for a user by Name or User ID.
// Count the number of friends for each user.
// Hint:
// Use a singly linked list where each node contains a list of friends (which
// can be another linked list or array of Friend IDs).
// For mutual friends, traverse both lists and compare the Friend IDs.
// The List of Friend IDs for each user can be implemented as a nested linked
// list or array.
