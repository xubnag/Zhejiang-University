package binaryTree;

import binaryTree.model.TreeNode;

import java.util.*;

/**
 * @author XuBang
 * @version 1.0
 * @date 2022/4/23 11:22 AM
 * @Description 中序遍历
 */
public class InorderTraversal {
}

/**
 * 方式一：递归的方式
 */
class SolutionF {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<Integer>();
        inorderRecursion(root, arrayList);
        return arrayList;
    }

    private void inorderRecursion(TreeNode root, List<Integer> arrayList) {
        if (root == null) {
            return;
        }
        inorderRecursion(root.left, arrayList);
        arrayList.add(root.val);
        inorderRecursion(root.right, arrayList);
    }
}

/**
 * 非递归方式：利用栈FIFO实现中序遍历
 */
class SolutionS {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        /**
         * 针对树结构：采用while
         */
        while(root!=null || !stack.isEmpty()){
            //当root不为空时，持续遍历
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //当root为空，stack不为空时
            root=stack.pop();
            arrayList.add(root.val);
            root=root.right;
        }
        return arrayList;
    }
}