package zpi.algospace;

public class PythonComplementer implements Complementary {
    //nwm czy tu czy w enumach podmieni sie najwyzej
    private static final String IMPORTS = "import numpy as np\n";
    private static final String CLASS_CORE = "if __name__ == \"__main__\":\n\t%s\n\n%s";
    //chwilowo potem beda z bazy
    private static final String TESTS = "print(\"test\")";
    //private Task task;

    //stawiam ze solution to metoda
    @Override
    public String complement(String solution) {
        return IMPORTS + String.format(CLASS_CORE, TESTS, solution);
    }

}
