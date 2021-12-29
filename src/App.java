import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Let's go");
        Day day = new Day9();
        System.out.println("Going...\nPart One:");
        day.partOne();
//        System.out.println(day.partOne());

        System.out.println("\nGoing further...\nPart Two:");
        day.partTwo();
//        System.out.println(day.partTwo());
    }
}
