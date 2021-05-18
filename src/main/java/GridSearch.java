import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GridSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();

        String currentLine;
        while (!(currentLine = bufferedReader.readLine()).equals("")){
            lines.add(currentLine);
        }

        int index = 0;
        int numberOfTestCases = Integer.parseInt(lines.get(0));
        for (int i = 0; i < numberOfTestCases; i++) {
            String[] rowAndColumnsGrid = lines.get(++index).split(" ");
            int NumberOfRowGrid = Integer.parseInt(rowAndColumnsGrid[0]);
            List<String> gridToSearch = new ArrayList<>();
            for (int j = 0; j < NumberOfRowGrid; j++) {
                gridToSearch.add(lines.get(++index));
            }
            String[] rowAndColumnsPatterns = lines.get(++index).split(" ");
            int NumberOfRowPatterns = Integer.parseInt(rowAndColumnsPatterns[0]);
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < NumberOfRowPatterns; j++) {
                patterns.add(lines.get(++index));
            }
            System.out.println(gridSearch(gridToSearch,patterns));
        }
    }


    public static String gridSearch(List<String> gridToSearch, List<String> patterns){
        int gridToSearchSize = gridToSearch.size();
        int patternsSize = patterns.size();
        for (int i = 0; i <= gridToSearchSize - patternsSize; i++) {
            int indexOfFirstOccurence = gridToSearch.get(i).indexOf(patterns.get(0));
            if(indexOfFirstOccurence == -1){
            } else {
                for (int j = 1; j < patternsSize; j++) {
                    String substring = gridToSearch.get(i+j).substring(indexOfFirstOccurence, indexOfFirstOccurence + patterns.get(j).length());
                    if(substring.equals(patterns.get(j))){
                        if(j == patternsSize - 1){
                            return "YES";
                        }
                    }else break;
                }
            }
        }
        return "NO";
    }
}
