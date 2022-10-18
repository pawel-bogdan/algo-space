package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.service.LanguageService;

import java.util.List;

@RestController
@Tag(name = "Language Controller")
@RequiredArgsConstructor
@RequestMapping({"/", "/api"})
@CrossOrigin
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping(value = "/languages", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    List<byte[]> getAllLanguageLogos() {
        return languageService.findLanguageLogos();
    }

    @GetMapping(value = "/languages")
    public List<String> getAllLanguages() {
        return languageService.findLanguages();
    }


}
