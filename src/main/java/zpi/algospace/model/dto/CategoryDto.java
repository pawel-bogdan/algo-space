package zpi.algospace.model.dto;

import lombok.Data;
import zpi.algospace.model.Category;

@Data
public class CategoryDto {
    private final Category categoryId;
    private final String translation;

    public CategoryDto(Category category) {
        categoryId = category;
        translation = category.getTranslation();
    }
}
