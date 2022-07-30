package io.zipcoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Student {
     private String firstName;
     private String lastName;
     private ArrayList<Double> examScores;

     double examScore;
     private int counter;

     public Student() {
           this.firstName = "";
           this.lastName = "";
           this.examScores = new ArrayList<>();

     }

    public  Student (String firstName, String lastName, ArrayList<Double> testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = testScores;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;

    }



    public String getLastName() {
        return lastName;
    }


//    public  int getNumberOfExamsTaken( ) {
//        return examScores.length;
//    }


    public void addExamScore(double examScore){
            this.examScores.add(examScore);

    }

    public String getExamScores() {
            String temp = "";
            String examScoresH = " ";
            int counter = 0;
            System.out.println(examScoresH);
            for(int i = 0; i<=examScores.size()-1; i++){
                counter+=1;
                temp += "\nExam " +  counter + " -> " + examScores.get(i);
                }
            return temp;
    }










    public void setExamScores(int examNumber, double newScore){
        for(int i = 0; i<examScores.size(); i++) {
            examNumber = i;
            this.examScores.set(examNumber, newScore);
        }
    }


    public Double getAverageExamScore(){
        double sum = 0.0;
        for(int i = 0; i<this.examScores.size(); i++) {
            sum += this.examScores.get(i);
        }
        return sum/this.examScores.size();


    }





    @Override
    public String toString() {
        return "\nStudent Name: " + firstName + lastName +
                "\n> Average Score: "  + getAverageExamScore() +
                "\n> Exam Scores:"  + getExamScores();

    }

}
