//package method;////import java.util.*;//////public class Vote {//    public static String compareString(String s1,String s2){//        if (s1.equals(s2)) {//            return s1;//        }//        int maxLength = s1.length();//        if (s2.length()<maxLength)//            maxLength = s2.length();//        for (int i=0;i<maxLength;i++){//            if (s1.charAt(i)>s2.charAt(i)){//                return s2;//            }else if (s1.charAt(i)<s2.charAt(i)){//                return s1;//            }else if (s1.charAt(i)==s2.charAt(i)){//                if (s1.length()<s2.length()){//                    return s1;//                }else {//                    return s2;//                }//            }//        }////        return null;//    }////    public static void main(String[] args) {//        Scanner in = new Scanner(System.in);//        String name = in.nextLine();//        StringTokenizer st = new StringTokenizer(name,",");//        List<String> names = new ArrayList<>();//        while (st.hasMoreTokens()){//            String s = st.nextToken();//            if (s.charAt(0)>=65&&s.charAt(0)<=90){//                names.add(s);//            }else {//                System.out.println("error.0001");//                return;//            }////        }//        if (names.size()>=100 || names.size()<=0){//            System.out.println("error.0001");//            return;//        }//        Map<String,Integer> data = new TreeMap<>();////        for(String s:names){//            if (!data.containsKey(s)){//                data.put(s,1);//            }else {//                Integer i = data.get(s);//                i++;//                data.put(s,i);//            }//        }//        Integer vote = 0,sig = 0;//        List<String> best = new ArrayList<>();//        for (Map.Entry<String, Integer> entry : data.entrySet()) {////            if(vote < entry.getValue()&&sig==0) {//                best.clear();//                vote = entry.getValue();//                best.add(entry.getKey());//                sig++;//            }else if (vote == entry.getValue()){//                best.add(entry.getKey());//            }else if (vote < entry.getValue()&&sig!=0){//                vote = entry.getValue();//                best.clear();//                best.add(entry.getKey());//                sig = 0;//            }//        }////        String str = best.get(0);//        for (String s:best){//            str = compareString(str,s);//        }//        System.out.println(str);////    }//}