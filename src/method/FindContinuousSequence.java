package method;import java.util.ArrayList;public class FindContinuousSequence {    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();        for (int i = 0; i <= (sum / 2); i++) {            int j = i + 1, temp = 0;            while (temp <= sum) {                temp += j;                j++;            }            if (sum == temp) {                ArrayList<Integer> ans = new ArrayList<>();                for (int k = i; k <= j; ++k) {                    ans.add(k);                }                res.add(ans);            } else if (temp > sum) {                break;            }        }        return res;    }}