package zpi.algospace.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zpi.algospace.model.Category;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CategoryService {
    public List<String> findCategories() {
        return Arrays.stream(Category.values()).toList()
                .stream()
                .map(category -> category.getTranslation())
                .collect(toList());
    }
}
