package method;


import java.util.ArrayList;
import java.util.Arrays;

/*
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 *  习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * */
public class GetUglyNumber_Solution {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(7));

    }

    public static int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        int n2 = 0, n3 = 0, n5 = 0;
        for (int i = 1; i < index; i++) {

            int min = Math.min(res.get(n2) * 2, Math.min(res.get(n3) * 3, res.get(n5) * 5));
            res.add(min);
            if (res.get(i) == res.get(n2) * 2) {
                n2++;
            }
            if (res.get(i) == res.get(n3) * 3) {
                n3++;
            }
            if (res.get(i) == res.get(n5) * 5) {
                n5++;
            }
        }
        return res.get(res.size() - 1);
    }
}
