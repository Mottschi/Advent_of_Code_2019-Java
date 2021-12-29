import java.util.ArrayList;
import java.io.IOException;

public class Day2 implements Day{
    ArrayList<Long> data = new ArrayList<Long>();

    public Day2() throws IOException {
        this.data = InputLoader.loadIntListCSV("inputs\\day2.txt");
    }

    public int partOne() {
        IntCodeComputer myPC = new IntCodeComputer(new ArrayList<Long>(this.data));

        myPC.memory.put((long) 1, (long) 12);
        myPC.memory.put((long) 2, (long) 2);

        System.out.println(myPC.runProgram());
        return 1;
    }

    public int partTwo() {
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                IntCodeComputer myPC = new IntCodeComputer(new ArrayList<Long>(this.data));

                myPC.memory.put((long) 1, (long) noun);
                myPC.memory.put((long) 2, (long) verb);

                if (myPC.runProgram() == 19690720) {
                    return 100 * noun + verb;
                }

            }
        }
        return -1;
    }

}
