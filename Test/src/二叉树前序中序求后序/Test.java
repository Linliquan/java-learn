package 二叉树前序中序求后序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

    //二叉树前序中序重建二叉树,--有误待纠正
    public  TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);

        for(int i = 0; i < pre.length; i++){
            if(pre[0] == in[i]){
                node.left = this.reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1), Arrays.copyOfRange(in,0,i));

                node.right = this.reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));

            }
        }
        return node;
    }

    //二叉树中序后序重建二叉树,
    public  TreeNode endReConstructBinaryTree(int [] in,int [] end) {
        if(in.length == 0 || in.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(end[end.length-1]);

        for(int i = 0; i < end.length; i++){
            if(end[end.length-1] == in[i]){
                node.left = this.reConstructBinaryTree(Arrays.copyOfRange(in,0,i), Arrays.copyOfRange(end,0,i));

                node.right = this.reConstructBinaryTree(Arrays.copyOfRange(in,i+1,in.length),Arrays.copyOfRange(end,i,in.length-1));

            }
        }
        return node;
    }

    //层次遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            list.add(node.val);
        }
        return list;
    }

    //前序遍历
    public static void preTraversal(TreeNode node,ArrayList<Integer> list){
        list.add(node.val);
        if(node.left != null){
            preTraversal(node.left,list);
        }
        if(node.right != null){
            preTraversal(node.right,list);
        }
    }

    //遍历的方法
    public ArrayList<Integer>  traversal(TreeNode node){
        ArrayList<Integer> list = new ArrayList<>();
        if(node == null){
            return list;
        }
        preTraversal(node, list);
        return list;
    }

    public static void main(String[] args) {

        //前序中序
        int [] a = {2,4,9,10,8,5,7};
        int [] b = {9,4,10,2,5,8,7};
//        //中序后序
//        int [] a = {9,4,10,2,5,8,7};
//        int [] b = {9,10,4,5,7,8,2};
        Test test = new Test();
        //重建二叉树
        TreeNode node = test.reConstructBinaryTree(a,b);

//        //重建二叉树-中后序
//        TreeNode node = test.endReConstructBinaryTree(a,b);

        //层次遍历
        System.out.println("层次遍历："+test.PrintFromTopToBottom(node));

        //前序遍历
        System.out.println(test.traversal(node));




    }
}
