package Queue;

import java.util.ArrayList;

public class MyQueue {
    public ArrayList list;

    public MyQueue(){
        list = new ArrayList();
    }

    public void in(Object obj){
        list.add(obj);
    }

    public Object out(){
        if (list.size() > 0){
            return list.remove(0);
        }else {
            return null;
        }
    }
}
