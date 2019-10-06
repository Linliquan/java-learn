package Stack;

import java.util.ArrayList;

//FILO
public class MyStack {

    public ArrayList list;

    public MyStack(){
        list = new ArrayList();
    }

    public void push(Object obj){
        list.add(obj);
    }

    public Object pop(){
        if (list.size() > 0){
            return list.remove(list.size()-1);
        }else {
            return null;
        }
    }



    public static void main(String[] args) {

    }
}
