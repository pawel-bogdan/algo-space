package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zpi.algospace.service.CategoryService;

import java.util.List;

@RestController
@Tag(name = "Category Controller")
@RequiredArgsConstructor
@RequestMapping({"/", "/api"})
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    @Operation(summary = "Get all available categories")
    public List<String> getCategories() {
        return categoryService.findCategories();
    }
}
