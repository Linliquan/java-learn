import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/

    static ListNode partition(ListNode head, int m) {
        ListNode node1 = new ListNode(-2);
        ListNode node2 = new ListNode(-2);
        ListNode list1 = node1;
        ListNode list2 = node2;
        ListNode listNode = head;
        while (listNode != null) {
            if (listNode.val < m) {
                list1.next = listNode;
                list1 = list1.next;
            } else {
                list2.next = listNode;
                list2 = list2.next;
            }
            listNode = listNode.next;
        }
        if (node1.next == null) {
            return head;
        } else {
            list1.next = node2.next;
            return node1.next;
        }
    }


//    static ListNode partition(ListNode head, int m) {
//        ListNode dummy1 = new ListNode(-1);
//        ListNode dummy2 = new ListNode(-1);
//        ListNode p1 = dummy1;
//        ListNode p2 = dummy2;
//        ListNode p = head;
//        while (p != null) {
//            if (p.val < m) {
//                p1.next = p;
//                p1 = p1.next;
//            } else {
//                p2.next = p;
//                p2 = p2.next;
//            }
//            p = p.next;
//        }
//        if (dummy1.next == null) {
//            return head;
//        } else {
//            p1.next = dummy2.next;
//            p2.next = null;
//            return dummy1.next;
//        }
//    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
