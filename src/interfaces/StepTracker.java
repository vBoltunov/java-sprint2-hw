package Interfaces;

import Data.MonthData;

import java.util.Scanner;

public class StepTracker {
    int number;
    Scanner scanner;
    MonthData[] monthToDataArray = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToDataArray.length; i++) {
            monthToDataArray[i] = new MonthData();
        }
    }

    public int userInputValidation() {
        while (true) {
            try {
                number = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Вы ввели не число!\nПопробуйте ещё раз: ");
            }
        }
        return number;
    }

    public void addNewNumberStepsPerDay() {
        System.out.print("Введите номер месяца: ");

        int month = userInputValidation();

        if (month < 1 || month > 12) {
            System.out.println("Месяц должен быть от 1 до 12. А у вас: " + month);
            return;
        }

        System.out.print("Введите день от 1 до 30 (включительно): ");

        int day = userInputValidation();

        if (day < 1 || day > 30) {
            System.out.println("День должен быть от 1 до 30. А у вас: " + day);
            return;
        }

        System.out.print("Введите количество шагов: ");

        int steps = userInputValidation();

        if (steps < 0) {
            System.out.println("Количество шагов не может быть отрицательным. А у вас: " + steps);
        }

        // получение соответствующего месяца
        MonthData monthData = monthToDataArray[month - 1];
        // запись количества шагов в указанный день
        monthData.days[day - 1] = steps;

        System.out.println("Информация внесена в базу банных Счётчика калорий.");
        // Пустая строка-разделитель
        System.out.println();
    }

    public void changeStepGoal() {
        System.out.print("Введите новую цель по количеству шагов в день: ");

        int stepsPerDay = userInputValidation();

        if (stepsPerDay <= 0) {
            System.out.println("Количество шагов не может быть отрицательным или равным нулю. А у вас: " + stepsPerDay);
            return;
        }
        goalByStepsPerDay = stepsPerDay;

        System.out.println("Новая цель: " + goalByStepsPerDay + " шагов в день");

        // Пустая строка-разделитель
        System.out.println();
    }

    public void printStatistic() {
        System.out.print("Введите число месяца: ");

        int month = userInputValidation();

        if (month < 1 || month > 12) {
            System.out.println("Месяц должен быть от 1 до 12. А у вас: " + month);
            return;
        }

        // получение соответствующего месяца
        MonthData monthData = monthToDataArray[month - 1];
        // получение суммы шагов за месяц
        int sumSteps = monthData.sumStepsFromMonth();

        // вывод общей статистики по дням
        monthData.printDaysAndStepsFromMonth();

        System.out.println("Всего пройдено шагов за месяц: " + sumSteps);

        System.out.println("Максимальное количество шагов за месяц: " + monthData.maxSteps());

        System.out.println("Среднее количество шагов за месяц: " + sumSteps / 30);

        System.out.println("Пройденная за месяц дистанция в километрах: " + converter.convertToKm(sumSteps));

        System.out.println("Количество сожжённых килокалорий за месяц: "
                + converter.convertStepsToKilocalories(sumSteps));

        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay) + " дней.");

        // Пустая строка-разделитель
        System.out.println();
    }
}
