import java.util.Scanner;
import java.time.Year;

public class ft {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Working since: ");
        int yearStarted = scanner.nextInt();

        System.out.print("Bonus percent: ");
        double bonusPercent = scanner.nextDouble();

        System.out.print("Tax percent: ");
        double taxPercent = scanner.nextDouble();

        System.out.print("Worked days: ");
        int workedDays = scanner.nextInt();

        System.out.print("Number of days in a month: ");
        int totalDays = scanner.nextInt();

        Payment p = new Payment(lastName, firstName, salary, yearStarted,
                bonusPercent, taxPercent, workedDays, totalDays);
        p.printInfo();
    }
}

class Payment {
    private String lastName;
    private String firstName;
    private double salary;
    private int yearStarted;
    private double bonusPercent;
    private double taxPercent;
    private int workedDays;
    private int totalDays;

    private double accruedAmount;
    private double withheldAmount;

    public Payment(String lastName, String firstName, double salary, int yearStarted,
                   double bonusPercent, double taxPercent, int workedDays, int totalDays) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.yearStarted = yearStarted;
        this.bonusPercent = bonusPercent;
        this.taxPercent = taxPercent;
        this.workedDays = workedDays;
        this.totalDays = totalDays;
        calculateAccruedAmount();
        calculateWithheldAmount();
    }

    public void calculateAccruedAmount() {
        double base = salary * workedDays / totalDays;
        double bonus = base * (bonusPercent / 100);
        accruedAmount = base + bonus;
    }

    public void calculateWithheldAmount() {
        withheldAmount = accruedAmount * (taxPercent / 100);
    }

    public int calculateExperience() {
        int currentYear = Year.now().getValue();
        return currentYear - yearStarted;
    }

    public void printInfo() {
        System.out.println("Lastname and first name: " + lastName + " " + firstName);
        System.out.println("Work experience: " + calculateExperience() + " years");
        System.out.printf("Accrued: %.2f грн\n", accruedAmount);
        System.out.printf("Withheld: %.2f грн\n", withheldAmount);
    }
}
