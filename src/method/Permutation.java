package method;import java.util.ArrayList;import java.util.Set;import java.util.TreeSet;public class Permutation {    public static void main(String[] args) {        String s = "abc";        System.out.println(Permutation(s));    }    static Set<String> strings = new TreeSet<>();    public static ArrayList<String> Permutation(String str) {        if (str.length() < 1) {            return new ArrayList<String>();        }        ArrayList<Character> characters = new ArrayList<>();        helpPer(characters, str, 0);        ArrayList<String> result = new ArrayList<>(strings);        return result;    }    public static void helpPer(ArrayList<Character> chars, String str, int i) {        if (chars.size() == str.length()) {            String s = "";            for (Character character : chars) {                s += character;            }            strings.add(s);            return;        }        for (int j = i; j < str.length(); j++) {            chars.add(str.charAt(j));            helpPer(chars, str, j + 1);            chars.remove(j);        }    }}