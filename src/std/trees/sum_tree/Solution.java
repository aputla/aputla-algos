package std.trees.sum_tree;

public class Solution {
    private static class Tree {
        Tree left;
        Tree right;
        int value;

        Tree(int value) {
            this.value = value;
        }
    }
    
    private static int checkSumTree(Tree tree) {
        if (tree == null) {
            return 0;
        }
        int left = checkSumTree(tree.left);
        int right = checkSumTree(tree.right);
        
        if (left == -1 || right == -1) {
            return -1;
        } else if (left == 0 && right == 0) {
            return tree.value;
        } else if (left + right == tree.value) {
            return 2 * tree.value;
        } else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        Tree one = new Tree(10);
        Tree two = new Tree(3); two.left = new Tree(2); two.right = new Tree(1);
        Tree three = new Tree(2); three.left = new Tree(2);
        one.left = two;
        one.right = three;
        System.out.println(checkSumTree(one) >= 0);
    }
}
