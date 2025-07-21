import java.util.ArrayList;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void display() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int choice) {
        return choice == correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Question> quiz = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Quiz App Menu =====");
            System.out.println("1. Add Questions");
            System.out.println("2. Start Quiz");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int menuChoice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (menuChoice) {
                case 1:
                    System.out.print("How many questions do you want to add? ");
                    int n = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    for (int i = 0; i < n; i++) {
                        System.out.println("\nEnter question " + (i + 1) + ":");
                        System.out.print("Question: ");
                        String qText = sc.nextLine();

                        String[] options = new String[4];
                        for (int j = 0; j < 4; j++) {
                            System.out.print("Option " + (j + 1) + ": ");
                            options[j] = sc.nextLine();
                        }

                        System.out.print("Enter correct option number (1-4): ");
                        int correct = sc.nextInt();
                        sc.nextLine(); // clear buffer

                        quiz.add(new Question(qText, options, correct));
                        System.out.println("✅ Question added successfully!");
                    }
                    break;

                case 2:
                    if (quiz.isEmpty()) {
                        System.out.println("⚠️ No questions available. Please add questions first.");
                    } else {
                        int score = 0;
                        for (int i = 0; i < quiz.size(); i++) {
                            Question q = quiz.get(i);
                            q.display();
                            System.out.print("Your answer (1-4): ");
                            int userAnswer = sc.nextInt();

                            if (q.isCorrect(userAnswer)) {
                                System.out.println("✅ Correct!");
                                score++;
                            } else {
                                System.out.println("❌ Incorrect! Correct answer was option " + q.correctOption);
                            }
                        }
                        System.out.println("\n🎯 You scored " + score + " out of " + quiz.size());
                    }
                    break;

                case 3:
                    System.out.println("👋 Exiting Quiz App. Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("⚠️ Invalid option. Try again.");
            }
        }
    }
}
