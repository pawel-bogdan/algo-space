package zpi.algospace.service;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import zpi.algospace.model.Language;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {
    public List<String> findLanguages() {

        return Arrays.stream(Language.values())
                .map(Language::getName)
                .collect(Collectors.toList());
    }

    public List<byte[]> findLanguageLogos() {
        return Arrays.stream(Language.values())
                .map(lang -> {
                    try {
                        return IOUtils.toByteArray(getClass().getResourceAsStream(lang.getLogoPath()));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toList());

    }
}
