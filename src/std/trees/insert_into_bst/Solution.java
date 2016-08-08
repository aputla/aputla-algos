package std.trees.insert_into_bst;

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

    private static Tree insert(Tree root, int value) {
        if (root == null) {
            return new Tree(value);
        }
        if (value >= root.value) {
            root.right = insert(root.right, value);
            return root;
        } else {
            root.left = insert(root.left, value);
            return root;
        }
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree(3, new Tree(2), new Tree(5, new Tree(4), new Tree(6)));
        insert(tree, 1);
    }
}
