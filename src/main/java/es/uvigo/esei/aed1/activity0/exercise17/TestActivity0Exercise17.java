package es.uvigo.esei.aed1.activity0.exercise17;

import static es.uvigo.esei.aed1.activity0.exercise17.Activity0Exercise17.printGrades;
import static es.uvigo.esei.aed1.activity0.exercise17.Activity0Exercise17.readGrades;
import static es.uvigo.esei.aed1.activity0.exercise17.Activity0Exercise17.readNumber;

public class TestActivity0Exercise17 {
    public static void main(String[] args) {
        // Exercise 17
        int numberStudents;
        int numberSubjects;
        numberStudents = readNumber("enter the number of students: ");
        numberSubjects = readNumber("enter the number of subjects: ");
        double[][] grades = new double[numberStudents][numberSubjects];

        readGrades(grades, "reading of grades");

        printGrades(grades, "display of grades");
    }
}
