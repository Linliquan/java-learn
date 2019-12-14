package t1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {

        /**
         * 反射练习
         */
        //1.获得Class引用
        Class<Student> s = Student.class;

        //2.获得Student的属性
        //获得非私有属性
        Field [] f = s.getFields();

        //获得私有属性
        Field [] fields = s.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
           Field field = fields[i];
            System.out.println(field.getName());
        }

        //3.获得所有的方法
        Method [] methods = s.getMethods();
        for (int i = 0; i <methods.length ; i++) {
            Method method = methods[i];
            System.out.println(method.getName());
        }

        //
      Method method =  s.getMethod("show",int.class);

        //反射创建对象
        Student student = s.newInstance();
        Object invole = method.invoke(student,30);
        System.out.println(invole);



    }
}
