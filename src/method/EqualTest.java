//package method;////import java.util.Arrays;//import java.util.List;////public class EqualTest {////        public static void main(String[] args) {//            List<Person> list = Arrays.asList(//                    new Person("Xiao", "Ming", 18),//                    new Person("Xiao", "Hong", 25),//                    new Person("Bob", "Smith", 20)//            );//            boolean exist = list.contains(new Person("Bob", "Smith", 20));//            System.out.println(exist ? "测试成功!" : "测试失败!");//        }//////////}//class Person {//    String firstName;//    String lastName;//    int age;//    public Person(String firstName, String lastName, int age) {//        this.firstName = firstName;//        this.lastName = lastName;//        this.age = age;//    }////    public boolean equals(Object o){//        if(o instanceof Person){//            Person p = (Person)o;//            return this.firstName.equals(p.firstName)&&this.lastName.equals(p.lastName)&&this.age==p.age;//        }//        return false;//    }//}