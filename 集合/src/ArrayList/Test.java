package ArrayList;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList();

        list.add("aa");
        list.add("bb");
        list.add("cc");

        list.remove(2);
        list.set(1,"kk"); //修改数据

        //法一输出：
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }

        //法二：
        for(Iterator iterator = list.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
        //法三
        for(String str : list){
            System.out.println(str);
        }
    }
}
