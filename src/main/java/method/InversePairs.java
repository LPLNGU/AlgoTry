package method;

import java.util.ArrayList;

/**
 * 数组中的逆序对：
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    int num = 0;

//    public int InversePairs(int[] array) {
//
//    }

    public void merge(int[] array, int begin, int mid, int end) {
        int p1 = begin, p2 = mid + 1, k = begin;
        int[] temp = new int[array.length];
        while (p1 <= mid && p2 <= end) {
            if (array[p1] <= array[p2]) {
                temp[k++] = array[p1++];
            } else {
                temp[k++] = array[p2++];
                num += mid - p1 + 1;
            }
            while (p1 <= mid) {
                temp[k++] = array[p1++];
            }
            while (p2 <= mid) {
                temp[k++] = array[p2++];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }

    public void mergeSort(int[] array, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) >> 1;
            mergeSort(array, begin, mid);
            mergeSort(array, mid + 1, end);
            merge(array, begin, mid, end);
        }
    }
}
