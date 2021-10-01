package method;

import jdk.nashorn.internal.ir.IfNode;

import java.util.HashMap;
import java.util.List;

/**
 * @className: 旅行终点站1436
 * @Description: DONE
 * @author: lpl
 * @date: 2021/10/1 上午10:56
 */
public class 旅行终点站1436 {

    public String destCity(List<List<String>> paths) {
        if (paths == null || paths.isEmpty()) {
            return "";
        }
        HashMap<String, String> map = new HashMap<>();

        paths.forEach((list) -> {
            if (list.size() != 2) {
                return;
            }
            map.put(list.get(0), list.get(1));
        });
        String res = paths.get(0).get(0);
        while (map.get(res) != null){
            res = map.get(res);
        }
        return res;
    }
}
