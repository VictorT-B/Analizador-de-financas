package model;

import java.time.LocalDate;

public record Transaction(
        String description,
        double amount,
        String category,
        Type type,
        LocalDate date
) {
}