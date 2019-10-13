package 遍历文件.t1;


import java.io.File;

//遍历文件以及子文件
public class Test {

    public static void showDirectory(File file){
        File [] a = file.listFiles();

        try {
            for(File b : a){
                System.out.println(b);
                if(file.isDirectory()){
                    showDirectory(b);
                }
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        File file = new File("F:\\城市");
        showDirectory(file);


    }
}
