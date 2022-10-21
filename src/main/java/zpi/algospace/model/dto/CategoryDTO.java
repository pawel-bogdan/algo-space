package zpi.algospace.model.dto;

import lombok.Getter;
import zpi.algospace.model.Category;


@Getter
public class CategoryDTO {
    private Category categoryId;
    private String translation;

    public CategoryDTO(Category category) {
        this.categoryId = category;
        this.translation = category.getTranslation();
    }
}
