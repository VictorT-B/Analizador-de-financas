package service;

import model.Transaction;
import model.Type;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FinanceAnalyzer {

    private final List<Transaction> transactions;

    public FinanceAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getExpenses() {
        return transactions.stream().filter(t -> t.type() == Type.EXPENSE).toList();
    }

    public double calculateTotalBalance() {
        return transactions.stream().mapToDouble(t -> t.type() == Type.INCOME ? t.amount() : -t.amount()).sum();
    }

    public List<Transaction> getTransactionsAbove(double threshold) {
        return transactions.stream().filter(t -> t.amount() > threshold).toList();
    }

    public Map<String, Double> getExpensesByCategory() {
        return transactions.stream().filter(t -> t.type() == Type.EXPENSE)
                .collect(Collectors.groupingBy(Transaction::category, Collectors.summingDouble(Transaction::amount)));
    }
}




