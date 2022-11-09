package zpi.algospace.model.dto;

import lombok.Data;
import zpi.algospace.model.Hint;

@Data
public class HintDTO {
    private final String content;
    private final Integer level;

    public HintDTO(Hint hint) {
        this.content = hint.getContent();
        this.level = hint.getLevel();
    }
}
