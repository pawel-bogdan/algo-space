package zpi.algospace.model.dto;

import lombok.Data;
import zpi.algospace.model.Language;

@Data
public class LanguageDto {
    private final Language languageId;
    private final String translation;

    public LanguageDto(Language language) {
        languageId = language;
        translation = language.getName();
    }
}
