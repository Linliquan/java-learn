import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入数据：");

        InputStream in= System.in;

        for (int i = 0; i < 10; i++) {
            //当前可以读取多少字节
            int available = in.available();
            System.out.println("可以读取:"+available);
            int read  = in.read();
            //跳过n个字节
            in.skip(2);
            System.out.write(read);
        }
    }
}
