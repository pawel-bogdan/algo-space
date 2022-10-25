package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.Language;
import zpi.algospace.model.dto.LanguageDTO;
import zpi.algospace.service.LanguageService;

import java.io.IOException;
import java.util.List;

@RestController
@Tag(name = "Language Controller")
@RequiredArgsConstructor
@RequestMapping({"/", "/api"})
@CrossOrigin(origins = {"${allowed.origin}"})
@Slf4j
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping(value = "/languages/logo/{lang}", produces = MediaType.IMAGE_JPEG_VALUE)
    @Operation(summary = "Get all available categories.")
    public @ResponseBody
    ResponseEntity<byte[]> getLanguageLogo(@PathVariable Language lang) {
        log.info(" >>> Request got. /languages/logo/{}", lang);
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(languageService.findLanguageLogo(lang));
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            log.error("Could not load language logo", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/languages")
    @Operation(summary = "Get all available languages.")
    public List<LanguageDTO> getAllLanguages() {
        log.info(" >>> Request got. /languages");
        return languageService.findLanguages();
    }
}
