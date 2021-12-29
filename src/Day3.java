import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Day3 {
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    HashMap<Coordinate, Integer> wireOne = new HashMap<Coordinate, Integer>();
    HashMap<Coordinate, Integer> wireTwo = new HashMap<Coordinate, Integer>();


    public Day3() throws IOException {
        this.data = InputLoader.loadStrListCSV("inputs\\day3.txt");

        Coordinate currentLoc = new Coordinate(0, 0);
        int rowMod = 0;
        int colMod = 0;
        int steps = 0;

        for (String element: this.data.get(0)) {
            String direction = element.substring(0, 1);
            int value = Integer.parseInt(element.substring(1));

            switch (direction) {
                case "U" -> {
                    rowMod = 0;
                    colMod = 1;
                }
                case "D" -> {
                    rowMod = 0;
                    colMod = -1;
                }
                case "L" -> {
                    rowMod = -1;
                    colMod = 0;
                }
                case "R" -> {
                    rowMod = 1;
                    colMod = 0;
                }
                default -> System.out.println("Error: Invalid direction");
            }

            for (int i = 0; i < value; i++) {
                steps++;
                currentLoc = new Coordinate(currentLoc.getX() + colMod, currentLoc.getY() + rowMod);
                if (!wireOne.containsKey(currentLoc)) {
                    wireOne.put(currentLoc, steps);
                }

            }
        }

        currentLoc = new Coordinate(0, 0);
        steps = 0;

        for (String element: this.data.get(1)) {
            String direction = element.substring(0, 1);
            int value = Integer.parseInt(element.substring(1));

            switch (direction) {
                case "U" -> {
                    rowMod = 0;
                    colMod = 1;
                }
                case "D" -> {
                    rowMod = 0;
                    colMod = -1;
                }
                case "L" -> {
                    rowMod = -1;
                    colMod = 0;
                }
                case "R" -> {
                    rowMod = 1;
                    colMod = 0;
                }
                default -> System.out.println("Error: Invalid direction");
            }

            for (int i = 0; i < value; i++) {
                steps++;
                currentLoc = new Coordinate(currentLoc.getX() + colMod, currentLoc.getY() + rowMod);
                if (!wireTwo.containsKey(currentLoc)) {
                    wireTwo.put(currentLoc, steps);
                }
            }
        }

    }

    public int partOne() {
        Set<Coordinate> overlap = wireOne.keySet();
        overlap.retainAll(wireTwo.keySet());

        int minDistance = Integer.MAX_VALUE;
        Coordinate zero = new Coordinate(0, 0);
        int d = 0;

        for (Coordinate coord: overlap) {
            d = coord.distance(zero);
            if (d < minDistance) {
                minDistance = d;
            }
        }
        return minDistance;
    }

    public int partTwo() {
        Set<Coordinate> overlap = wireOne.keySet();
        overlap.retainAll(wireTwo.keySet());

        int minDistance = Integer.MAX_VALUE;
        Coordinate zero = new Coordinate(0, 0);
        int d = 0;

        for (Coordinate coord: overlap) {
            d = wireOne.get(coord) + wireTwo.get(coord);
            if (d < minDistance) {
                minDistance = d;
            }
        }
        return minDistance;
    }
}
