package method;import java.util.LinkedList;import java.util.Queue;public class ArrayOrder {    public void reOrderArray(int [] array) throws Exception{        Queue<Integer> q1 = new LinkedList<>();        Queue<Integer> q2 = new LinkedList<>();        for(int i:array){            //如果是奇数存入q1            if((i&1)==1){                q1.offer(i);            }else{                q2.offer(i);            }        }        for(int i = 0;i<array.length;i++){            if(q1.size()!=0){                array[i]=q1.remove();            }else{                array[i] = q2.remove();            }        }    }}