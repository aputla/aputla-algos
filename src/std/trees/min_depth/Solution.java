package std.trees.min_depth;

public class Solution {
    private static class Tree {
        Tree left;
        Tree right;
        int value;
        
        public Tree(int value, Tree left, Tree right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
        
        public Tree(int value) {
            this.value = value;
        }
    }

    private static int minDepth(Tree tree) {
        if (tree == null) {
            return 0;
        }
        int dl = minDepth(tree.left);
        int dr = minDepth(tree.right);
        return 1 + Math.min(dl, dr);
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree(1, new Tree(2), new Tree(3, new Tree(4), new Tree(5)));
        System.out.println(minDepth(tree));
    }
}
