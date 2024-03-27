import java.util.ArrayList;
import java.util.List;

class PowerImpl {
    public static void main(String[] args) {

//        System.out.println(subset("", "123"));
        System.out.println(subsetsWithDup(new int[]{1,2,2,3}));
    }

    public static ArrayList subset(String Processed, String S) {
        ArrayList<String> answer = new ArrayList<>();
        if (S.isEmpty()) {
            answer.add(Processed);
            return answer;
        }
        answer.addAll(subset(Processed + S.charAt(0), S.substring(1)));
        answer.addAll(subset(Processed, S.substring(1)));
        return answer;
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        return subsetsWithDup(nums,0,new ArrayList<>());
    }

    public static List<List<Integer>> subsetsWithDupIteration(int[] numsr) {
        List<List<Integer>> outer = new ArrayList<>();


        return outer;
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums,int i,ArrayList<Integer> subAnswer) {
        List<List<Integer>> answer = new ArrayList<>();
        if(i>nums.length-1){
            answer.add(subAnswer);
            return answer;
        }
        ArrayList<Integer> subAnswer2 = new ArrayList<>();
        subAnswer2.addAll(subAnswer);
        subAnswer2.add(nums[i]);
        answer.addAll(subsetsWithDup(nums,i+1,subAnswer2));
        ArrayList<Integer> subAnswer1 = subAnswer;
        answer.addAll(subsetsWithDup(nums,i+1,subAnswer1));

        return answer;
    }

}