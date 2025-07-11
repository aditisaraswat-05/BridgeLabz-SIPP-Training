package LinkedList_DSA;

import java.util.Scanner;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    public Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskList {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    // Add at beginning
    public void addAtBeginning(Task newTask) {
        if (head == null) {
            head = tail = current = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add at end
    public void addAtEnd(Task newTask) {
        if (head == null) {
            addAtBeginning(newTask);
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(Task newTask, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newTask);
            return;
        }

        Task temp = head;
        int index = 1;
        while (temp.next != head && index < position - 1) {
            temp = temp.next;
            index++;
        }

        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
        }
    }

    // Remove task by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head, prev = tail;
        boolean found = false;

        do {
            if (temp.id == id) {
                found = true;
                if (temp == head && temp == tail) { // only one node
                    head = tail = current = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }

                if (current == temp) {
                    current = current.next;
                }

                System.out.println("Task removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Task ID not found.");
        }
    }

    // View current task and move to next
    public void viewCurrentAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks to view.");
            return;
        }

        System.out.println("Current Task:");
        System.out.println("ID: " + current.id + ", Name: " + current.name +
                ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
        current = current.next;
    }

    // Display all tasks
    public void displayAll() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        System.out.println("\n--- All Tasks ---");
        Task temp = head;
        do {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println("ID: " + temp.id + ", Name: " + temp.name +
                        ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularTaskList taskList = new CircularTaskList();
        int choice;

        do {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                case 2:
                case 3: {
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date = sc.nextLine();

                    Task newTask = new Task(id, name, priority, date);

                    if (choice == 1)
                        taskList.addAtBeginning(newTask);
                    else if (choice == 2)
                        taskList.addAtEnd(newTask);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        taskList.addAtPosition(newTask, pos);
                    }
                    break;
                }

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    int idToRemove = sc.nextInt();
                    taskList.removeById(idToRemove);
                    break;

                case 5:
                    taskList.viewCurrentAndMoveNext();
                    break;

                case 6:
                    taskList.displayAll();
                    break;

                case 7:
                    System.out.print("Enter Priority to search: ");
                    int priorityToSearch = sc.nextInt();
                    taskList.searchByPriority(priorityToSearch);
                    break;

                case 0:
                    System.out.println("Exiting Task Scheduler...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}

// 3. Circular Linked List: Task Scheduler
// Problem Statement: Create a task scheduler using a circular linked list. Each
// node in the list represents a task with Task ID, Task Name, Priority, and Due
// Date. Implement the following functionalities:
// Add a task at the beginning, end, or at a specific position in the circular
// list.
// Remove a task by Task ID.
// View the current task and move to the next task in the circular list.
// Display all tasks in the list starting from the head node.
// Search for a task by Priority.
// Hint:
// Use a circular linked list where the last node’s next pointer points back to
// the first node, creating a circular structure.
// Ensure that the list loops when traversed from the head node, so tasks can be
// revisited in a circular manner.
// When deleting or adding tasks, maintain the circular nature by updating the
// appropriate next pointers.
