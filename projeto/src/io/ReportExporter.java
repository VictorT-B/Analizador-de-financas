package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportExporter {

    public static void exportSummary(String filePath, double balance, Map<String, Double> expensesByCategory) throws IOException {
        List<String> reportLines = new ArrayList<>();
        reportLines.add("=== RELATÓRIO FINANCEIRO ===");
        reportLines.add(String.format("Saldo Total: R$ %.2f", balance));
        reportLines.add("");
        reportLines.add("Gastos por Categoria:");

        expensesByCategory.forEach((category, total) -> reportLines.add(String.format("- %s: R$ %.2f", category, total)));

        Files.write(Path.of(filePath), reportLines);
    }
}



