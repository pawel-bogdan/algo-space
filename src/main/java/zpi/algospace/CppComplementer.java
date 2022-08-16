package zpi.algospace;

public class CppComplementer implements Complementary {
    //nwm czy tu czy w enumach podmieni sie najwyzej
    private static final String IMPORTS = "#include <bits/stdc++.h>\nusing namespace std;";
    private static final String CLASS_CORE = "int main() { %s } %s }";
    //chwilowo potem beda z bazy
    private static final String TESTS = "cout << \"test\";";
    //bedzie potrzebne do pobrania testow
    //private Task task;

    //stawiam ze solution to metoda
    @Override
    public String complement(String solution) {
        return IMPORTS + String.format(CLASS_CORE, TESTS, solution);
    }

}
