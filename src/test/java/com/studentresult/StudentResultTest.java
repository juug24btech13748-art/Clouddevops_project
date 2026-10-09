package com.studentresult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for StudentResult class using JUnit 5 Jupiter.
 */
class StudentResultTest {

    @Test
    @DisplayName("Should correctly calculate total marks for valid inputs")
    void testCalculateTotal() {
        double[] marks = {85.0, 90.0, 75.0, 80.0};
        StudentResult studentResult = new StudentResult(marks);
        double expectedTotal = 330.0;
        assertEquals(expectedTotal, studentResult.calculateTotal(), 0.001, "Total marks calculation is incorrect.");
    }

    @Test
    @DisplayName("Should correctly calculate average marks for valid inputs")
    void testCalculateAverage() {
        double[] marks = {80.0, 70.0, 90.0, 84.0};
        StudentResult studentResult = new StudentResult(marks);
        double expectedAverage = 81.0;
        assertEquals(expectedAverage, studentResult.calculateAverage(), 0.001, "Average calculation is incorrect.");
    }

    @Test
    @DisplayName("Should correctly assign grades according to grade scale rules")
    void testCalculateGrade() {
        // Grade A: >= 90
        assertEquals("A", new StudentResult(new double[]{95.0, 90.0, 92.0}).calculateGrade());

        // Grade B: >= 75 and < 90
        assertEquals("B", new StudentResult(new double[]{80.0, 78.0, 75.0}).calculateGrade());

        // Grade C: >= 60 and < 75
        assertEquals("C", new StudentResult(new double[]{65.0, 60.0, 70.0}).calculateGrade());

        // Grade D: >= 40 and < 60
        assertEquals("D", new StudentResult(new double[]{45.0, 40.0, 50.0}).calculateGrade());

        // Grade F: < 40
        assertEquals("F", new StudentResult(new double[]{30.0, 35.0, 25.0}).calculateGrade());
    }

    @Test
    @DisplayName("Should return true when student has passed all subjects with marks >= 35")
    void testHasPassed_Success() {
        double[] marks = {35.0, 50.0, 85.0, 90.0};
        StudentResult studentResult = new StudentResult(marks);
        assertTrue(studentResult.hasPassed(), "Student should pass when all subject marks are >= 35.");
    }

    @Test
    @DisplayName("Should return false when student has any subject mark below 35, even if average is high")
    void testHasPassed_FailureDueToSubjectFailure() {
        // High average (78.75), but third subject is 30 (< 35)
        double[] marks = {95.0, 100.0, 30.0, 90.0};
        StudentResult studentResult = new StudentResult(marks);
        assertFalse(studentResult.hasPassed(), "Student should fail if any subject mark is below 35.");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when input marks array is empty")
    void testInvalidInput_EmptyArray() {
        double[] emptyMarks = {};
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new StudentResult(emptyMarks),
                "Should throw IllegalArgumentException for empty marks array."
        );
        assertTrue(exception.getMessage().contains("At least one subject mark must be provided"));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when input marks array is null")
    void testInvalidInput_NullArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new StudentResult(null),
                "Should throw IllegalArgumentException for null marks array."
        );
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when any mark is out of valid range [0, 100]")
    void testInvalidInput_MarkOutOfRange() {
        // Negative mark
        assertThrows(
                IllegalArgumentException.class,
                () -> new StudentResult(new double[]{80.0, -10.0, 90.0}),
                "Should throw IllegalArgumentException for negative mark."
        );

        // Mark greater than 100
        assertThrows(
                IllegalArgumentException.class,
                () -> new StudentResult(new double[]{80.0, 105.0, 90.0}),
                "Should throw IllegalArgumentException for mark > 100."
        );
    }
}
