package model;
public class FullTime extends Student {
    int examScore1;
    int examScore2;

    public FullTime(String name, int examScore1, int examScore2) {
        super(name);
        this.examScore1 = examScore1;
        this.examScore2 = examScore2;
    }

    public void printExamScore() {
        System.out.println("Exam 1 score: " + examScore1);
        System.out.println("Exam 2 score: " + examScore2);
    }

}
