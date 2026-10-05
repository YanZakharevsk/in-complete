import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int [][] intervals = { {1,2},{3,5}, {6,7},{8,10},{12,16}};
        //int [] newInterval = {4,8};

        int [][] intervals = {{1,3},{6,9}};
        int [] newInterval = {2,5};

        List<List<Integer>> result = solution.insert(intervals, newInterval );

        for(List<Integer> a : result){
            System.out.print(a.getFirst() + " ");
            System.out.println(a.getLast());
        }
    }
}
