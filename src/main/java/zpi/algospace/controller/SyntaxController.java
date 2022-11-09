package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.Code;
import zpi.algospace.service.SyntaxService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name = "Syntax controller")
@RequestMapping({"/syntax", "/api/syntax"})
@CrossOrigin
@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
public class SyntaxController {
    private final SyntaxService syntaxService;

    @PostMapping("/check")
    @Operation(summary = "Check syntax of method in given language")
    public ResponseEntity<String> checkSyntax(@RequestBody Code code) {
        try {
            log.info(" >>> Request got. /syntax/check with params: code: {}", code);
            return ResponseEntity.ok(syntaxService.checkSyntax(code));
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        } catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }
}
