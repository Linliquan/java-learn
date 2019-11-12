
package publictest;

public class Otest {
/**
    二维数组中的查找

    题目：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


    public class Solution {
        public boolean Find(int target, int [][] array) {
            int row = array.length;
            int col = array[0].length;
            int j = 0;
            while(row > 0 && j < col){
                int b = array[row-1][j];
                if(target > b){
                    j++;
                }else if(target < b){
                    row--;
                }else{
                    return true;
                }
            }
            return false;

        }
    }
    复制代码


            替换空格

    题目描述
    请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    public class Solution {
        public String replaceSpace(StringBuffer str) {
            return str.toString().replaceAll(" ","%20");
        }
    }




    从尾到头打印链表

    输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

    复制代码
*/
/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 *//*

import java.util.*;
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> list = new ArrayList<>();
            if(listNode == null){
                return list;
            }
            Stack<Integer> stack = new Stack<>();

            while(listNode != null){
                //栈用push()，队列用add()
                stack.push(listNode.val);
                listNode = listNode.next;
            }
            while(!stack.empty()){
                list.add(stack.pop());
            }
            return list;
        }
    }
    复制代码


            重建二叉树

    输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

    复制代码
 1 */
/**
  2  * Definition for binary tree
  3  * public class TreeNode {
  4  *     int val;
  5  *     TreeNode left;
  6  *     TreeNode right;
  7  *     TreeNode(int x) { val = x; }
  8  * }
  9  *//*

         10 import java.util.*;
11 public class Solution {
12     public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            13         if(pre.length == 0 || in.length == 0){
                14             return null;
                15         }
            16         TreeNode node = new TreeNode(pre[0]);
            17
            18         for(int i = 0; i < pre.length; i++){
                19             if(pre[0] == in[i]){
                    20                 node.left = this.reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                    21
                    22                   // node.rigth = this.reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                    23                    node.right = this.reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                    24
                    25             }
                26         }
            27        return node;
            28     }
29 }
    复制代码




            用两个栈实现队列

    用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

    复制代码
import java.util.Stack;

    public class Solution {

        //中间栈，存储数据
        Stack<Integer> stack1 = new Stack<Integer>();
        //入栈和出栈操作
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node){
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
            stack2.push(node);
        }

        public int pop(){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

    }
    复制代码


            旋转数组的最小数字

    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

    复制代码
 1 import java.util.ArrayList;
 2 import java.util.Arrays;
 3 public class Solution {
 4     public int minNumberInRotateArray(int [] array) {
            5         if (array.length == 0){
                6             return 0;
                7         }
            8         int left = 0;
            9         int right = array.length - 1;
            10         int middle = 0;
            11         while (array[left]>=array[right]) {
                12             //数组长度等于2时
                13             if(right-left==1){
                    14                 middle = right;
                    15                 break;
                    16             }
                17             middle = left + (right - left) / 2;
                18             if (array[middle] >= array[left]) {
                    19                 left = middle;
                    20             }
                21             if (array[middle] <= array[right]) {
                    22                 right = middle;
                    23             }
                24         }
            25         return array[middle];
            26     }
27 }
    复制代码




            斐波那契数列

    大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。

    n<=39

    复制代码
    public class Solution {
        public int Fibonacci(int n) {
            if(n <= 0){
                return 0;
            }else if(n == 1){
                return 1;
            }else if(n == 2){
                return 1;
            }else{
                return Fibonacci(n-1)+Fibonacci(n-2);
            }
        }
    }
    复制代码




            跳台阶

    一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

    复制代码
    public class Solution {
        public int JumpFloor(int target) {
            if(target <= 0){
                return 0;
            }else if(target == 1){
                return 1;
            }else if(target == 2){
                return 2;
            }else{
                return JumpFloor(target-1)+JumpFloor(target-2);
            }
        }
    }
    复制代码




            变态跳台阶

    一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

    复制代码
    public class Solution {
        public int JumpFloorII(int target) {
            if(target <= 2){
                return target;
            }else{
                return 2*JumpFloorII(target-1);
            }
        }
    }
    复制代码




            矩形覆盖

    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

    复制代码
1 public class Solution {
2     public int RectCover(int target) {
            3         if(target <= 3){
                4             return target;
                5         }else{
                6             return RectCover(target -1) + RectCover(target -2);
                7         }
            8     }
9 }
    复制代码




            二进制中1的个数

    输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

    复制代码
    public class Solution {
        public int NumberOf1(int n) {
            String str = Integer.toBinaryString(n);

            int count = 0;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '1'){
                    count++;
                }
            }
            return count;
        }
    }
    复制代码




            链表中倒数第k个结点

    输入一个链表，输出该链表中倒数第k个结点。

    复制代码
 1 */
/*
 2 public class ListNode {
 3     int val;
 4     ListNode next = null;
 5
 6     ListNode(int val) {
 7         this.val = val;
 8     }
 9 }*//*

         10 import java.util.*;
11 public class Solution {
12     public ListNode FindKthToTail(ListNode head,int k) {
            13         if(head == null){
                14             return head;
                15         }
            16         Stack<ListNode> stack = new Stack<>();
            17         while(head != null){
                18             stack.push(head);
                19             head = head.next;
                20         }
            21         int count = 0;
            22         ListNode node = null;
            23         while(!stack.empty()){
                24             count++;
                25             if(count == k){
                    26                 //找到第k个节点，出栈
                    27                 node = stack.pop();
                    28             }else{
                    29                 //没找到也出栈
                    30                  stack.pop();
                    31             }
                32         }
            33         //当k大于链表长度时，node为null,不用额外判断
            34         return node;
            35     }
36 }
    复制代码




            反转链表

    输入一个链表，反转链表后，输出新链表的表头。

    复制代码
 1 */
/*
 2 public class ListNode {
 3     int val;
 4     ListNode next = null;
 5
 6     ListNode(int val) {
 7         this.val = val;
 8     }
 9 }*//*

         10 public class Solution {
11     public ListNode ReverseList(ListNode head) {
            12         if(head == null || head.next == null){
                13             return head;
                14         }
            15         ListNode node1 = null;
            16         ListNode node2 = null;
            17         while(head != null){
                18             node1 = head.next;
                19             head.next = node2;
                20             node2 = head;
                21             head = node1;
                22         }
            23         return node2;
            24
            25     }
26 }
    复制代码




            合并两个有序的链表

    输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

    复制代码
 1 */
/*
 2 public class ListNode {
 3     int val;
 4     ListNode next = null;
 5
 6     ListNode(int val) {
 7         this.val = val;
 8     }
 9 }*//*

         10 public class Solution {
11     public ListNode Merge(ListNode list1,ListNode list2) {
            12         if(list1 == null){
                13             return list2;
                14         }
            15         if(list2 == null){
                16             return list1;
                17         }
            18         if(list1.val < list2.val){
                19             list1.next = Merge(list1.next,list2);
                20             return list1;
                21         }else{
                22             list2.next = Merge(list1,list2.next);
                23             return list2;
                24         }
            25     }
26 }
    复制代码


            二叉树的镜像

    操作给定的二叉树，将其变换为源二叉树的镜像。









    复制代码
 1 */
/**
  2 public class TreeNode {
  3     int val = 0;
  4     TreeNode left = null;
  5     TreeNode right = null;
  6
  7     public TreeNode(int val) {
  8         this.val = val;
  9
  10     }
  11
  12 }
  13 *//*

         14 public class Solution {
15     public void Mirror(TreeNode root) {
            16         TreeNode temp = null;
            17
            18         if(root != null){
                19             temp = root.left;
                20             root.left = root.right;
                21             root.right = temp;
                22
                23             if(root.left != null){
                    24                 this.Mirror(root.left);
                    25             }
                26             if(root.right != null){
                    27                 this.Mirror(root.right);
                    28             }
                29         }
            30
            31     }
32 }
    复制代码


            包含min函数的栈

    定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

    复制代码
 1 import java.util.Stack;
 2
         3 public class Solution {
 4     Stack<Integer> dataStack = new Stack<>();
 5     Stack<Integer> minStack = new Stack<>();
 6
         7     public void push(int node) {
            8         dataStack.push(node);
            9         if(minStack.empty() || node < minStack.peek()){
                10             minStack.push(node);
                11         }else{
                12             minStack.push(minStack.peek());
                13         }
            14     }
15
        16     public void pop() {
            17         dataStack.pop();
            18         minStack.pop();
            19     }
20
        21     public int top() {
            22         return dataStack.peek();
            23     }
24
        25     public int min() {
            26         return minStack.peek();
            27     }
28 }
    复制代码


    栈的压入、弹出顺序

    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

    复制代码
 1 import java.util.*;
 2
         3 public class Solution {
 4     public boolean IsPopOrder(int [] pushA,int [] popA) {
            5       if(pushA.length == 0 || popA.length == 0){
                6           return false;
                7       }
            8
            9       Stack<Integer> stack = new Stack<>();
            10
            11       int index = 0;
            12       for(int i = 0; i < pushA.length; i++){
                13           stack.push(pushA[i]);
                14           //for循环到第五遍时，while会一直循环判断栈顶元素是否等于出栈数组
                15           while(!stack.empty() && stack.peek() == popA[index]){
                    16               //出栈
                    17               stack.pop();
                    18               //出栈标记向后移一位
                    19               index++;
                    20           }
                21       }
            22       //如果为空，则返回true
            23       return stack.empty();
            24     }
25 }
    复制代码


            从上往下打印二叉树

    从上往下打印出二叉树的每个节点，同层节点从左至右打印。

    复制代码
 1 import java.util.*;;
 2 */
/**
  3 public class TreeNode {
  4     int val = 0;
  5     TreeNode left = null;
  6     TreeNode right = null;
  7
  8     public TreeNode(int val) {
  9         this.val = val;
  10
  11     }
  12
  13 }
  14 *//*

         15 public class Solution {
16     public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            17         ArrayList<Integer> list = new ArrayList<>();
            18         if(root == null){
                19             return list;
                20         }
            21         //层次打印二叉树，使用队列，统计字符个数也使用队列
            22         Queue<TreeNode> queue = new LinkedList<>();
            23         queue.add(root);
            24
            25         while(queue.size() != 0){
                26             TreeNode node = queue.poll();
                27             list.add(node.val);
                28             if(node.left != null){
                    29                 queue.add(node.left);
                    30             }
                31              if(node.right != null){
                    32                 queue.add(node.right);
                    33             }
                34         }
            35         return list;
            36     }
37 }
    复制代码


            二叉搜索树的后序遍历序列

    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

    复制代码
 1 public class Solution {
 2     public boolean VerifySquenceOfBST(int [] sequence) {
            3         if(sequence.length == 0) return false;
            4         return IsTreeBST(sequence, 0, sequence.length-1);
            5     }
 6     public boolean IsTreeBST(int [] sequence,int start,int end ){
            7         if(end <= start) return true;
            8         int i = start;
            9         for (; i < end; i++) {
                10             if(sequence[i] > sequence[end]) break;
                11         }
            12         for (int j = i; j < end; j++) {
                13             if(sequence[j] < sequence[end]) return false;
                14         }
            15         return IsTreeBST(sequence, start, i-1) && IsTreeBST(sequence, i, end-1);
            16     }
17 }
    复制代码


            数组中出现次数超过一半的数字

    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

    复制代码
 1 import java.util.*;
 2 public class Solution {
 3     public int MoreThanHalfNum_Solution(int [] array) {
            4        if(array.length == 1){
                5            return array[0];
                6        }
            7        int count = 1,max = 0;
            8        int [] a = new int [1];
            9        for(int i = 0; i < array.length; i++){
                10            for(int j = i+1; j < array.length; j++){
                    11                if(array[i] == array[j]){
                        12                    count++;
                        13                }
                    14            }
                15            if(count > max){
                    16                max = count;
                    17                a[0] = array[i];
                    18            }
                19            count = 1;
                20        }
            21
            22        if(max > array.length/2){
                23            return a[0];
                24        }else{
                25            return 0;
                26        }
            27     }
28 }
    复制代码


            最小的K个数

    输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

    复制代码
 1 import java.util.*;
 2 public class Solution {
 3     public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
            4         ArrayList<Integer> list = new ArrayList<>();
            5         if(k > input.length){
                6             return list;
                7         }
            8         Arrays.sort(input);
            9         for(int i = 0; i < k; i++){
                10             list.add(input[i]);
                11         }
            12         return list;
            13     }
14 }
    复制代码


            连续子数组的最大和

    HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)

    复制代码
 1 public class Solution {
 2     public int FindGreatestSumOfSubArray(int[] array) {
            3         if(array.length == 0){
                4             return 0;
                5         }
            6         int sum = 0;
            7         //不能等于0，存在负数
            8         int max = array[0];
            9         for(int i=0; i < array.length; i++){
                10             if(sum >= 0){
                    11                 sum = sum+array[i];
                    12             }else{
                    13                 //抛弃,重新计算
                    14                 sum = array[i];
                    15             }
                16             if(sum > max){
                    17                 max = sum;
                    18             }
                19         }
            20         return max;
            21     }
22 }
    复制代码




            把数组排成最小的数

    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

    复制代码
 1 import java.util.ArrayList;
 2
         3 public class Solution {
 4     public String PrintMinNumber(int [] numbers) {
            5         String str = "";
            6         for(int i = 0; i < numbers.length; i++){
                7             for(int j = i+1; j < numbers.length; j++){
                    8                 int a = Integer.parseInt(numbers[i]+""+numbers[j]);
                    9                 int b = Integer.parseInt(numbers[j]+""+numbers[i]);
                    10                 if(a > b){
                        11                     int t = numbers[i];
                        12                     numbers[i] = numbers[j];
                        13                     numbers[j] = t;
                        14                 }
                    15             }
                16         }
            17         for(int i = 0; i < numbers.length; i++){
                18             str = str + numbers[i];
                19         }
            20         return str;
            21     }
22 }
    复制代码


            第一个只出现一次的字符

    在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.

    复制代码
 1 import java.util.*;
 2 public class Solution {
 3     public int FirstNotRepeatingChar(String str) {
            4         LinkedHashMap<Character,Integer> map = new  LinkedHashMap<>();
            5
            6         for(int i = 0; i < str.length(); i++){
                7             if(!map.containsKey(str.charAt(i))){
                    8                 map.put(str.charAt(i),1);
                    9             }else{
                    10                 int t = map.get(str.charAt(i));
                    11                 map.put(str.charAt(i),++t);
                    12             }
                13         }
            14
            15         //返回字符串的位置
            16         for(int i = 0; i < str.length(); i++){
                17              if(map.get(str.charAt(i)) == 1){
                    18                return i;
                    19              }
                20         }
            21         return -1;
            22
            23     }
24 }
    复制代码


            数字在排序数组中出现的次数

    统计一个数字在排序数组中出现的次数。

    复制代码
 1 public class Solution {
 2     public int GetNumberOfK(int [] array , int k) {
            3        int sum = 0;
            4        for(int i = 0; i < array.length; i++){
                5            if(array[i] == k){
                    6                sum++;
                    7            }
                8        }
            9         return sum;
            10     }
11 }
    复制代码


            二叉树的深度

    输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

    复制代码
 1 */
/**
  2 public class TreeNode {
  3     int val = 0;
  4     TreeNode left = null;
  5     TreeNode right = null;
  6
  7     public TreeNode(int val) {
  8         this.val = val;
  9
  10     }
  11
  12 }
  13 *//*

         14 import java.util.Queue;
15 import java.util.LinkedList;
16 public class Solution {
17     public int TreeDepth(TreeNode root) {
            18         if(root == null){
                19             return 0;
                20         }
            21         int count = 0, depth = 0, nextCount = 1;
            22
            23         Queue<TreeNode> queue = new LinkedList<TreeNode>();
            24
            25         //将根节点添加到队列中
            26         queue.add(root);
            27
            28         //第一次循环时队列的长度为1
            29         while(queue.size()!=0){
                30             count++;
                31             //先进先出，取出队列的第一个元素
                32             TreeNode top = queue.poll();
                33             //如果根节点的左子树不为空，则将左子树的根节点添加到队列中
                34             if(top.left!=null){
                    35                 queue.add(top.left);
                    36             }
                37              //如果根节点的右子树不为空，则将右子树的根节点添加到队列中
                38              if(top.right!=null){
                    39                  queue.add(top.right);
                    40             }
                41             //当同一层的节点全部添加到队列中时，count与nextCount相等，deph+1
                42             if(count==nextCount){
                    43                 nextCount = queue.size();
                    44                 depth++;
                    45                 count=0;
                    46             }
                47         }
            48         return depth;
            49
            50     }
51 }
    复制代码


            平衡二叉树

    输入一棵二叉树，判断该二叉树是否是平衡二叉树。

    复制代码
 1 public class Solution {
 2     public boolean IsBalanced_Solution(TreeNode root) {
            3         if(root == null) {
                4             return true;
                5         }
            6         return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
                    7             IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
            8     }
 9
         10     private int maxDepth(TreeNode root) {
            11         if(root == null) {
                12             return 0;
                13         }
            14         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
            15     }
16 }
    复制代码


            数组中只出现一次的数字

    一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

    复制代码
 1 //num1,num2分别为长度为1的数组。传出参数
         2 //将num1[0],num2[0]设置为返回结果
         3 import java.util.*;
 4 public class Solution {
 5     public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            6        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
            7         for (int i = 0; i < array.length; i++) {
                8             if(map.containsKey(array[i])){
                    9                 int t = map.get(array[i]);
                    10                 map.put(array[i],++t);
                    11             }else {
                    12                 map.put(array[i],1);
                    13             }
                14         }
            15         int [] a = new int[2];
            16         int i = 0;
            17         for(int b : map.keySet()){
                18             if(map.get(b) == 1){
                    19                a[i] = b;
                    20                i++;
                    21             }
                22         }
            23         num1[0] = a[0];
            24         num2[0] = a[1];
            25     }
26 }
    复制代码


            左旋转字符串

    汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

    复制代码
 1 import java.util.*;
 2 public class Solution {
 3     public String LeftRotateString(String str,int n) {
            4         if(str.length() == 0 || n == 0){
                5             return str;
                6         }
            7         n = n % str.length();
            8         String s1 = str.substring(0,n);
            9         String s2 = str.substring(n,str.length());
            10         return s2+s1;
            11     }
12 }
    复制代码


            翻转单词顺序列

    牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

    复制代码
 1 import java.util.*;
 2 public class Solution {
 3     //单词翻转使用字符串数组实现
         4     public String ReverseSentence(String str) {
            5         //str.trim()，去掉字符串首尾的空格
            6         if(str.trim().equals("")){
                7             return str;
                8         }
            9         String [] s = str.split(" ");
            10         StringBuffer bf = new StringBuffer();
            11         for(int i = s.length; i > 0; i--){
                12             bf.append(s[i-1]);
                13            if(i > 1){
                    14                bf.append(" ");
                    15            }
                16         }
            17         return bf.toString();
            18     }
19 }
    复制代码


    孩子们的游戏（圆圈中最后剩下的数）

    每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

    如果没有小朋友，请返回-1
    复制代码
 1 public class Solution {
 2     public int LastRemaining_Solution(int n, int m) {
            3         if(n == 0){
                4             return -1;
                5         }
            6         if(n == 1){
                7             return 0;
                8         }
            9         return (LastRemaining_Solution(n-1,m)+m)%n;
            10     }
11 }
    复制代码


    求1+2+3+...+n

    求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

    复制代码
1 public class Solution {
2     public int Sum_Solution(int n) {
            3        int sum = n;
            4        boolean a = (n>0) && (sum = sum + Sum_Solution(n-1))>0;
            5        return sum;
            6     }
7 }
    复制代码


            把字符串转换成整数

    将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0







            复制代码
 1 public class Solution {
 2     public int StrToInt(String str) {
            3         if(str == null || str.equals("")||str.equals("-2147483649")){
                4             return 0;
                5         }
            6          int count = 0,flag = 0;
            7         for(int i = 0; i < str.length();i++){
                8             char c = str.charAt(i);
                9             if(i == 0){
                    10                  if((c == '+' || c == '-')&& str.length() <= 1){
                        11                      return 0;
                        12                  }
                    13                 if(c == '+' || c == '-'){
                        14                     count = 0;
                        15                     flag = 1;
                        16                 }else{
                        17                     if( c > 47 && c < 58  ){
                            18                        count++;
                            19                      }
                        20                   }
                    21             }else{
                    22                if( c > 47 && c < 58  ){
                        23                  count++;
                        24                }
                    25             }
                26
                27         }
            28         if(flag == 1 && (count+1) == str.length()){
                29             long a = Long.parseLong(str);
                30             if(a > Integer.MAX_VALUE){
                    31                 return 0;
                    32             }else{
                    33                 return  (int)a;
                    34             }
                35
                36         }else if(flag == 0 && count == str.length()) {
                37            long a = Long.parseLong(str);
                38             if(a > Integer.MAX_VALUE){
                    39                 return 0;
                    40             }else{
                    41                 return  (int)a;
                    42             }
                43         }else{
                44             return 0;
                45         }
            46     }
47 }
    复制代码


            表示数值的字符串

    请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

    复制代码
 1 public class Solution {
 2     public boolean isNumeric(char[] str) {
            3        try{
                4            double a = Double.parseDouble(new String(str));
                5        }catch(Exception e){
                6            return false;
                7        }
            8         return true;
            9     }
10 }
    复制代码


            删除链表中重复的结点

    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

    复制代码
 1 */
/*
 2  public class ListNode {
 3     int val;
 4     ListNode next = null;
 5
 6     ListNode(int val) {
 7         this.val = val;
 8     }
 9 }
10 *//*

         11 public class Solution {
12     public ListNode deleteDuplication(ListNode pHead)
13     {
            14         if(pHead == null || pHead.next == null){
                15             return pHead;
                16         }
            17
            18         //如果当前节点是重复节点
            19         if(pHead.val == pHead.next.val){
                20             ListNode node = pHead.next;
                21             while(node != null && node.val == pHead.val){ //跳过一样的节点
                    22                 node = node.next;
                    23             }
                24              return deleteDuplication(node);
                25         }else{
                26             pHead.next = deleteDuplication(pHead.next);
                27             return pHead;
                28         }
            29     }
30 }
    复制代码


            二叉搜索树的第k个结点

    给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。

    复制代码
 1 */
/*
 2 public class TreeNode {
 3     int val = 0;
 4     TreeNode left = null;
 5     TreeNode right = null;
 6
 7     public TreeNode(int val) {
 8         this.val = val;
 9
10     }
11
12 }
13 *//*

         14 //思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
         15 //     所以，按照中序遍历顺序找到第k个结点就是结果。
         16 public class Solution {
17     int count = 0;
18     TreeNode node = null;
19
        20     TreeNode KthNode(TreeNode pRoot, int k)
21     {
            22         if(pRoot == null){
                23             return pRoot;
                24         }
            25         KthNode(pRoot.left,k);
            26         count++;
            27         if(count == k){
                28             node = pRoot;
                29         }
            30         KthNode(pRoot.right,k);
            31         return node;
            32     }
33
        34
        35 }
    复制代码


            滑动窗口的最大值

    给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

    复制代码
 1 import java.util.*;
 2 public class Solution {
 3     public  ArrayList<Integer> maxInWindows(int [] num, int size)
 4     {
            5         int k = 0;
            6         ArrayList<Integer> res = new ArrayList<>();
            7         if (num == null||size <= 0 || num.length < size) {
                8             return res;
                9         }
            10         for(int i = 0; i < num.length-size+1; i++,k++){
                11             ArrayList<Integer> list = new ArrayList<>();
                12             for(int j = 0; j < size; j++){
                    13                 list.add(num[i]);
                    14                 i++;
                    15             }
                16             i = k;
                17             Collections.sort(list);
                18             res.add(list.get(list.size()-1));
                19         }
            20         return res;
            21     }
22 }
    ***/
}

