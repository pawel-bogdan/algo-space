package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FileName {
    INPUT("input.txt"),
    ERROR("error.txt"),
    OUTPUT("output.txt");

    private final String name;
}
