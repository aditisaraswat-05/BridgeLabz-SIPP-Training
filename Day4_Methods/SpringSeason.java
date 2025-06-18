package Day4_Methods;

public class SpringSeason {

    public static void main(String[] args) {
        // Command-line arguments parsing
        if (args.length < 2) {
            System.out.println("Please provide month and day as command-line arguments.");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check spring season
        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }

    // Method to check if the date falls in Spring Season (March 20 to June 20)
    public static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20) ||
                (month == 4) ||
                (month == 5) ||
                (month == 6 && day <= 20)) {
            return true;
        }
        return false;
    }
}

// CP - Write a program SpringSeason that takes two int values, month and day
// from the command line and prints “It's a Spring Season” otherwise prints “Not
// a
// Spring Season”.
// Hint =>
// 1. Spring Season is from March 20 to June 20.
// 2. Write a Method to check for the Spring season and return a boolean true or
// false