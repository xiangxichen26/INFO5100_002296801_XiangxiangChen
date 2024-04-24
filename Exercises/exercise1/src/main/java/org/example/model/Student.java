package org.example.model;

import java.util.ArrayList;
public class Student {
    String name;
    ArrayList<Integer> quizScores = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addQuizScore(int score) {
        quizScores.add(score);
    }

    public double getAverageScore() {
        double sum = 0;
        for (int score : quizScores) {
            sum += score;
        }
        return sum / quizScores.size();
    }

}