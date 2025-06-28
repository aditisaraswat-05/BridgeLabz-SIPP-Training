package Workshop;

import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        int vote1 = 0, vote2 = 0, vote3 = 0;

        while (true) {
            System.out.print("Enter the age of voter");
            int age = sc.nextInt();
            if (age < 18) {
                System.out.println("Not Eligible for voting");
                continue;
            } else if (age == -1) {
                System.out.println("Voting session ended");
                break;
            } else {
                System.out.println("Eligible to vote!");
                System.out.println("Enter your vote(1,2 or 3 for candidates):");
            }
            int vote = sc.nextInt();

            switch (vote) {
                case 1:
                    vote1++;
                    break;

                case 2:
                    vote2++;
                    break;

                case 3:
                    vote3++;
                    break;

                default:
                    System.out.println("Invalid vote! Vote not counted");
            }
            System.out.println("Vote count:");
            System.out.println("Candidate 1:" + vote1);
            System.out.println("Candidate 2:" + vote2);
            System.out.println("candidate 3:" + vote3);

            sc.close();
        }

    }
}

// Design a polling booth system
// - Take Age input
// - use if to check if eligible (>=18)
// - Record vote(1,2 or 3 for candidates)
// - Loop for multiple voters, exit on special code.
