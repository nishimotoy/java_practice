import java.util.ArrayList;
import java.util.List;

public class ExpenseService {

    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public int calculateTotal() {
        int total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    // 一覧取得（表示しない！）
    public List<Expense> getAllExpenses() {
        return expenses;
    }
}
