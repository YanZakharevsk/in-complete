class Solution {
    public String countAndSay(int n) {
        StringBuffer result = new StringBuffer();
        result.append(1);
        for (int i = 1; i <= n; i++) {
            StringBuffer buffer = new StringBuffer(result);
            result = (parseSymbols(buffer));
            if(i == 1) result.deleteCharAt(0);
        }
        return result.toString();
    }
    //  1 1 2 1
    public StringBuffer parseSymbols(StringBuffer partial){
        StringBuffer partialResult = new StringBuffer();

        int numberOfTheSameSymbols = 1;
        for (int i = 0; i < partial.length(); i++) {
            if(i+1 != partial.length() && partial.charAt(i) == partial.charAt(i + 1)){
                numberOfTheSameSymbols++;
            }
            else{
                partialResult.append(numberOfTheSameSymbols);
                partialResult.append(partial.charAt(i));
                numberOfTheSameSymbols = 1;
            }
        }
        return partialResult;
    }
}