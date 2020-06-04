////import java.util.ArrayList;
////import java.util.List;
////
//package control;
//////
////public class Main {
////    public static void main(String[] args) {
////        Person ming = new Person("Xiao Ming", 12);
////        Person hong = new Person("Xiao Hong", 15);
////        ming.number = 88;
////        System.out.println(hong.number);
////        hong.number = 99;
////        System.out.println(ming.number);
////        List l = new ArrayList();
////    }
////}
////
////class Person {
////    public String name;
////    public int age;
////
////    public static int number;
////
////    public Person(String name, int age) {
////        this.name = name;
////        this.age = age;
////    }
////
//import java.util.*;
//public class Main {
//    static List<Integer> l = new ArrayList<>();
//    public static int cal(int n,int m,int a,int b){
//        int beated=0;
//        int count = a;
//        while(n>0){
//            n--;
//            if(m>=b){
//                if(count==0){
//                    m-=b;
//                    beated+=b;
//                    continue;
//                }
//                count--;
//            }else if(m<b){
//                if(count==0){
//                    beated+=m;
//                    continue;
//                }
//            }
//        }
//        return beated;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        if (in.next().equals('\n')) {
//            while (t != 0) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//                t--;
//                int n = in.nextInt();
//                int m = in.nextInt();
//                int a = in.nextInt();
//                int b = in.nextInt();
//                l.add(cal(n, m, a, b));
//            }
//            for (int i : l) {
//                System.out.println(i);
//            }
//        }
//    }
//}
