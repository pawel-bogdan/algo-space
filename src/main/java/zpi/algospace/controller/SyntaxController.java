package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.Code;
import zpi.algospace.model.dto.SyntaxMessageWrapper;
import zpi.algospace.service.SyntaxService;

import java.io.IOException;

@RestController
@RequestMapping({"/syntax", "/api/syntax"})
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Syntax controller")
@SecurityRequirement(name = "Bearer Authentication")
public class SyntaxController {
    private final SyntaxService syntaxService;

    @PostMapping("/check")
    @Operation(summary = "Check syntax of method in given language")
    public ResponseEntity<SyntaxMessageWrapper> checkSyntax(@RequestBody Code code) {
        try {
            log.info(" >>> Request got. /syntax/check with params: code:\n{}", code);
            return ResponseEntity.ok(new SyntaxMessageWrapper(syntaxService.checkSyntax(code)));
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }
}


