package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Language {
    JAVA("Java", ".java", "src/main/resources/images/languages/java.png"),
    PYTHON("Python", ".py", "src/main/resources/images/languages/python.png"),
    CPP("C++", ".cpp", "src/main/resources/images/languages/c++.png");

    private final String name;
    private final String extension;
    private final String logoPath;
}
