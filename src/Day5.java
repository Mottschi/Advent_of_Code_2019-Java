import java.io.IOException;
import java.util.ArrayList;

public class Day5 implements Day{
    ArrayList<Long> data = new ArrayList<Long>();

    Day5() throws IOException {
        this.data = InputLoader.loadIntListCSV("inputs\\day5.txt");
    }

    @Override
    public int partOne() {
        IntCodeComputer myPC = new IntCodeComputer(new ArrayList<Long>(this.data));
        myPC.runProgram();
        return 0;
    }

    @Override
    public int partTwo() {
        IntCodeComputer myPC = new IntCodeComputer(new ArrayList<Long>(this.data));
        myPC.runProgram();
        return 0;
    }
}
