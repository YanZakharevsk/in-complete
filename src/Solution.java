import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> resultIntervals = new ArrayList<>();

        // Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
       // Output: [[1,5],[6,9]]

        //Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        //Output: [[1,2],[3,10],[12,16]]
        int startIndex = 0, finishIndex = intervals.length - 1;
        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[0] < intervals[i][0]) {
                startIndex = --i;
                break;
            }
        }
        for (int i = intervals.length - 1; i >= 0 ; i--) {
            if(newInterval[1] > intervals[i][1]) {
                finishIndex = ++i;
                break;
            }
        }
        List<Integer> mergingElement = new ArrayList<>();
        if(intervals[startIndex][0] < newInterval[0] && newInterval[0] <= intervals[startIndex][1]) mergingElement.add(intervals[startIndex][0]);
        else if(newInterval[0] <= intervals[startIndex][1]) mergingElement.add(newInterval[0]);

        if(intervals[finishIndex][1] > newInterval[1] && newInterval[1] >= intervals[finishIndex][0]) mergingElement.add(intervals[finishIndex][1]);
        else if(newInterval[1] >= intervals[finishIndex][0]) mergingElement.add(newInterval[1]);


        for (int i = 0; i < startIndex; i++) {
            resultIntervals.add(List.of(intervals[i][0], intervals[i][1]));
        }

        resultIntervals.add(mergingElement);
        finishIndex++;
        for (int i = finishIndex; i < intervals.length; i++) {
            resultIntervals.add(List.of(intervals[finishIndex][0], intervals[finishIndex++][1]));
        }
        return resultIntervals;
    }
}