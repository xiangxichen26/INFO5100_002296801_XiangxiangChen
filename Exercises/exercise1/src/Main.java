import java.util.Random;
import model.*;

public class Main {
    public static void main(String[] args) {
        Session session = new Session();

        // Add students to the session
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                session.addStudent(new FullTime("FullTime" + i, 90+i, 80+i));
            } else {
                session.addStudent(new PartTime("PartTime" + i));
            }
            for (int j = 0; j < 15; j++) {
                Random rand = new Random();
                int randomNum = rand.nextInt((100 - 30) + 1) + 30;
                session.getStudent(i).addQuizScore(randomNum);
            }
        }

        // print the average score of all students
        System.out.println("Average score of all students: " + session.getAverageScore());
        System.out.println("----------------------------------------------------------");

        // print the quiz scores of all students in ascending order
        System.out.println("Quiz scores of all students in ascending order:");
        session.printQuizScoresAscending();
        System.out.println("----------------------------------------------------------");

        // print the names of all part-time students
        System.out.println("Part-time students:");
        session.printPartTimeStudents();
        System.out.println("----------------------------------------------------------");

        // print the exam scores of all full-time students
        System.out.println("Full-time students' exam scores:");
        session.printFullTimeStudentsScore();
        System.out.println("----------------------------------------------------------");

    }
}
