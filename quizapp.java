import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class quizapp {
    static class Question {
        String question;
        String[] options;
        int correctAnswer;

        public Question(String question, String[] options, int correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    private static final Question[] questions = new Question[]{
            new Question("What is the capital of France?", new String[]{"1. Paris", "2. London", "3. Rome", "4. Berlin"}, 1),
            new Question("What is 2 + 2?", new String[]{"1. 3", "2. 4", "3. 5", "4. 6"}, 2),
            new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 2),
            new Question("Who wrote 'Hamlet'?", new String[]{"1. Charles Dickens", "2. J.K. Rowling", "3. William Shakespeare", "4. Mark Twain"}, 3),
    };

    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static Timer timer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (currentQuestionIndex < questions.length) {
            displayQuestion(questions[currentQuestionIndex]);
            boolean answered = getAnswer(scanner);
            if (!answered) {
                System.out.println("Time's up! Moving to the next question...");
            }
            currentQuestionIndex++;
        }

        displayResult();
        scanner.close();
    }

    private static void displayQuestion(Question question) {
        System.out.println("Question " + (currentQuestionIndex + 1) + ": " + question.question);
        for (String option : question.options) {
            System.out.println(option);
        }
    }

    private static boolean getAnswer(Scanner scanner) {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                synchronized (scanner) {
                    scanner.notify();
                }
            }
        };

        timer.schedule(task, 10000); // 10 seconds timer

        synchronized (scanner) {
            try {
                System.out.print("Your answer: ");
                if (scanner.hasNextInt()) {
                    int answer = scanner.nextInt();
                    if (answer == questions[currentQuestionIndex].correctAnswer) {
                        score++;
                    }
                    timer.cancel();
                    return true;
                } else {
                    scanner.next(); // clear invalid input
                    timer.cancel();
                    return false;
                }
            } catch (Exception e) {
                timer.cancel();
                return false;
            }
        }
    }

    private static void displayResult() {
        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + "/" + questions.length);
        System.out.println("Summary:");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i].question);
            System.out.println("Your answer: " + (questions[i].correctAnswer == i + 1 ? "Correct" : "Incorrect"));
        }
    }
}
