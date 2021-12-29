import java.util.Arrays;
import java.util.HashSet;

public class Day4 implements Day{
    int rangeStart;
    int rangeEnd;
    int counter;

    Day4 (){
        String[] input = "124075-580769".split("-");
        this.rangeStart = Integer.parseInt(input[0]);
        this.rangeEnd = Integer.parseInt(input[1]);


    }

    @Override
    public int partOne() {
       this.counter = 0;

        for (int i = this.rangeStart; i <= this.rangeEnd; i++) {
            int number = i;
            int[] digits = new int[6];
            for (int j = 5; j >= 0; j--) {
                digits[j] = number % 10;
                number /= 10;
            }

            boolean nextNumber = false;

            for (int j = 0; j < 5; j++) {
                if (digits[j] > digits[j+1]) {
                    nextNumber = true;
                    break;
                }
            }

            if (nextNumber) {
                continue;
            }

            nextNumber = true;
            for (int j = 0; j < 5; j++) {
                if (digits[j] == digits[j+1]) {
                    nextNumber = false;
                    break;
                }
            }

            if (nextNumber) {
                continue;
            }

            this.counter++;

        }
        return this.counter;
    }

    @Override
    public int partTwo() {

        this.counter = 0;

        for (int i = this.rangeStart; i <= this.rangeEnd; i++) {
            int number = i;
            int[] digits = new int[6];
            for (int j = 5; j >= 0; j--) {
                digits[j] = number % 10;
                number /= 10;
            }

            boolean nextNumber = false;

            for (int j = 0; j < 5; j++) {
                if (digits[j] > digits[j+1]) {
                    nextNumber = true;
                    break;
                }
            }

            if (nextNumber) {
                continue;
            }

            nextNumber = true;

            int currentDigit = digits[0];
            int currentCount = 1;

            for (int j = 1; j < 6; j++) {
                if (digits[j] == currentDigit) {
                    currentCount += 1;
                } else {
                    if (currentCount == 2) {
                        nextNumber = false;
                        break;
                    }
                    currentCount = 1;
                    currentDigit = digits[j];
                }
            }

            if (nextNumber && currentCount != 2) {
                continue;
            }

            this.counter++;

        }
        return this.counter;
    }


}
