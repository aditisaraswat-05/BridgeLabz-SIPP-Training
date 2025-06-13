package Day2;

public class q1 {
    public static void main(String[] args) {
        int totalPens = 14;
        int totalStudents = 3;

        int pensPerStudent = totalPens / totalStudents; // Division
        int remainingPens = totalPens % totalStudents; // Modulus

        System.out.println("The Pen Per Student is " + pensPerStudent + " and the remaining pen not distributed is "
                + remainingPens);
    }
}

// CP - Suppose you have to divide 14 pens among 3 students equally. Write a
// program to find how many
// pens each student will get if the pens must be divided equally. Also, find
// the remaining non-distributed
// pens.
// Hint =>
// Use Modulus Operator (%) to find the reminder.
// Use Division Operator to find the Quantity of pens
// I/P => NONE
// O/P => The Pen Per Student is ___ and the remaining pen not distributed is __