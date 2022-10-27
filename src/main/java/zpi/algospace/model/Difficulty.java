package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Difficulty {
    EASY("Łatwe"),
    MEDIUM("Średnie"),
    HARD("Trudne");

    private final String translation;
}
