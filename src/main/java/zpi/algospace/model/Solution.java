package zpi.algospace.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime submitionDate;
    private String content;
    @Transient
    private String complementedContent;
    private Language language;
    @ManyToOne
    private Task task;
    @ManyToOne
    private User solver;

    public void setComplementedContent(String complementedContent) {
        this.complementedContent = complementedContent;
    }
}
