package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Language {
    JAVA("Java 17", ".java", "src/main/resources/images/languages/java.png"),
    PYTHON("Python (3.10)", ".py", "src/main/resources/images/languages/python.png"),
    CPP("C++ (g++ 11.3.0)", ".cpp", "src/main/resources/images/languages/c++.png");

    private final String name;
    private final String extension;
    private final String logoPath;
}
