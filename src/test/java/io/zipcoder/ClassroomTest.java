package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClassroomTest {

    @Test
    public void getAverageExamScoresTest() {
        // Given
        ArrayList<Double> s1Scores = new ArrayList<>(Arrays.asList(100.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(225.0, 25.0));

        Student s1 = new Student ("student", "one", s1Scores);
        Student s2 = new Student ("student", "two", s2Scores);

        ArrayList<Student> students = new ArrayList<>(Arrays.asList(s1, s2));
        Classroom classroom = new Classroom(students);


        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void addStudentTest() {
        // Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 0.0));
        Student student = new Student ("Leon", "Hunter", examScores);

        // When
        ArrayList<Student> preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        ArrayList<Student> postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = preEnrollment.toString();
        String postEnrollmentAsString = postEnrollment.toString();

        System.out.println("=============================");
        System.out.println(postEnrollmentAsString);
        System.out.println("=============================");
        System.out.println(preEnrollmentAsString);


    }

    @Test
    public void removeStudent(){
        // Given
        int maxNumberOfStudents = 3;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 0.0));
        ArrayList<Double> examScores1 = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 50.0));
        Student student = new Student("Leon ", "Hunter", examScores);
        Student student1 = new Student("Mark ", "Jackson", examScores1);
        Student student2 = new Student("Frank ", "Robert", examScores1);


        // When
        ArrayList<Student> preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        ArrayList<Student> postEnrollment = classroom.getStudents();
        String preEnrollmentAsString = preEnrollment.toString();

        classroom.removeStudent(student.getFirstName(), student.getLastName());



        // Then
        String postEnrollmentAsString = postEnrollment.toString();


        // Then
        System.out.println(preEnrollmentAsString);
        System.out.println("=====================");
        System.out.println(postEnrollmentAsString);



    }


    @Test
    public void orderByScoreTest(){
        // Given
        int maxNumberOfStudents = 3;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 0.0));
        ArrayList<Double> examScores1 = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 50.0));
        Student student = new Student("Leon ", "Hunter", examScores);
        Student student1 = new Student("Mark ", "Jackson", examScores1);
        Student student2 = new Student("Frank ", "Robert", examScores1);


        // When
        ArrayList<Student> preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        classroom.addStudent(student1);
        classroom.addStudent(student2);

        Student[] result = classroom.getStudentsbyScore();



        // Then


        // Then
        System.out.println(Arrays.toString(result));



    }


    @Test
    public void getGradeBookTest(){
        // Given
        int maxNumberOfStudents = 3;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 200.0));
        ArrayList<Double> examScores1 = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 200.0));
        ArrayList<Double> examScores2 = new ArrayList<>(Arrays.asList(100.0, 120.0, 200.0, 150.0));
        Student student = new Student("Leon ", "Hunter", examScores);
        Student student1 = new Student("Mark ", "Jackson", examScores1);
        Student student2 = new Student("Frank ", "Robert", examScores2);
        int expectedSizeList = 3;

        // When
        classroom.addStudent(student);
        classroom.addStudent(student1);
        classroom.addStudent(student2);

        // Then
        Map<Student, String> actual = classroom.getGradeBook();

        // Then
        Assert.assertEquals(actual.size(), expectedSizeList);


    }




    @Test
    public void getGradeBookTest_TwoStudentsWithC(){
        // Given
        int maxNumberOfStudents = 4;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 200.0));
        ArrayList<Double> examScores1 = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 200.0));
        ArrayList<Double> examScores2 = new ArrayList<>(Arrays.asList(100.0, 120.0, 200.0, 290.0));
        ArrayList<Double> examScores3 = new ArrayList<>(Arrays.asList(100.0, 120.0, 200.0, 280.0));
        Student student = new Student("Leon ", "Hunter", examScores);
        Student student1 = new Student("Mark ", "Jackson", examScores1);
        Student student2 = new Student("Frank ", "Robert", examScores2);
        Student student3 = new Student("Jimmy", "Trunk", examScores3);
        Map<Student, String> expectedGrade = new HashMap<>();
        expectedGrade.put(student, "C");
        expectedGrade.put(student1, "C");

        // When
        classroom.addStudent(student);
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        // Then
        Map<Student, String> actual = classroom.getGradeBook();

        // Then
        Assert.assertEquals(actual.get(student), expectedGrade.get(student));
        Assert.assertEquals(actual.get(student1), expectedGrade.get(student1));


    }




    @Test
    public void getGradeBookTest_TwoStudentsWithA(){
        // Given
        int maxNumberOfStudents = 4;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(170.0, 170.0, 180.0, 290.0));
        ArrayList<Double> examScores1 = new ArrayList<>(Arrays.asList(170.0, 170.0, 180.0, 290.0));
        ArrayList<Double> examScores2 = new ArrayList<>(Arrays.asList(170.0, 170.0, 180.0, 300.0));
        ArrayList<Double> examScores3 = new ArrayList<>(Arrays.asList(180.0, 180.0, 180.0, 300.0));
        Student student = new Student("Leon ", "Hunter", examScores);
        Student student1 = new Student("Mark ", "Jackson", examScores1);
        Student student2 = new Student("Frank ", "Robert", examScores2);
        Student student3 = new Student("Jimmy", "Trunk", examScores3);
        Map<Student, String> expectedGrade = new HashMap<>();
        expectedGrade.put(student2, "A");
        expectedGrade.put(student3, "A");

        // When
        classroom.addStudent(student);
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        // Then
        Map<Student, String> actual = classroom.getGradeBook();

        // Then
        Assert.assertEquals(actual.get(student2), expectedGrade.get(student2));
        Assert.assertEquals(actual.get(student3), expectedGrade.get(student3));


    }




}
