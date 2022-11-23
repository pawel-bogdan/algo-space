package zpi.algospace.service;

import org.springframework.stereotype.Service;
import zpi.algospace.model.Category;
import zpi.algospace.model.dto.CategoryDto;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CategoryService {
    public List<CategoryDto> findCategories() {
        return Arrays.stream(Category.values()).toList()
                .stream()
                .map(CategoryDto::new)
                .collect(toList());
    }
}
