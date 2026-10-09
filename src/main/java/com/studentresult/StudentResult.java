package com.studentresult;

/**
 * StudentResult represents a Student Result Management System.
 * It provides core functionality for validating student subject marks,
 * calculating total marks, computing average score, assigning grades,
 * and checking pass/fail qualification.
 *
 * Designed for B.Tech CSE Unit III Cloud DevOps CI Pipeline Assignment.
 */
public class StudentResult {

    private final double[] marks;

    /**
     * Constructor initializing the student result system with an array of subject marks.
     *
     * @param marks Array of marks obtained in individual subjects.
     * @throws IllegalArgumentException if marks is null, empty, or contains invalid scores.
     */
    public StudentResult(double[] marks) {
        validateMarks(marks);
        this.marks = marks.clone();
    }

    /**
     * Validates that the marks array is non-null, non-empty, and each mark is between 0 and 100.
     *
     * @param marks Array of subject marks to validate.
     * @throws IllegalArgumentException if validation fails.
     */
    public static void validateMarks(double[] marks) {
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("Invalid input: At least one subject mark must be provided.");
        }
        for (double mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new IllegalArgumentException("Invalid mark: " + mark + ". Marks must be between 0 and 100 inclusive.");
            }
        }
    }

    /**
     * Calculates total marks obtained across all subjects.
     *
     * @return Sum of all subject marks.
     */
    public double calculateTotal() {
        return calculateTotal(this.marks);
    }

    /**
     * Static helper to calculate total marks for a given marks array.
     *
     * @param marks Array of subject marks.
     * @return Sum of all subject marks.
     */
    public static double calculateTotal(double[] marks) {
        validateMarks(marks);
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    /**
     * Calculates the average marks obtained.
     *
     * @return Average score across all subjects.
     */
    public double calculateAverage() {
        return calculateAverage(this.marks);
    }

    /**
     * Static helper to calculate average marks for a given marks array.
     *
     * @param marks Array of subject marks.
     * @return Average score.
     */
    public static double calculateAverage(double[] marks) {
        validateMarks(marks);
        return calculateTotal(marks) / marks.length;
    }

    /**
     * Calculates and assigns the letter grade based on the calculated average score.
     *
     * @return Grade string ("A", "B", "C", "D", or "F").
     */
    public String calculateGrade() {
        return calculateGrade(calculateAverage());
    }

    /**
     * Assigns a letter grade based on average score using the grade criteria:
     * <ul>
     *   <li>Average >= 90: Grade A</li>
     *   <li>Average >= 75: Grade B</li>
     *   <li>Average >= 60: Grade C</li>
     *   <li>Average >= 40: Grade D</li>
     *   <li>Average &lt; 40: Grade F</li>
     * </ul>
     *
     * @param average Average score.
     * @return Grade string.
     * @throws IllegalArgumentException if average score is outside [0, 100].
     */
    public static String calculateGrade(double average) {
        if (average < 0 || average > 100) {
            throw new IllegalArgumentException("Invalid average score: " + average + ". Average must be between 0 and 100.");
        }
        if (average >= 90) {
            return "A";
        } else if (average >= 75) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Determines whether the student passed all subjects.
     * A student passes only if every individual subject mark is at least 35.
     *
     * @return true if every subject mark >= 35, false otherwise.
     */
    public boolean hasPassed() {
        return hasPassed(this.marks);
    }

    /**
     * Static helper to determine pass/fail status.
     *
     * @param marks Array of subject marks.
     * @return true if every subject mark >= 35, false otherwise.
     */
    public static boolean hasPassed(double[] marks) {
        validateMarks(marks);
        for (double mark : marks) {
            if (mark < 35) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a copy of the subject marks array.
     *
     * @return Array of marks.
     */
    public double[] getMarks() {
        return this.marks.clone();
    }
}
