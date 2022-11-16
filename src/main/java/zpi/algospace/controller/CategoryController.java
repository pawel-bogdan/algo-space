package zpi.algospace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zpi.algospace.model.dto.CategoryDTO;
import zpi.algospace.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping({"/", "/api"})
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Category Controller")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    @Operation(summary = "Get all available categories.")
    public List<CategoryDTO> getCategories() {
        log.info(" >>> Request got. /categories");
        return categoryService.findCategories();
    }
}
