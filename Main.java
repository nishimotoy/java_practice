import java.util.ArrayList;     /* クラス */
import java.util.List;          /* クラス */
import java.util.Scanner;       /* インターフェース */

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);   // コンソール入力 
        List<Expense> expenses = new ArrayList<>(); // 使い方は List、実体は ArrayList

        while (true) {
            System.out.println("----- Menu -----");   // 表示
            System.out.println("1. Add expense");
            System.out.println("2. Show list");
            System.out.println("3. Show total");
            System.out.println("0. Exit");
            System.out.print("Select: ");

            int choice = scanner.nextInt();   // 選択肢 

            if (choice == 1) {
                addExpense(scanner, expenses);  // scanner も渡す　入力手段を指定
            } else if (choice == 2) {
                showList(expenses);             // 渡す側は簡潔に、受け側は型付で受け取る
            } else if (choice == 3) {
                int total = calculateTotal(expenses);  // 変更点
                System.out.println("Total: " + total); // 戻り値で帰り、メイン処理の中で出力する形式に
            } else if (choice == 0) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }

    // --- functions ---        メソッド 戻り値の型 メソッド名(引数...) { ... }

    static void addExpense(Scanner scanner, List<Expense> expenses) { 
        System.out.print("Enter amount: ");
        int amount = scanner.nextInt();

        Expense expense = new Expense();
        expense.amount = amount;

        expenses.add(expense);
    }

    static void showList(List<Expense> expenses) {
        System.out.println("---- Expense List ----");
        for (Expense e : expenses) {
            System.out.println(e.amount);
        }
    }

    static int calculateTotal(List<Expense> expenses) {  // 返り値の型がint
        int total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        return total;           // return文で返り値を指定
    }
}

// --- data class ---
class Expense {
    int amount;
}
