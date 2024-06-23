public class Converter {

    // 1 шаг = 75 см
    int convertToKm(int steps) {
        return steps * 75 / 100 / 1000;
    }

    // 1 шаг = 50 кал; 1 ккал = 1000 кал
    int convertStepsToKilocalories(int steps) {
        return steps * 50 / 1000;
    }
}
