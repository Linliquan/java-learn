package day15;//import java.util.*;
//
//public class Test {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//
//        int len = str.length();
//        ArrayList list = new ArrayList();
//
//        for (int i = 0; i < len; i++) {
//            String c = str.substring(i,i+1);
//            for (int j = 0; j < 10; j++) {
//                String s = Integer.toString(j);
//                if(c.equals(s)){
//                   list.add(c);
//                   continue;
//                }
//            }
//
//        }
//
//        Collections.sort(list);
//        if(list.isEmpty()){
//            System.out.println(-1);
//        }else {
//            for(Object s : list){
//                System.out.print(s);
//            }
//        }
//    }
//}
