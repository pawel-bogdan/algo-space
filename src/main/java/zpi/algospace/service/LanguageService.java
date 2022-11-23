package zpi.algospace.service;

import org.springframework.stereotype.Service;
import zpi.algospace.model.Language;
import zpi.algospace.model.dto.LanguageDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {
    public List<LanguageDto> findLanguages() {
        return Arrays.stream(Language.values())
                .map(LanguageDto::new)
                .collect(Collectors.toList());
    }

    public byte[] findLanguageLogo(Language lang) throws IOException {
        Language language = Arrays.stream(Language.values())
                .filter(l -> l == lang)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s does not exist", lang)));

        return Files.readAllBytes(Path.of(language.getLogoPath()));
    }
}
