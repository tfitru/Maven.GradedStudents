package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    @Test
    public void getExamScoresTest() {
        //Given
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 95.0, 123.0, 96.0));
        Student student = new Student(firstName, lastName, examScores);
        String examScoresExpected = "\nExam 1 -> 100.0\nExam 2 -> 95.0\nExam 3 -> 123.0\nExam 4 -> 96.0";

        // When
        String output = student.getExamScores();


        //Then
        Assert.assertEquals(examScoresExpected, output);
    }

    @Test
    public void addExamScoreTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<>(0);
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.addExamScore(100.0);
        Double expectedExamScores = 100.0;
        String output = student.getExamScores();

        // Then
        System.out.println(output);
        System.out.println(expectedExamScores);


    }

    @Test
    public void setExamScore() {
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0));
        Student student = new Student(firstName, lastName, examScores);


        // When
        student.setExamScores(1, 150);
        String output = student.getExamScores();

        // Then
        System.out.println(output);



    }

    @Test
    public void getAverageExamScoreTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 0.0));
        Student student = new Student(firstName, lastName, examScores);

        // When
        Double output = student.getAverageExamScore();


        // Then
        System.out.println(output);


    }

    @Test
    public void toStringTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 0.0));
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.toString();


        // Then
        System.out.println(output);



    }

}