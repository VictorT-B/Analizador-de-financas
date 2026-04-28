package io;

import model.Transaction;
import model.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class TransactionParser {

    public static List<Transaction> parseCsv(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            return lines.skip(1)
                    .map(line -> line.split(",")).filter(parts -> parts.length == 5)
                    .map(parts -> new Transaction(parts[0],
                            Double.parseDouble(parts[1]),
                            parts[2],
                            Type.valueOf(parts[3]),
                            LocalDate.parse(parts[4])
                    )).toList();
        }
    }
}

