import method.FindGreatestSumOfSubArray;

public class Main {
    public static void main(String[] args) {
        FindGreatestSumOfSubArray test = new FindGreatestSumOfSubArray();
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        int res = test.FindGreatestSumOfSubArray(arr);
        System.out.println(res);
    }
}
