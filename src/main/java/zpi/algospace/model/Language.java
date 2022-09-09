package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Language {
    JAVA("java", ".java"),
    PYTHON("python", ".py"),
    CPP("cpp", ".cpp");

    private final String name;
    private final String extension;
}
