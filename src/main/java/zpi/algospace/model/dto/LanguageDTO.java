package zpi.algospace.model.dto;

import lombok.Data;
import zpi.algospace.model.Language;

@Data
public class LanguageDTO {
    private final Language languageId;
    private final String translation;

    public LanguageDTO(Language language) {
        this.languageId = language;
        this.translation = language.getName();
    }
}
