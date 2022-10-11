package zpi.algospace.complementer;

import lombok.AllArgsConstructor;
import zpi.algospace.model.Language;
import zpi.algospace.model.Solution;

@AllArgsConstructor
public class JavaComplementer implements Complementary {

    private static final String CLASS_TEMPLATE =
            """
            import java.util.*;
            public class %s {
                public static void main(String [] args) {
                %s
                }
                
            %s
            }
            """;

    private String className;

    @Override
    public void complement(Solution solution) {
        solution.setComplementedContent(String.format(CLASS_TEMPLATE, className, prepareTests(solution, Language.JAVA), solution.getContent()));
    }
}
