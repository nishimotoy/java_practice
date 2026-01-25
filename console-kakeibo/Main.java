import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Expense> expenses = new ArrayList<>();

        while (true) {
            System.out.println("1: Add expense");
            System.out.println("2: Show total");
            System.out.println("3: Show list");
            System.out.println("0: Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 改行消費

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                addExpense(scanner, expenses);
            } else if (choice == 2) {
                int total = calculateTotal(expenses);
                System.out.println("Total: " + total);
            } else if (choice == 3) {
                showList(expenses);
            }
        }

        scanner.close();
    }

    static void addExpense(Scanner scanner, List<Expense> expenses) {
        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); // 改行消費

        expenses.add(new Expense(category, amount));
    }

    static int calculateTotal(List<Expense> expenses) {
        int total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    static void showList(List<Expense> expenses) {
        for (Expense e : expenses) {
            System.out.println(e.getCategory() + " : " + e.getAmount());
        }
    }
}
