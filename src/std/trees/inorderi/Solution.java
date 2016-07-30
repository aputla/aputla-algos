package std.trees.inorderi;

import java.util.LinkedList;

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
    
    private static void inorder(Tree tree) {
        LinkedList<Tree> S = new LinkedList<Tree>();
        while (true) {
            while (tree != null) {
                S.push(tree);
                tree = tree.left;
            }
            if (S.isEmpty()) {
                break;
            } else {
                tree = S.pop();
                System.out.println(tree.value);
                tree = tree.right;
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree(1, new Tree(2), new Tree(3, new Tree(4), new Tree(5)));
        inorder(tree);
    }

}
