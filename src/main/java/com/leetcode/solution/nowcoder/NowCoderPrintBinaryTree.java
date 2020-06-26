package com.leetcode.solution.nowcoder;

import com.leetcode.solution.data.structure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author zhujunji
 */
public class NowCoderPrintBinaryTree {

    ArrayList<ArrayList<Integer>> levelList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        viewTree(pRoot,1);
        return levelList;
    }

    public void viewTree(TreeNode node, int level){
        if (node == null){
            return;
        }
        if(levelList.size() < level){
            ArrayList<Integer> valList = new ArrayList<>();
            valList.add(node.val);
            levelList.add(valList);
        }else {
            levelList.get(level - 1).add(node.val);
        }
        level++;
        viewTree(node.left,level);
        viewTree(node.right,level);
    }

    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(1);

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);

        treeNode1.left = new TreeNode(4);
        treeNode1.right = new TreeNode(5);

        treeNode2.left = new TreeNode(6);
        treeNode2.right = new TreeNode(7);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        ArrayList<ArrayList<Integer>> print = Print(treeNode);

        System.out.println(print);

    }
}
