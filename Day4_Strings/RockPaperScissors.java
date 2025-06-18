package Day4_Strings;

import java.util.Scanner;

public class RockPaperScissors {

    // 2. Generate computer choice: 0 - rock, 1 - paper, 2 - scissors
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);
        return switch (choice) {
            case 0 -> "rock";
            case 1 -> "paper";
            case 2 -> "scissors";
            default -> "rock";
        };
    }

    // 3. Determine winner
    public static String getWinner(String user, String computer) {
        if (user.equals(computer))
            return "Draw";

        return switch (user) {
            case "rock" -> (computer.equals("scissors") ? "User" : "Computer");
            case "paper" -> (computer.equals("rock") ? "User" : "Computer");
            case "scissors" -> (computer.equals("paper") ? "User" : "Computer");
            default -> "Invalid";
        };
    }

    // 4. Calculate and return win stats in 2D array
    public static String[][] getStats(int userWins, int compWins, int totalGames) {
        double userPercent = ((double) userWins / totalGames) * 100;
        double compPercent = ((double) compWins / totalGames) * 100;

        return new String[][] {
                { "User Wins", String.valueOf(userWins), String.format("%.2f%%", userPercent) },
                { "Computer Wins", String.valueOf(compWins), String.format("%.2f%%", compPercent) },
                { "Draws", String.valueOf(totalGames - userWins - compWins), "-" }
        };
    }

    // 5. Display results in tabular format
    public static void displayResults(String[][] rounds, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.println("Round\tUser\tComputer\tWinner");
        System.out.println("----------------------------------------");

        for (int i = 0; i < rounds.length; i++) {
            System.out.printf("%d\t%s\t%s\t\t%s\n", i + 1, rounds[i][0], rounds[i][1], rounds[i][2]);
        }

        System.out.println("\nOverall Stats:");
        System.out.println("Player\t\tWins\tPercentage");
        System.out.println("----------------------------------");
        for (String[] stat : stats) {
            System.out.printf("%-10s\t%s\t%s\n", stat[0], stat[1], stat[2]);
        }
    }

    // 6. Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rounds to play: ");
        int rounds = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[][] gameResults = new String[rounds][3];
        int userWins = 0, compWins = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.print("\nRound " + (i + 1) + " - Enter your choice (rock, paper, scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();

            String compChoice = getComputerChoice();
            String winner = getWinner(userChoice, compChoice);

            gameResults[i][0] = userChoice;
            gameResults[i][1] = compChoice;
            gameResults[i][2] = winner;

            if (winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                compWins++;
        }

        String[][] stats = getStats(userWins, compWins, rounds);
        displayResults(gameResults, stats);

        scanner.close();
    }
}

// CP - Rock-Paper-Scissors is a game played between a minimum of two players.
// Each player can choose either rock, paper, or scissors. Here, the game is
// played between a user and a computer. Based on the rules, either a player or
// a computer will win. Show the stats of player and computer win in a tabular
// format
// across multiple games. Also, shows the winning percentage between the player
// and the computer.
// Hint =>
// 1. The rule is: rock-scissors: rock will win (rock crushes scissors);
// rock-paper: paper wins (paper covers rock); scissors-paper: scissors win
// (scissors cut
// paper)
// 2. Create a Method to find the Computer Choice using the Math.random()
// 3. Create a Method to find the winner between the user and the computer
// 4. Create a Method to find the average and percentage of wins for the user
// and the computer and return a String 2D array
// 5. Create a Method to display the results of every game and also display the
// average and percentage wins
// 6. In the main take, user input for the number of games and call methods to
// display results