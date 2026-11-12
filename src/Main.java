import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result = solution.partitionLabels("caedbdedda");
        for(int value: result){
            System.out.println(value);
        }
    }
}
