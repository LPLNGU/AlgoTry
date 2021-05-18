package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: 全排列
 * @Description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author: lpl
 * @date: 2021/5/18 18:44
 */
public class 全排列 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, List<Integer> route) {
        if (route.size() == nums.length) {
            res.add(new ArrayList<Integer>(route));
        }
        for (Integer n:nums) {
            if (route.contains(n)){
                continue;
            }
            route.add(n);
            backtrack(nums,route);
            route.remove(n);
        }
    }

}
