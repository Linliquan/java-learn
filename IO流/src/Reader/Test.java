package Reader;

import java.io.*;

//按字符读取a.txt里面的内容
public class Test {
    public static void main(String[] args)  {

        //1.创建文件对象
        File file = new File("a.txt");

        //2.创建字符输入流
        Reader reader = null;

        try {
            reader = new FileReader(file);

            int a = reader.read();

            //3.循环读取，打印
            while (a != -1){
                System.out.print((char) a);
                a = reader.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //4.关闭流
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
