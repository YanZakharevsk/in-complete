import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        // Input: s = "ababcbacadefegdehijhklij"

        int theLastSymbol = -1;
        while (theLastSymbol <  s.length() - 1) {
            int prevLast = theLastSymbol;
            theLastSymbol = s.lastIndexOf(s.charAt(theLastSymbol + 1));
            int numberOfSymbols = theLastSymbol + 1;
            result.add(numberOfSymbols);

            for (int i = prevLast + 1; i < theLastSymbol; i++) {
                int symbol = s.lastIndexOf(s.charAt(i));
                if (symbol > theLastSymbol){
                    theLastSymbol = symbol;
                    result.set(result.indexOf(result.getLast()), theLastSymbol + 1);
                }
            }

        }

        if(result.size() <= 1) return result;
        int sum = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            result.set(i, result.get(i) - sum);
            sum += result.get(i);
        }

        return result;
    }
}

