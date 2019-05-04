package tree;

// 662 https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
/*
给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
输入:
    1-1,3-2,2-3,5-4,3-5,9-7
           1
         /   \
        3     2
       / \     \
      5   3     9

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。

输入:
   1-1,3-2,2-3,5-4
          1
         / \
        3   2
       /
      5
输出: 2
解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。

输入:
  1-1,3-2,2-3,5-4,9-7,6-8,7-15
          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
输出: 8
解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class WidthOfBinaryTree {

  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return dfsMax(new ArrayList<>(), root, 0, 1);
  }

  public int dfsMax(ArrayList<Integer> leftMostIndices, // 存储每层最左侧节点的起始index
                    TreeNode node, int depth, int index) {
    if (node == null) {
      return Integer.MIN_VALUE;
    }
    if (depth >= leftMostIndices.size()) {
      leftMostIndices.add(index);
    }
    return Math.max(index - leftMostIndices.get(depth) + 1,
        Math.max(dfsMax(leftMostIndices, node.left, depth + 1, index * 2),
            dfsMax(leftMostIndices, node.right, depth + 1, index * 2 + 1)));
  }

  public int widthOfBinaryTree2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int width = Integer.MIN_VALUE;
    LinkedList<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 1));
    while (!queue.isEmpty()) {
      int size = queue.size();
      Pair firstNode = queue.peek();
      int left = firstNode.getIndex();
      int right = firstNode.getIndex();
      while (size-- > 0) {
        Pair node = queue.poll();
        right = node.getIndex();
        if (node.getNode().left != null) {
          queue.add(new Pair(node.getNode().left, right * 2));
        }
        if (node.getNode().right != null) {
          queue.add(new Pair(node.getNode().right, right * 2 + 1));
        }
      }
      width = Math.max(width, right - left + 1);
    }
    return width;
  }

  class Pair {
    private TreeNode node;
    private int index;

    public Pair(TreeNode node, int index) {
      this.node = node;
      this.index = index;
    }

    public TreeNode getNode() {
      return node;
    }

    public int getIndex() {
      return index;
    }
  }

}
