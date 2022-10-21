package zpi.algospace.model.dto;

import lombok.Getter;
import zpi.algospace.model.Difficulty;

@Getter
public class DifficultyDTO {
    private Difficulty id;
    private String translation;

    public DifficultyDTO(Difficulty difficulty) {
        this.id = difficulty;
        this.translation = difficulty.getTranslation();
    }
}
