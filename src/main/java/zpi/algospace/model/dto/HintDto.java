package zpi.algospace.model.dto;

import lombok.Data;
import zpi.algospace.model.Hint;

@Data
public class HintDto {
    private final String content;
    private final Integer level;

    public HintDto(Hint hint) {
        content = hint.getContent();
        level = hint.getLevel();
    }
}
