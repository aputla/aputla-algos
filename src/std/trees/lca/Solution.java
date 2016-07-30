package std.trees.lca;

import java.util.ArrayList;
import java.util.List;

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
        
        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    private static List<Tree> path(Tree tree, int value) {
        if (tree == null) {
            return null;
        }   

        List<Tree> result = new ArrayList<Tree>();
        result.add(tree);

        if (tree.value == value) {
            return result;
        } else {
            for (Tree child : new Tree[] {tree.left, tree.right}) {
                List<Tree> list = path(child, value);
                if (list != null) {
                    result.addAll(list);
                    return result;
                }
            }
        }
        return null;
    }

    private static Tree leastCommonAncestor(Tree tree, int a, int b) {
        List<Tree> one = path(tree, a);
        List<Tree> two = path(tree, b);
        int n = Math.min(one.size(), two.size());

        Tree result = one.get(0);
        for (int i = 1; i < n; i++) {
            if (one.get(i).value == two.get(i).value) {
                result = one.get(i);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree(2, new Tree(1), new Tree(4, new Tree(3), new Tree(5)));
        System.out.println(leastCommonAncestor(tree, 1, 3));
    }
}
