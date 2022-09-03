package zpi.algospace.models.dto;

import lombok.Builder;
import lombok.Getter;
import zpi.algospace.Category;
import zpi.algospace.models.Difficulty;

@Builder
@Getter // jackson
public class TaskGeneralInfo {
    private Long id;
    private String name;
    private Category category;
    private Difficulty difficulty;

}
