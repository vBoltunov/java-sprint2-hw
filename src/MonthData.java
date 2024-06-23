public class MonthData {
//    int[] days = new int[30];
    int[] days = {7716, 10684, 15503, 13089, 5419, 13758, 17512, 11789, 16373, 19092, 19889, 6730, 12066, 7211, 16995, 11223, 8303, 11317, 5171, 10760, 9337, 16125, 16965, 18674, 7765, 17532, 18371, 10715, 10602, 7918};

    void printDaysAndStepsFromMonth() {
        System.out.println("Статистика по дням:");

        for (int i = 0; i < days.length; i++) {
            // вывод элементов массива в нужном формате
            System.out.println("День " + (i + 1) + ": " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;

        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
