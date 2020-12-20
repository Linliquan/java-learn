//package 函数式编程2;
//
//import 函数式接口.IT7;
//
//public class O8 {
//    public void todo(IT8 t){
//        System.out.println("重要操作1");
//        System.out.println("重要操作2");
//        t.show(10);
//    }
//
//    public static void main(String[] args) {
//        O8 o = new O8();
//
////        //原始实现方法
////       IT7 t = new IT7(){
////            @Override
////            public void show() {
////                System.out.println("重要操作");
////            }
////        };
//
//        //（）要和函数式接口中的抽象方法的参数一致
////        IT8 t1 = () -> {
////            System.out.println("哈哈哈");
////            return 4;
////        };
//        IT8 t2 = ( age) -> {
//            System.out.println(++age);age++; };
//        o.todo(t2);
//        o.todo(a ->{a++;} );
//    }
//}
//
//
