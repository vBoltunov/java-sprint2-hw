import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker(scanner);

        System.out.println("Добро пожаловать в приложение \"Счётчик калорий\"!");

        while (true) {
            printMenu();

            int command = tracker.userInputValidation();

            if (command == 1) {
                tracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                tracker.changeStepGoal();
            } else if (command == 3) {
                tracker.printStatistic();
            } else if (command == 4) {
                System.out.println("Спасибо, что воспользовались нашим приложением!");
                return;
            } else {
                System.out.println("Такой команды пока нет!");
            }
        }
    }

    static void printMenu() {
        System.out.println("Что Вы желаете сделать?");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
        System.out.print("Ваш выбор: ");
    }
}
