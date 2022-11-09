package zpi.algospace.syntax;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;

public class CleaningErrorMessageUtils {
    public static void findAllLineNumberOccurrences(String error, String stringToFind, ArrayList<Pair<Integer, Integer>> allFileNameOccurrences) {
        int startingIndex = error.indexOf(stringToFind);
        while (startingIndex >= 0) {
            int endingIndex = error.indexOf(":", startingIndex + stringToFind.length());
            allFileNameOccurrences.add(Pair.of(startingIndex + stringToFind.length(), endingIndex));
            startingIndex = error.indexOf(stringToFind, endingIndex + 1);
        }
    }

    public static String correctLineNumbers(String error, ArrayList<Pair<Integer, Integer>> allFileNameOccurrences, int linesAddedByCode) {
        if (allFileNameOccurrences.isEmpty()){
            return error;
        }

        StringBuilder result = new StringBuilder();
        int beginIndex = 0;
        for (Pair<Integer, Integer> range: allFileNameOccurrences) {
            int actualLineNumber = Integer.parseInt(error.substring(range.getLeft(), range.getRight()));
            actualLineNumber -= linesAddedByCode;
            result.append(error, beginIndex, range.getLeft()).append(actualLineNumber);
            beginIndex = range.getRight();
        }
        result.append(error.substring(beginIndex));

        return result.toString();
    }
}
