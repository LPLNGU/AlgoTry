//package control;
//
//public class ComputeIfAbsent {
//    //如果v已经计算好了，那么适合使用putIfAbsent(k, v)，如果v还未计算，同时计算需要一些耗时,那么建议使用computeIfAbsent，将获取v值的计算放到lambada表达式体内，这样只有再map不含有k对应值时才会进行获取v值的计算，可以优化性能
//    public class MapInfo {
//
//        public static void computeIfAbsent(){ // jdk1.8新特性哦
//            HashMap<String> map = new HashMap&lt;>();
//            map.put("1","is map");
//            map.put("2","contains a mapping");
//            map.put("3","specified");
//            map.put("4","inappropriate");
//            map.computeIfAbsent("5", MapInfo::apply);
//            System.out.println(map.get("5"));
//        }
//
//        private static Object apply(String v) {
//            return v = "is 5";
//        }
//    }
//}
