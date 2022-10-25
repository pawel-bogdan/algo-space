package zpi.algospace.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
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
    private LocalDateTime submissionDate;
    private String content;
    @Transient
    private String complementedContent;
    private Language language;
    @ManyToOne
    private Task task;
    @ManyToOne
    private User solver;
}
