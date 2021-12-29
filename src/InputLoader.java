import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputLoader {

    public static ArrayList<Integer> loadIntList(String filename) throws IOException {
        // Loads a list of integers seperated by newline
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = "";
        ArrayList<Integer> data = new ArrayList<Integer> ();
        while ((line = reader.readLine()) != null) {
            data.add(Integer.parseInt(line));
        }
        reader.close();

        return data;
    }

    public static ArrayList<Long> loadIntListCSV (String filename) throws IOException {
        // Loads a list of integers seperated by commas
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = "";
        ArrayList<Long> data = new ArrayList<Long> ();
        line = reader.readLine();
        reader.close();

        String[] values = line.split(",");
        for (String value: values) {
            data.add(Long.parseLong(value));
        }
        return data;
    }

    public static ArrayList<ArrayList<String>> loadStrListCSV (String filename) throws IOException {
        // Loads a list of Strings seperated by commas
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = "";
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>> ();

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            ArrayList<String> lineList = new ArrayList<String>();

            for (String value: values) {
                lineList.add(value);
            }
            data.add(lineList);

        }
        reader.close();

        return data;
    }

    public InputLoader() {

    }
}
