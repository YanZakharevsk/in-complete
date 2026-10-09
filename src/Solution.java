import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<List<Integer>> resultList = new ArrayList<>();
        int i = 0;
        int j = 0, currentMin = 0, currentMax = 0;
        while (true) {
            if(i >= firstList.length || j >= secondList.length) break;
            if(firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1] ||
                secondList[j][0] >= firstList[i][0] && secondList[j][0] <= firstList[i][1]){

                currentMin = Math.max(firstList[i][0], secondList[j][0]);
                currentMax = Math.min(firstList[i][1], secondList[j][1]);

                resultList.add(List.of(currentMin, currentMax));

                if(firstList[i][1] <= secondList[j][1]) i++;
                else j++;
            }
            else if(firstList[i][0] > secondList[j][1]) j++;
            else if(secondList[j][0] > firstList[i][1]) i++;
        }
        int[][] result;
        if(!resultList.isEmpty()){
        result = new int[resultList.size()][resultList.getFirst().size()];
        }
        else return new int[0][0];
        i = 0;
        for(List<Integer> bamp : resultList){
            result[i][0] = bamp.getFirst();
            result[i++][1] = bamp.getLast();
        }
        return result;
    }
}