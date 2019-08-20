import java.io.File;
import java.io.IOException;

public class File1 {
    public static void main(String[] args) throws IOException {

        File f2 = new File("f2.txt");
        f2.createNewFile();
        /**
         * 可以删除文件和空文件夹，可以删除用户没有权限的文件
         */
        boolean delete = f2.delete();
        System.out.println(delete);

        //获取当前文件的执行路径
        File f5 = new File(Test.class.getResource("").getPath());
        System.out.println(f5.getCanonicalPath());

        //

        File f6 = new File("/");
        System.out.println(f6.getCanonicalPath());

//        File f1 = new File("a.txt");
//        boolean newFile = f1.createNewFile();
//        System.out.println(newFile);
    }
}
