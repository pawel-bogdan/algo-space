package zpi.algospace.complementer;

import org.springframework.context.annotation.Bean;
import zpi.algospace.model.Solution;

public interface Complementary {
    void complement(Solution solution);
}
