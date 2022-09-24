package zpi.algospace.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
//@Entity
public class Solution {
    private final LocalDateTime submitionDate;
    private final String content;
    private final Language language;
    private final long taskId;
    private final long solverId;

    public Solution(String content, Language language, long taskId, int solverId){
        this.submitionDate = LocalDateTime.now();
        this.content = content;
        this.language = language;
        this.taskId = taskId;
        this.solverId = solverId;
    }
}
