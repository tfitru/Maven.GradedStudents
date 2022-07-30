package io.zipcoder;

import com.sun.security.auth.NTNumericCredential;

import java.util.*;


public class Classroom {

    private ArrayList<Student> students;
    private int maxNumberOfStudents;

    Student student = new Student();



    // Nullary constructor --
    public Classroom() {
        this(30);
    }


    public Classroom(int maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = new ArrayList<>();

    }


    public Classroom(ArrayList<Student> student){
        this.students = student;
    }





    public ArrayList<Student> getStudents(){
        return this.students;
    }


    public Double getAverageExamScore() {
        double sum = 0.0;
        for(int i =0; i<students.size(); i++) {
            sum += students.get(i).getAverageExamScore();
        }

        return sum/students.size();
    }


    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(String firstName, String lastName) {
        for(int i = 0; i<this.students.size(); i++){
            if(this.students.get(i).getFirstName().equals(firstName) && this.students.get(i).getLastName().equals(lastName)){
                this.students.remove(this.students.get(i));
            }
            this.students.sort(Comparator.comparing(Student::getFirstName).thenComparing(Student::getFirstName));
        }
    }

    public Student[] getStudentsbyScore() {
        this.students.sort(Comparator.comparing(Student::getExamScores).thenComparing(Student::getExamScores).reversed());
        for(int i = 0; i<this.students.size(); i++) {
            this.students.sort(Comparator.comparing(Student::getFirstName).thenComparing(Student::getFirstName));
        }
        return this.students.toArray(new Student[0]);
        }

    public Map<Student, String> getGradeBook() {
        int sum = 0;
        double max = students.get(0).getAverageExamScore();
        for(int i = 0; i<students.size(); i++){
            if(students.get(i).getAverageExamScore()>max){
                max = students.get(i).getAverageExamScore();
            }
            sum += students.get(i).getAverageExamScore();
        }
        double average = sum/students.size();
        int averageGrade = (int) ((int) max - average );
        Map<Student, String> gradeBook = new HashMap<>();
        for(int i = 0; i<students.size(); i++) {
            if(students.get(i).getAverageExamScore() == average && students.get(i).getAverageExamScore()>0){
                gradeBook.put(students.get(i), "C");
            }  else if (students.get(i).getAverageExamScore() >= average + averageGrade - 5) {
                gradeBook.put(students.get(i), "A");
             }else if (students.get(i).getAverageExamScore() >= average + averageGrade - 6 && students.get(i).getAverageExamScore() <= average + averageGrade - 10){
                gradeBook.put(students.get(i), "B");
            } else if (students.get(i).getAverageExamScore() >= average - averageGrade - 8 && students.get(i).getAverageExamScore() <= average - averageGrade + 5 ){
                gradeBook.put(students.get(i), "D");
            } else if (students.get(i).getAverageExamScore() <= average - averageGrade - 8 ){
                gradeBook.put(students.get(i), "F");
            }
        }

        return gradeBook;
    }
}




