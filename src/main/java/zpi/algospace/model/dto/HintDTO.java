package zpi.algospace.model.dto;

import lombok.Getter;
import zpi.algospace.model.Hint;

@Getter
public class HintDTO {
    private final String content;
    private final Integer level;

    public HintDTO(Hint hint) {
        this.content = hint.getContent();
        this.level = hint.getLevel();
    }
}
