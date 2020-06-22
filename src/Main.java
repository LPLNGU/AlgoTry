import method.FindGreatestSumOfSubArray;
import method.MergeSortSelfTest;

public class Main {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 50};
        MergeSortSelfTest mergeSortSelfTest = new MergeSortSelfTest();
        mergeSortSelfTest.mergeSort(arr, 0, arr.length - 1);
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
}
