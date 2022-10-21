package zpi.algospace.model.dto;

import lombok.Getter;
import zpi.algospace.model.Language;

@Getter
public class LanguageDTO {
    private final Language languageId;
    private final String translation;

    public LanguageDTO(Language language) {
        this.languageId = language;
        this.translation = language.getName();
    }
}
