
import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {

        //案例:读取txt文件的内容
        //1.创建一个文件对象
        File file = new File("a.txt");
        System.out.println(file.getCanonicalPath());
        file.createNewFile();



        //创建一个文件输入流的对象（读取文件数据）
        FileInputStream fis1 = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis1);

        while (isr.ready()){
            System.out.println(isr.read());
        }

        FileInputStream fis2 = new FileInputStream("b.txt");

        //3.读取a.txt的数据
        /**
         * 1.read方法每次读文件1个字节(byte),把byte转成int返回
         * 2.当读到后的时候，返回-1，-1读取文件结束
         */

        while (fis1.read()!=-1){
            System.out.println(fis1.read());
        }

//        System.out.println(fis1.read());
//        System.out.println(fis1.read());
//        System.out.println(fis1.read());

        //关闭流
        fis1.close();
        fis2.close();

        OutputStream fos = new FileOutputStream("b.txt");
        fos.write(97);
        fos.write(98);
        byte []  b = {97,98,99};
        fos.write(b);
        fos.close();


    }
}
