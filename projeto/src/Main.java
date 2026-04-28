import io.ReportExporter;
import io.TransactionParser;
import model.Transaction;
import service.FinanceAnalyzer;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String inputPath = "transactions.csv";
        String outputPath = "resumo_financeiro.txt";

        try {
            List<Transaction> transactions = TransactionParser.parseCsv(inputPath);

            FinanceAnalyzer analyzer = new FinanceAnalyzer(transactions);

            ReportExporter.exportSummary(outputPath, analyzer.calculateTotalBalance(), analyzer.getExpensesByCategory());

            System.out.println("Processamento concluído com sucesso!");
            System.out.println("Verifique o arquivo: " + outputPath);

        } catch (IOException e) {
            System.err.println("Erro ao acessar os arquivos: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro no formato dos dados do CSV: " + e.getMessage());
        }
    }
}

