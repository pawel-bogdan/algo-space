package zpi.algospace.model.dto;

import lombok.Getter;
import zpi.algospace.model.Hint;

@Getter // Jackson
public class HintDTO {
    private String content;
    private Integer level;

    public HintDTO(Hint hint) {
        this.content = hint.getContent();
        this.level = hint.getLevel();
    }
}
