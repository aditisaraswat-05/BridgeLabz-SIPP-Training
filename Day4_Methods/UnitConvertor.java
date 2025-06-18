package Day4_Methods;

public class UnitConvertor {

    // Conversion constants
    private static final double YARDS_TO_FEET = 3.0;
    private static final double FEET_TO_YARDS = 0.333333;
    private static final double METERS_TO_INCHES = 39.3701;
    private static final double INCHES_TO_METERS = 0.0254;
    private static final double INCHES_TO_CM = 2.54;

    // Method to convert yards to feet
    public static double convertYardsToFeet(double yards) {
        return yards * YARDS_TO_FEET;
    }

    // Method to convert feet to yards
    public static double convertFeetToYards(double feet) {
        return feet * FEET_TO_YARDS;
    }

    // Method to convert meters to inches
    public static double convertMetersToInches(double meters) {
        return meters * METERS_TO_INCHES;
    }

    // Method to convert inches to meters
    public static double convertInchesToMeters(double inches) {
        return inches * INCHES_TO_METERS;
    }

    // Method to convert inches to centimeters
    public static double convertInchesToCentimeters(double inches) {
        return inches * INCHES_TO_CM;
    }

    // Main method for quick testing (optional)
    public static void main(String[] args) {
        System.out.println("10 yards in feet: " + convertYardsToFeet(10));
        System.out.println("30 feet in yards: " + convertFeetToYards(30));
        System.out.println("2 meters in inches: " + convertMetersToInches(2));
        System.out.println("50 inches in meters: " + convertInchesToMeters(50));
        System.out.println("25 inches in centimeters: " + convertInchesToCentimeters(25));
    }
}

// CP - Extend or create a UnitConvertor utility class similar to the one shown
// in the notes to do the following. Please define static methods for all the
// UnitConvertor class methods.
// E.g. public static double convertYardsToFeet(double yards)
// Hint =>
// 1. Method to convert yards to feet and return the value. Use the following
// code to convert
// double yards2feet = 3;
// 2. Method to convert feet to yards and return the value. Use the following
// code to convert
// double feet2yards = 0.333333;
// 3. Method to convert meters to inches and returns the value. Use the
// following code to convert
// double meters2inches = 39.3701;
// 4. Method to convert inches to meters and return the value. Use the following
// code to convert
// double inches2meters = 0.0254;
// 5. Method to convert inches to centimeters and return the value. Use the
// following code
// double inches2cm = 2.54;
