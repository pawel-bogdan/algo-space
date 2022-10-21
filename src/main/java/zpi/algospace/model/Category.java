package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    ARRAYS("Tablice"),
    STRINGS("Ciągi znaków"),
    STACKS("Stosy"),
    RECURSION("Rekurencja"),
    SORTING("Sortowanie"),
    OTHER("Inne");

    private final String translation;
}
