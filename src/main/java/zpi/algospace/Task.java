package zpi.algospace;

import lombok.Data;

import java.util.List;

@Data
class Task {
    // TODO tu musimy sie zastanowic czy chcemy ten content
    //  juz w tej klasie przechowywac jako HTML jakis
    private final Long id;
    private String content;
    private Category category;
    private List<Hint> hints;
}
