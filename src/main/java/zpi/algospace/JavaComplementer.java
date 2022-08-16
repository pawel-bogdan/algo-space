package zpi.algospace;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JavaComplementer implements Complementary {
    //nwm czy tu czy w enumach podmieni sie najwyzej
    private static final String IMPORTS = "import java.util.*; java.lang.Math.*;";
    private static final String CLASS_CORE = "public class %s public static void main() (String[] args){ %s } %s }";
    //chwilowo potem beda z bazy
    private static final String TESTS = "System.out.println(\"hello\");";
    private String className;
    //bedzie potrzebne do pobrania testow
    //private Task task;

    //stawiam ze solution to metoda
    @Override
    public String complement(String solution) {
        return IMPORTS + String.format(CLASS_CORE, className, TESTS, solution);
    }

}
