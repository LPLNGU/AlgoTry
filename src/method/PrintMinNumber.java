package method;

import java.util.*;

/*
*
* 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
* 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*
* */
public class PrintMinNumber {

    public static void main(String[] args) {

    }
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i:numbers){
            arrayList.add(i+"");
        }
        Collections.sort(arrayList, (Comparator<String>) (o1, o2) -> {
            return (o1+o2).compareTo(o2+o1);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: arrayList){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
