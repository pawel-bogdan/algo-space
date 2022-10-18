package zpi.algospace.model.dto;

import lombok.Builder;
import lombok.Getter;
import zpi.algospace.model.Category;
import zpi.algospace.model.Difficulty;

@Builder
@Getter
public class TaskGeneralInfo {
    private Long id;
    private String name;
    private Category category;
    private Difficulty difficulty;
}