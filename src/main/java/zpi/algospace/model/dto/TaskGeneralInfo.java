package zpi.algospace.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskGeneralInfo {
    private final Long id;
    private final String name;
    private final CategoryDTO category;
    private final DifficultyDTO difficulty;
}
