package zpi.algospace.model.dto;

import lombok.Data;
import zpi.algospace.model.Difficulty;

@Data
public class DifficultyDto {
    private final Difficulty id;
    private final String translation;

    public DifficultyDto(Difficulty difficulty) {
        id = difficulty;
        translation = difficulty.getTranslation();
    }
}
