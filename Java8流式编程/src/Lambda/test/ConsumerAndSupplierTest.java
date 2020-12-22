package Lambda.test;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author linliquan
 * @description:
 * @create 2020/12/21 16:58
 */
public class ConsumerAndSupplierTest {
    public static void main(String[] args) {

        /**
         * 1.consumer接口，就是一个消费型的接口，通过传入参数，然后输出值。如 forEach
         */
        //① 使用consumer接口实现方法
        Consumer<String> consumer = new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        stream.forEach(consumer);

        System.out.println("********************");

        //② 使用lambda表达式，forEach方法需要的就是一个Consumer接口
        stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        Consumer<String> consumer1 = (s) -> System.out.println(s);//lambda表达式返回的就是一个Consumer接口
        stream.forEach(consumer1);
        //更直接的方式
        //stream.forEach((s) -> System.out.println(s));
        System.out.println("********************");

        //③ 使用方法引用，方法引用也是一个consumer
        stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
        Consumer consumer2 = System.out::println;
        stream.forEach(consumer);
        //更直接的方式
        //stream.forEach(System.out::println);

        /**
         * 2.Supplier接口，supplier相当一个容器或者变量，可以存储值。如：
         */
        //① 使用Supplier接口实现方法,只有一个get方法，无参数，返回一个值
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //返回一个随机值
                return new Random().nextInt();
            }
        };

        System.out.println(supplier.get());

        System.out.println("********************");

        //② 使用lambda表达式，
        supplier = () -> new Random().nextInt();
        System.out.println(supplier.get());
        System.out.println("********************");

        //③ 使用方法引用
        Supplier<Double> supplier2 = Math::random;
        System.out.println(supplier2.get());

        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        //返回一个optional对象
        Optional<Integer> first = stream2.filter(i -> i > 4)
                .findFirst();

        //optional对象有需要Supplier接口的方法
        //orElse，如果first中存在数，就返回这个数，如果不存在，就返回传入的数
        System.out.println();
        System.out.println(first.orElse(1));
        System.out.println(first.orElse(7));

        System.out.println("********************");

        Supplier<Integer> supplier3 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //返回一个随机值
                return new Random().nextInt();
            }
        };

        //orElseGet，如果first中存在数，就返回这个数，如果不存在，就返回supplier返回的值
        System.out.println(first.orElseGet(supplier3));

        /**
         * 3.Predicate 接口，是一个谓词型接口，其实，这个就是一个类似于 bool 类型的判断的接口。如：filter
         */
        //① 使用Predicate接口实现方法,只有一个test方法，传入一个参数，返回一个bool值
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer > 5){
                    return true;
                }
                return false;
            }
        };

        System.out.println(predicate.test(6));

        System.out.println("********************");

        //② 使用lambda表达式，
        predicate = (t) -> t > 5;
        System.out.println(predicate.test(1));
        System.out.println("********************");

        /**
         * 4.Function 接口,function的作用是转换，将一个值转为另外一个值。如：map
         */
        //① 使用map方法，泛型的第一个参数是转换前的类型，第二个是转化后的类型
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();//获取每个字符串的长度，并且返回
            }
        };

        Stream<String> funStream = Stream.of("aaa", "bbbbb", "ccccccv");
        Stream<Integer> stream1 = funStream.map(function);
        stream1.forEach(System.out::println);

        System.out.println("********************");

    }
}
