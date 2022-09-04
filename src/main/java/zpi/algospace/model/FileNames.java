package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FileNames{
    INPUT("input.txt"),
    ERROR("error.txt"),
    OUTPUT("output.txt");

    private final String name;
}
