package method;

public class MergeSortSelfTest {


    public void merge(int[] array, int begin, int mid, int end) {

        int[] temp = new int[array.length];
        //p1、p2是检测指针，k是存放指针
        int p1 = begin, p2 = mid + 1, k = begin;
        //指针不停右移
        while (p1 <= mid && p2 <= end) {
            if (array[p1] <= array[p2]) {
                temp[k++] = array[p1++];
            } else {
                temp[k++] = array[p2++];
            }
        }
        while (p1 <= mid) {
            temp[k++] = array[p1++];
        }
        while (p2 <= end) {
            temp[k++] = array[p2++];
        }

        for (int i = begin; i <= end; i++) {
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
