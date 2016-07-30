package std.trees.preorderi;

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
    
    private static void preorder(Tree tree) {
        LinkedList<Tree> S = new LinkedList<>();
        S.push(tree);
        while (!S.isEmpty()) {
            Tree current = S.pop();
            System.out.println(current.value);
            if (current.right != null) {
                S.push(current.right);
            }
            if (current.left != null) {
                S.push(current.left);
            }
        }
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree(1, new Tree(2), new Tree(3, new Tree(4), new Tree(5)));
        preorder(tree);
    }
}
