package zpi.algospace.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Solution {
    private final LocalDateTime submitionDate;
    private final String content;
    private final Language language;
    private final Task task;
    private User solver;

    public Solution(String content, String language, long taskId, int userID){
        this.submitionDate = LocalDateTime.now();
        this.content = content;
        this.language = Language.JAVA;
        this.task = new Task(taskId);
        //cos takiego pewnie potem this.solver = User.getUser(userID);
    }
}
