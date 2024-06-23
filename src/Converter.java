public class Converter {

    int convertToKm(int steps) {
        double stepsInKilometers = steps * 0.75 / 1000;
        return (int) stepsInKilometers;
    }

    int convertStepsToKilocalories(int steps) {
        return steps * 50 / 1000;
    }
}
