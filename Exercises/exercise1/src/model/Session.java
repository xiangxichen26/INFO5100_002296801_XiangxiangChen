package model;
import java.util.ArrayList;
import java.util.Collections;

public class Session {
    ArrayList<Student> students = new ArrayList<>();

    public Student getStudent(int index) {
        return students.get(index);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double getAverageScore() {
        double sum = 0;
        for (Student student : students) {
            sum += student.getAverageScore();
        }
        return sum / students.size();
    }

    public void printQuizScoresAscending() {
        for (Student student : students) {
            ArrayList<Integer> sortedScores = new ArrayList<>(student.quizScores);
            Collections.sort(sortedScores);
            System.out.println(student.name + "'s Quiz Scores in Ascending Order: " + sortedScores);
        }
    }

    public void printPartTimeStudents() {
        for (Student student : students) {
            if (student instanceof PartTime) {
                System.out.println(student.name);
            }
        }
    }

    public void printFullTimeStudentsScore() {
        for (Student student : students) {
            if (student instanceof FullTime) {
                System.out.println(student.name + "'s Exam Scores:");
                ((FullTime) student).printExamScore();
            }
        }
    }


}
