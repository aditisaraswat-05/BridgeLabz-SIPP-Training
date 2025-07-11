package LinkedList_DSA;

import java.util.*;

class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime = 0;
    int turnAroundTime = 0;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class CircularLinkedList {
    Process head = null;

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    public void removeProcess(Process target) {
        if (head == null)
            return;

        if (head == target && head.next == head) {
            head = null;
            return;
        }

        Process prev = head;
        Process curr = head.next;

        if (head == target) {
            while (prev.next != head)
                prev = prev.next;
            head = head.next;
            prev.next = head;
            return;
        }

        while (curr != head) {
            if (curr == target) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        Process temp = head;
        do {
            System.out.println(
                    "PID: " + temp.pid + " | Remaining: " + temp.remainingTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public void roundRobinSchedule(int timeQuantum) {
        if (head == null)
            return;

        int currentTime = 0;
        int completed = 0;
        List<Process> completedProcesses = new ArrayList<>();
        Process current = head;

        while (!isEmpty()) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                currentTime += execTime;
                current.remainingTime -= execTime;

                // Update waiting time for other processes
                Process temp = current.next;
                while (temp != current) {
                    if (temp.remainingTime > 0)
                        temp.waitingTime += execTime;
                    temp = temp.next;
                }

                if (current.remainingTime == 0) {
                    current.turnAroundTime = currentTime;
                    completedProcesses.add(current);
                    Process toRemove = current;
                    current = current.next;
                    removeProcess(toRemove);
                    System.out.println("\nProcess PID " + toRemove.pid + " completed.");
                } else {
                    current = current.next;
                }

                System.out.println("\nAfter time " + currentTime + ":");
                displayProcesses();
            }
        }

        // Calculate average WT and TAT
        int totalWT = 0, totalTAT = 0;
        for (Process p : completedProcesses) {
            totalWT += p.waitingTime;
            totalTAT += p.turnAroundTime;
        }

        System.out.println("\n--- Summary ---");
        for (Process p : completedProcesses) {
            System.out.println(
                    "PID: " + p.pid + ", Waiting Time: " + p.waitingTime + ", Turnaround Time: " + p.turnAroundTime);
        }
        System.out.println("\nAverage Waiting Time: " + (totalWT / (float) completedProcesses.size()));
        System.out.println("Average Turn-Around Time: " + (totalTAT / (float) completedProcesses.size()));
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        CircularLinkedList scheduler = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process ID, Burst Time, Priority: ");
            int pid = sc.nextInt();
            int bt = sc.nextInt();
            int pri = sc.nextInt();
            scheduler.addProcess(pid, bt, pri);
        }

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        scheduler.roundRobinSchedule(tq);
    }
}

// 6. Circular Linked List: Round Robin Scheduling Algorithm
// Problem Statement: Implement a round-robin CPU scheduling algorithm using a
// circular linked list. Each node will represent a process and contain Process
// ID, Burst Time, and Priority. Implement the following functionalities:
// Add a new process at the end of the circular list.
// Remove a process by Process ID after its execution.
// Simulate the scheduling of processes in a round-robin manner with a fixed
// time quantum.
// Display the list of processes in the circular queue after each round.
// Calculate and display the average waiting time and turn-around time for all
// processes.
// Hint:
// Use a circular linked list to represent a queue of processes.
// Each process executes for a fixed time quantum, and then control moves to the
// next process in the circular list.
// Maintain the current node as the process being executed, and after each
// round, update the list to simulate execution.
