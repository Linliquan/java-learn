package publictest;

public class Code {
    /**


     1.两个数之和
     给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
     你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
     假设给出的数组中只存在唯一解
     例如：
     给出的数组为 {2, 7, 11, 15},目标值为9
     输出 ndex1=1, index2=2  (所有的代码在牛客网的LeetCode板块运行)

     复制代码
     1 public class Solution {
     2     public int[] twoSum(int[] nums, int target) {
     3
     4         int index1 = 0,index2 =0;
     5         int sum = target;
     6
     7         for(int i = 0; i < nums.length; i++){
     8             for(int j = i+1; j < nums.length; j++){
     9                     if (sum == nums[i]+ nums[j]){
     10                         index1 = i;
     11                         index2 = j;
     12                     }
     13             }
     14         }
     15         int [] b ={index1+1,index2+1};
     16         return b;
     17     }
     18 }
     复制代码




     2.反转整数

     将给出的整数x翻转。
     例1:x=123，返回321
     例2:x=-123，返回-321

     你有思考过下面的这些问题么？
     如果整数的最后一位是0，那么输出应该是什么？比如10,100
     你注意到翻转后的整数可能溢出吗？假设输入是32位整数，则将翻转10000000003就会溢出，你该怎么处理这样的样例？抛出异常？这样做很好，但是如果不允许抛出异常呢？这样的话你必须重新设计函数（比如添加一个额外的参数）。

     复制代码
     1 public class Solution {
     2        public int reverse(int x) {
     3         if(x == 0){
     4             return 0;
     5         }else if(x < 0){
     6             String str = String.valueOf(x);
     7             StringBuffer bf = new StringBuffer(str.substring(1,str.length()));
     8             String s = new String(bf.reverse());
     9             return Integer.parseInt("-"+s);
     10         }else {
     11             StringBuffer bf = new StringBuffer(String.valueOf(x));
     12             String s = new String(bf.reverse());
     13             return Integer.parseInt(s);
     14         }
     15     }
     16 }
     复制代码




     14.编写一个函数来查找字符串数组中的最长公共前缀。

     复制代码
     1 public class Solution {
     2     //水平
     3     public String longestCommonPrefix(String[] strs) {
     4         if(strs == null || strs.length == 0){
     5             return "";
     6         }
     7         int max = strs[0].length() -1;
     8         for(int i = 1; i < strs.length; i++){
     9             int s = -1;
     10             while(s < max && s < strs[i].length()-1){
     11                 if(strs[0].charAt(s+1) == strs[i].charAt(s+1)){
     12                     s++;
     13                 }else{
     14                     break;
     15                 }
     16             }
     17             if(s == -1){
     18                 return "";
     19             }
     20             max = s;
     21         }
     22         return strs[0].substring(0,max+1);
     23     }
     24 }
     复制代码




     20.给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。

     复制代码
     1 import java.util.*;
     2 public class Solution {
     3     public boolean isValid(String s) {
     4         if(s == null || s.length() == 0){
     5             return false;
     6         }
     7         Stack<Character> stack = new Stack<>();
     8         char [] c = s.toCharArray();
     9         for(int i = 0; i < s.length(); i++){
     10             if(c[i] == '('){
     11                 stack.push(')');
     12             }else if(c[i] == '{'){
     13                  stack.push('}');
     14             }else if(c[i] == '['){
     15                  stack.push(']');
     16             }else if(stack.empty() || c[i] != stack.pop()){
     17                 return false;
     18             }
     19         }
     20         return stack.empty();
     21     }
     22 }
     复制代码




     21.将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。

     复制代码
     1 /**
     2  * Definition for singly-linked list.
     3  * public class ListNode {
     4  *     int val;
     5  *     ListNode next;
     6  *     ListNode(int x) {
     7  *         val = x;
     8  *         next = null;
     9  *     }
     10  * }
     11

12 public class Solution {
13     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            14         ListNode heap = new ListNode(0);
            15         ListNode p = heap;
            16         while(l1 != null && l2 != null){
                17             if(l1.val <= l2.val){
                    18                 p.next = l1;
                    19                 l1 = l1.next;
                    20             }else{
                    21                 p.next = l2;
                    22                 l2 = l2.next;
                    23             }
                24             p = p.next;
                25         }
            26         if(l1 !=null){
                27             p.next = l1;
                28         }
            29         if(l2 != null){
                30             p.next = l2;
                31         }
            32         return heap.next;
            33     }
34 }
    复制代码 ***/
    /**


 26.给定一个已排序的数组，使用就地算法将重复的数字移除，使数组中的每个元素只出现一次，返回新数组的长度。

    不能为数组分配额外的空间，你必须使用常熟级空间复杂度的就地算法。
    例如，
    给定输入数组 A=[1,1,2]，

    你给出的函数应该返回length=2，A数组现在是[1,2]。
    复制代码
 1 public class Solution {
 2     public int removeDuplicates(int[] A) {
            3         if(A.length == 0 || A.length == 1){
                4             return A.length;
                5         }
            6         int k = 0;
            7         for(int i = 1; i < A.length; i++){
                8             if(A[k] != A[i]){
                    9                  A[++k]= A[i];
                    10             }
                11         }
            12         return k+1;
            13     }
14 }
    复制代码


28.实现函数 strStr。

    函数声明如下：
    char *strStr(char *haystack, char *needle)
    返回一个指针，指向needle第一次在haystack中出现的位置，如果needle不是haystack的子串，则返回null。
    复制代码
 1 public class Solution {
 2     public String strStr(String haystack, String needle) {
            3         int index = haystack.indexOf(needle);
            4         if(index < 0){
                5             return null;
                6         }else{
                7             return haystack.substring(index,haystack.length());
                8         }
            9     }
10 }
    复制代码




53.请计算给出的数组（至少含有一个数字）中具有最大和的子数组（子数组要求在原数组中连续）

    例如：给出的数组为[−2,1,−3,4,−1,2,1,−5,4],
    子数组[−2,1,−3,4,−1,2,1,−5,4],具有最大的和:6.
    复制代码
 1 public class Solution {
 2     public int maxSubArray(int[] array) {
            3          if(array.length == 0){
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


69.实现函数 int sqrt(int x). 计算并返回x的平方根

1 public class Solution {
2     public int sqrt(int x) {
            3         return (int)Math.sqrt(x);
            4     }
5 }


 70.你在爬楼梯，需要n步才能爬到楼梯顶部

    每次你只能向上爬1步或者2步。有多少种方法可以爬到楼梯顶部？
    复制代码
 1 public class Solution {
 2     public int climbStairs(int n) {
            3         if( n <= 2 ){
                4             return n;
                5         }
            6         int [] s = new int[n+1];
            7         s[0] = 0;
            8         s[1] = 1;
            9         s[2] = 2;
            10         for(int i = 3; i < s.length;i++){
                11             s[i] = s[i-1]+s[i-2];
                12         }
            13         return s[n];
            14     }
15 }
    复制代码




88.给出两个有序的整数数组A和B，请将数组B合并到数组A中，变成一个有序的数组

    注意：可以假设A数组有足够的空间存放B数组的元素，A和B中初始的元素数目分别为m和n
            复制代码
 1 import java.util.*;
 2 public class Solution {
 3     public void merge(int A[], int m, int B[], int n) {
            4         int i = m -1, j = n - 1, index = m+n-1;
            5         while(i >= 0 && j >= 0){
                6             A[index--] = A[i] >=  B[j] ? A[i--] : B[j--];
                7         }
            8         while(j >=0){
                9             A[index--] = B[j--];
                10         }
            11     }
12 }
    复制代码




104.求给定二叉树的最大深度，

    最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
    复制代码
 1 /**
  2  * Definition for binary tree
  3  * public class TreeNode {
  4  *     int val;
  5  *     TreeNode left;
  6  *     TreeNode right;
  7  *     TreeNode(int x) { val = x; }
  8  * }
  9
         10 import java.util.*;
11 public class Solution {
12     public int maxDepth(TreeNode root) {
            13          if(root == null){
                14             return 0;
                15         }
            16         int count = 0, depth = 0, nextCount = 1;
            17
            18         Queue<TreeNode> queue = new LinkedList<TreeNode>();
            19
            20         //将根节点添加到队列中
            21         queue.add(root);
            22
            23         //第一次循环时队列的长度为1
            24         while(queue.size()!=0){
                25             count++;
                26             //先进先出，取出队列的第一个元素
                27             TreeNode top = queue.poll();
                28             //如果根节点的左子树不为空，则将左子树的根节点添加到队列中
                29             if(top.left!=null){
                    30                 queue.add(top.left);
                    31             }
                32              //如果根节点的右子树不为空，则将右子树的根节点添加到队列中
                33              if(top.right!=null){
                    34                  queue.add(top.right);
                    35             }
                36             //当同一层的节点全部添加到队列中时，count与nextCount相等，deph+1
                37             if(count==nextCount){
                    38                 nextCount = queue.size();
                    39                 depth++;
                    40                 count=0;
                    41             }
                42         }
            43         return depth;
            44     }
45 }
    复制代码




136.现在有一个整数类型的数组，数组中素只有一个元素只出现一次，其余的元素都出现两次。

    注意：你需要给出一个线性时间复杂度的算法，你能在不使用额外内存空间的情况下解决这个问题么？
    复制代码
 1 public class Solution {
 2     public int singleNumber(int[] A) {
            3         //思路：两个相同的数异或为0
            4         //例子:1^2^3^4^4^3^2 = 2^2^3^3^4^4^1 = 1
            5         int result = A[0];
            6         for(int i = 1; i < A.length; i++){
                7             result = result ^ A[i];
                8         }
            9         return result;
            10     }
11 }

     *****/

}
