//package 函数式接口;
//
//public class O7 {
//    public void todo(IT7 t){
//        System.out.println("重要操作1");
//        System.out.println("重要操作2");
//        t.show();
//    }
//
//    public static void main(String[] args) {
//        O7 o = new O7();
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
//        IT7 t1 = () -> {
//            System.out.println("哈哈哈");
//        };
//        o.todo(t1);
//    }
//}
