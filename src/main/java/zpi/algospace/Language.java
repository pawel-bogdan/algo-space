package zpi.algospace;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
enum Language {
    JAVA("java"),
    PYTHON("python"),
    CPP("cpp");

    private final String languageName;
}
