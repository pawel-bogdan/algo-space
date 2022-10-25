package zpi.algospace.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TaskGeneralInfo {
    private Long id;
    private String name;
    private CategoryDTO category;
    private DifficultyDTO difficulty;
}
