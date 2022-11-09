package zpi.algospace.model.dto;

import lombok.Data;
import zpi.algospace.model.Difficulty;

@Data
public class DifficultyDTO {
    private final Difficulty id;
    private final String translation;

    public DifficultyDTO(Difficulty difficulty) {
        this.id = difficulty;
        this.translation = difficulty.getTranslation();
    }
}
