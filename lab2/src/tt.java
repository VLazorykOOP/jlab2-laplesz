import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class tt {

    public static String getDateInfo(int dayOfYear, int year) {
        try {
            LocalDate date = LocalDate.ofYearDay(year, dayOfYear);

            String month = date.getMonth().getDisplayName(TextStyle.FULL, new Locale("en"));
            String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("en"));

            return date.getDayOfMonth() + " " + month + ", " + dayOfWeek;
        } catch (Exception e) {
            return "Incorrect input data: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of the day in the year: ");
        int dayOfYear = scanner.nextInt();

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        String result = getDateInfo(dayOfYear, year);

        System.out.println("Result: " + result);
    }
}
