package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Code {
    private Language language;
    @Setter
    private String code;
}
