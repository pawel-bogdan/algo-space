package zpi.algospace.model;

import lombok.Data;

import java.util.List;

@Data
public class Task {
    // TODO tu musimy sie zastanowic czy chcemy ten content
    //  juz w tej klasie przechowywac jako HTML jakis
    private final Long id;
    private String content;
    private Category category;
    private List<Hint> hints;

    public Task(long id){
        this.id = id;
    }

}
