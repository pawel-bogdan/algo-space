package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import zpi.algospace.model.Code;
import zpi.algospace.service.SyntaxService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name = "Syntax controller")
@RequestMapping({"/syntax", "/api/syntax"})
@CrossOrigin
@Slf4j
public class SyntaxController {
    private final SyntaxService syntaxService;

    @PostMapping("/check")
    @Operation(summary = "Check syntax of method in given language")
    public String checkSyntax(@RequestBody Code code) {
        try {
            return syntaxService.checkSyntax(code);
        } catch (IllegalArgumentException | IOException e) {
            log.error(e.getMessage());
            return "ERROR";
        }
    }
}
