import java.util.ArrayList;
import java.io.IOException;

public class Day1 {
    ArrayList<Integer> data = new ArrayList<Integer>();

    public Day1() throws IOException {
        this.data = InputLoader.loadIntList("inputs\\day1.txt");
    }

    public int partOne() {
        int sum = 0;
        for (int mass: this.data) {
            int fuel = mass / 3 - 2;
            sum += fuel;

        }
        return sum;
    }

    public int partTwo() {
        int sum = 0;
        for (int mass: this.data) {
            int fuel = mass / 3 - 2;

            while (fuel > 0) {
                sum += fuel;
                fuel = fuel / 3 - 2;
            }
        }

        return sum;
    }
}
